package com.example.ducks_service.repository;

import com.example.ducks_service.model.Ducks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckRepository extends CrudRepository<Ducks, Integer> {
}
