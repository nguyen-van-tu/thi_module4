package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @GetMapping("")
    public ModelAndView getAll() {
        List<Country> list = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("country/list");
        modelAndView.addObject("country", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("country/create");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Country country){
        ModelAndView modelAndView= new ModelAndView("country/create");
        countryService.save(country);
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("mess", "Thêm mới thành công quốc gia: " + country.getName());

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        countryService.remove(id);
        modelAndView.addObject("city",countryService.findAll());
        return modelAndView;
    }

}
