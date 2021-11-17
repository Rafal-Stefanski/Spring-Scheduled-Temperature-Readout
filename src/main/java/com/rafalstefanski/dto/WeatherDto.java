package com.rafalstefanski.dto;

import javax.persistence.*;

import static com.rafalstefanski.mapping.TableMapping.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class WeatherDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String date;
    private String hour;
    private double currentTemp;
    private double sensedTemp;
    private String description;

    public WeatherDto() {
    }

    public WeatherDto(String city, String date, String hour, double currentTemp, double sensedTemp, String description) {
        this.city = city;
        this.date = date;
        this.hour = hour;
        this.currentTemp = currentTemp;
        this.sensedTemp = sensedTemp;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getSensedTemp() {
        return sensedTemp;
    }

    public void setSensedTemp(double sensedTemp) {
        this.sensedTemp = sensedTemp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather in " + city +
                ", '" + date + '\'' +
                ", at: '" + hour + '\'' +
                ", current temp: " + currentTemp +
                "°C, sensed temp: " + sensedTemp +
                "°C, '" + description + '\'';
    }
}
