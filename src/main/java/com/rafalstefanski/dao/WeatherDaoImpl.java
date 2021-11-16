package com.rafalstefanski.dao;

import com.rafalstefanski.dto.WeatherDto;
import com.rafalstefanski.model.OpenWeather;
import com.rafalstefanski.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Repository
public class WeatherDaoImpl implements WeatherDao {


    @Value("${weather-repository.openWeatherApi}")
    private String openWeatherApi;
    @Value("${weather-repository.cityId}")
    private String cityId;
    @Value("${weather-repository.cityName}")
    private String cityName;
    @Value("${weather-repository.lang}")
    private String lang;

    public String getDateAndHour() {
        return LocalDateTime.now().toString();
    }

    private final WeatherRepo weatherRepo;

    @Autowired
    public WeatherDaoImpl(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @Override
    public OpenWeather getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject("https://api.openweathermap.org/data/2.5/weather?id=" +
                                       cityId + "&lang=" + lang + "&appid=" + openWeatherApi + "&units=metric", OpenWeather.class);
    }

    @Override
    public WeatherDto convertWeather() {
        OpenWeather weatherApi = getWeather();
        return new WeatherDto(cityName, getDateAndHour().substring(0, 10), getDateAndHour().substring(11, 19), weatherApi.getMain().getTemp(), weatherApi.getMain().getFeelsLike(), weatherApi.getWeather()
                .toString().substring(1, weatherApi.getWeather().toString().length() -1));
    }

    @Override
    @Scheduled(fixedDelayString = "${weather-repository.delay}")
    public void saveWeatherToDataBase() {
        weatherRepo.save(convertWeather());
        System.out.println(weatherRepo.findLast());

    }
}
