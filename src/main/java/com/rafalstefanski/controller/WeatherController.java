package com.rafalstefanski.controller;

import com.rafalstefanski.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    private final WeatherRepo weatherRepo;

    @Autowired
    public WeatherController(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @GetMapping
    public String getTemp(Model model) {
        model.addAttribute("temperatureRead", weatherRepo.findAll());
        model.addAttribute("lastValue", weatherRepo.findLast());
        return "temperature-readout";
    }
}
