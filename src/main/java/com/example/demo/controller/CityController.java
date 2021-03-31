package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.city.CityService;
import com.example.demo.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

  @ModelAttribute("country")
  Iterable<Country> countries(){
    return countryService.findAll();
  }

    @GetMapping("")
    public ModelAndView fillAll() {
        List<City> list = cityService.findALl();
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("city", list);
        return modelAndView;

    }

    @GetMapping("/view/{id}")
    public ModelAndView details(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("city/view");
        City city = cityService.findById(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView= new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("country",countryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute City city){
        ModelAndView modelAndView= new ModelAndView("city/create");
        cityService.save(city);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("mess", "Thêm mới thành công thành phố: " + city.getName());

        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        City city = cityService.findById(id);
        ModelAndView modelAndView= new ModelAndView("city/edit");
        modelAndView.addObject("city",city);
//        modelAndView.addObject("country",countryService.findAll());
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, @ModelAttribute City city) {
        city.setId(id);
        cityService.save(city);
        return new ModelAndView("redirect:/cities");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        cityService.remove(id);
        modelAndView.addObject("city",cityService.findALl());
        return modelAndView;
    }

}
