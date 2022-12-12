package com.digitalbooks.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.digitalbooks.exceptions.BookAlreadyExistsException;
import com.digitalbooks.exceptions.NoSuchBookExistsException;
import com.digitalbooks.model.Book;
import com.digitalbooks.model.User;
import com.digitalbooks.repository.BookRepository;

@Service
public class BookCreationService 
{
@Autowired
BookRepository bookRepository;

public List<Book> getAllBooks() //Search operation performed by Author or reader
{
List<Book> book = new ArrayList<Book>();
bookRepository.findAll().forEach(books -> book.add(books));
return book;
}

public Book getBooksById(int id) //Search operation based on bookid
{
return bookRepository.findById(id).get();
}

public List<Book> getBooksByParam(String Title,String category,String author,int price,String publisher) //Search operation based on 4 parameters
{
	List<Book> book = new ArrayList<Book>();
	bookRepository.findAll().forEach(books ->{ 
		if(books.getBook_title().equalsIgnoreCase(Title) && books.getAuthor_name().equalsIgnoreCase(author)
				&& (books.getPrice()==price) && books.getPublisher().equalsIgnoreCase( publisher))
		book.add(books);
		});
	return book;
}

public String save(Book book) //Create new book
{
	Book existingBook
	 = bookRepository.findById(book.getBook_id())
     .orElse(null);
bookRepository.save(book);
	if (existingBook == null) {
		bookRepository.save(book);
        return "Book added successfully";
    }
    else
        throw new BookAlreadyExistsException(
            "Book already exists!!");
}
public String store(MultipartFile file ,Book book) throws IOException {
	Book existingBook= bookRepository.findById(book.getBook_id())
    .orElse(null);
    //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    byte[] logo=file.getBytes();
   book.setLogo(logo);
   bookRepository.save(book);
   if (existingBook == null) {
		bookRepository.save(book);
       return "Book added successfully";
   }
   else
       throw new BookAlreadyExistsException(
           "Book already exists!!");
}



public void delete(int id) 
{
	bookRepository.deleteById(id);
}

public String update(Book book, int bookid) //Update Book based on bookid
{
	bookRepository.save(book);
	
	Book existingBook
    = bookRepository.findById(book.getBook_id()).orElse(null);
if (existingBook == null)
    throw new NoSuchBookExistsException(
        "No Such Book exists!!");
else {
	
	bookRepository.save(existingBook );
    return "Record updated Successfully";
}
}

@Autowired
RestTemplate restTemplate;

public User getUserById(long authorId) {
	return restTemplate.getForObject("http://localhost:8000/api/vi/digitalbooks/userDetailsById/"+authorId,User.class);
}


}