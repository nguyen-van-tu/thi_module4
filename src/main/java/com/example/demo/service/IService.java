package com.example.demo.service;

import java.util.List;

public interface IService<T> {
    List<T> findALl();

    T findById(Long id);

    T save(T t);

    void remove(Long id);

    List<T> findByName(String name);
}
