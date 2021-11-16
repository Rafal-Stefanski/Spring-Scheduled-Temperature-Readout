package com.rafalstefanski.repository;

import com.rafalstefanski.dto.WeatherDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WeatherRepo extends JpaRepository<WeatherDto, Long> {

    @Query(value = "SELECT * FROM temperature_readout WHERE id=(SELECT MAX(id) FROM temperature_readout)", nativeQuery = true)
    WeatherDto findLast();
}
