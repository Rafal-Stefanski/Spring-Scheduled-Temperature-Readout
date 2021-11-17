package com.rafalstefanski.repository;

import com.rafalstefanski.dto.WeatherDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static com.rafalstefanski.mapping.TableMapping.TABLE_NAME;


@Repository
public interface WeatherRepo extends JpaRepository<WeatherDto, Long> {

    @Query(value = "SELECT * FROM " + TABLE_NAME + " WHERE id=(SELECT MAX(id) FROM " + TABLE_NAME + ")", nativeQuery = true)
    WeatherDto findLast();
}
