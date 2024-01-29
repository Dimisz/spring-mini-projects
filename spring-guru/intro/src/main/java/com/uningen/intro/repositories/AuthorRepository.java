package com.uningen.intro.repositories;

import com.uningen.intro.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
