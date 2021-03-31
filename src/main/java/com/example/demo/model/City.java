package com.example.demo.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min =1 , max = 1000)
    private String name;
    @NumberFormat
    @Min(1)
    private double area;
    @NumberFormat
    @Min(1)
    private long population;
    @NumberFormat
    @Min(1)
    private double gdp;
    @NotNull
    @Size(min = 1)
    private String description;
    @ManyToOne
    private Country country;



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
