package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name not empty")
    private String name;
    @Size(min = 1, message = "Enter a positive number")
    private double area;
    @Size(min = 1, message = "Enter a positive number")
    private Long population;
    @Size(min = 1, message = "Enter a positive number")
    private Double gdp;
    @NotEmpty(message = "Description not empty")
    private String description;

    @ManyToOne
    private com.example.demo.model.Country country;

    public City() {
    }


    public City(Long id, String name, double area, Long population, Double gdp, String description, com.example.demo.model.Country country) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameCity) {
        this.name = nameCity;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.example.demo.model.Country  getCountry() {
        return country;
    }

    public void setCountry(com.example.demo.model.Country country) {
        this.country = country;
    }
}
