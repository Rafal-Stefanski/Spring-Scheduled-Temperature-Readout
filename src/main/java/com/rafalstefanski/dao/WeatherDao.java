package com.rafalstefanski.dao;


import com.rafalstefanski.dto.WeatherDto;
import com.rafalstefanski.model.OpenWeather;

public interface WeatherDao {

    OpenWeather getWeather();

    WeatherDto convertWeather();

    void saveWeatherToDataBase();
}
