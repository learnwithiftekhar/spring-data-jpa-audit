package com.learnwithiftekhar.auditing.repository;

import com.learnwithiftekhar.auditing.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
