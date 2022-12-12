package com.digitalbooks.controller;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digitalbooks.exceptions.BookAlreadyExistsException;
import com.digitalbooks.exceptions.ErrorResponse;
import com.digitalbooks.model.Book;
import com.digitalbooks.model.User;
import com.digitalbooks.repository.BookRepository;
import com.digitalbooks.service.BookCreationService;
import com.digitalbooks.utilities.UserURIConstants;
import com.digitalbooks.message.ResponseMessage;

@RestController
@RequestMapping("/api/v1/digitalbooks/")
public class BookController
{

	
	Logger logger= LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookCreationService bookService;
	@Autowired
	BookRepository repo;


	@GetMapping(value=UserURIConstants.BookSearch)
	private List<Book> getAllBooks() 
	{
		return bookService.getAllBooks();

	}

	@GetMapping(value=UserURIConstants.BookSearchById)
	private Book getBookById(@PathVariable("id") int id) 
	{
		return bookService.getBooksById(id);
	}

	@DeleteMapping(value=UserURIConstants.deleteBook)
	private void deleteBook(@PathVariable("id") int id) 
	{
		bookService.delete(id);
	}

	/*
	 * @PostMapping(value=UserURIConstants.saveBook) private int
	 * saveBook(@RequestBody Book book) { bookService.save(book); return
	 * book.getBook_id(); }
	 */
	
	@PostMapping(value=UserURIConstants.saveBook)
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file ,@RequestBody Book book) throws IOException {
	    String message = ""; 
	    byte[] logo=file.getBytes();
	    book.setLogo(logo);
	    try {
	    	bookService.store(file ,book);
	    	message = "Uploaded the book successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the book: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	

	@PutMapping(value=UserURIConstants.updateBookByID)
	private Book updateBook(@PathVariable("id") int bookid ,@RequestBody Book book) 
	{
		bookService.update(book, bookid);
		return book;
	}
	
	@ExceptionHandler(value
			= BookAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse
	handleCustomerAlreadyExistsException(
			BookAlreadyExistsException ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(),
				ex.getMessage());
	}
	@PostMapping("/author/{authorId}/books/{bookId}/block")
	public ResponseEntity<?> blockAndUnBlockBook(@PathVariable Long authorId,@PathVariable Long bookId,@RequestParam String block) {
		boolean blockStatus = true;
		User user = bookService.getUserById(authorId);
		Book book = repo.findByIdAndAuthorname(bookId,user.getUsername());
		if(Objects.isNull(book)) {
			return ResponseEntity
					.badRequest()
					.body(new ResponseMessage("Error: Book Not Found!",false));
		}
		if(block.equalsIgnoreCase("yes")) 
			blockStatus = false;
		if(book.getIsActive() == blockStatus) {
			return ResponseEntity
					.badRequest()
					.body(new ResponseMessage("Error: Book is already blocked!",false));
		}
		book.setIsActive(blockStatus);
		repo.save(book);
		if(!blockStatus) {
			return ResponseEntity.ok(new ResponseMessage("Book Blocked!",true));
		} else {
			return ResponseEntity.ok(new ResponseMessage("Book Un-Blocked!",true));
		}
	}
}
