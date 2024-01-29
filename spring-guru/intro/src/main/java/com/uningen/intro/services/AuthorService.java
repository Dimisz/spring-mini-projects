package com.uningen.intro.services;

import com.uningen.intro.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
