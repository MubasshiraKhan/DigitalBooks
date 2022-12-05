package com.digitalbooks.repository;
import org.springframework.data.repository.CrudRepository;

import com.digitalbooks.model.Book;
public interface BookRepository extends CrudRepository<Book, Integer>
{
}
