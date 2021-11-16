package com.rafalstefanski.api;

import com.rafalstefanski.dto.WeatherDto;
import com.rafalstefanski.repository.WeatherRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temp-api")
public class WeatherApi {

    private final WeatherRepo weatherRepo;

    public WeatherApi(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @GetMapping
    public List<WeatherDto> getTemp() {
        return weatherRepo.findAll();
    }
}
