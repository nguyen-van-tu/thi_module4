package com.example.demo.service.country;

import com.example.demo.model.Country;

import java.util.List;

public interface ICountryService  {
    List<Country> findAll();

    Country save(Country country);

    void remove(Long id);
}
