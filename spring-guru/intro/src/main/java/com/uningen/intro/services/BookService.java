package com.uningen.intro.services;

import com.uningen.intro.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
