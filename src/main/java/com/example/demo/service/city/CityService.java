package com.example.demo.service.city;

import com.example.demo.model.City;
import com.example.demo.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService implements ICityService{
    @Autowired
    private ICityRepository cityRepository;
    @Override
    public List<City> findALl() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);

    }

    @Override
    public List<City> findByName(String name) {
        return null;
    }
}
