package com.uningen.intro.repositories;

import com.uningen.intro.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
