package com.digitalbooks.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.digitalbooks.model.Book;
public interface BookRepository extends CrudRepository<Book, Integer>
{
	//boolean existsBycode(String book_code);

	@Query(value ="from Book where id = :bookId and authorname = :username")
	Book findByIdAndAuthorname(@Param("bookId") Long bookId, @Param("username") String username);

}
