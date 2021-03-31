package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface ICountryRepository extends CrudRepository<Country , Long> {
}
