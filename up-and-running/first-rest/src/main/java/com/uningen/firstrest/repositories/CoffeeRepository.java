package com.uningen.firstrest.repositories;

import com.uningen.firstrest.domain.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
