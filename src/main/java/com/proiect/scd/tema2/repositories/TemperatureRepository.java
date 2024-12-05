package com.proiect.scd.tema2.repositories;

import com.proiect.scd.tema2.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {

    List<Temperature> findByIdCity(Integer idCity);

    @Query("SELECT t FROM Temperature t WHERE t.city.id = :cityId AND t.timestamp >= :fromDate")
    List<Temperature> findFromDate(@Param("cityId") Integer cityId, @Param("fromDate") Date fromDate);

    @Query("SELECT t FROM Temperature t WHERE t.city.id = :cityId AND t.timestamp <= :untilDate")
    List<Temperature> findUntilDate(@Param("cityId") Integer cityId, @Param("untilDate") Date untilDate);

    @Query("SELECT t FROM Temperature t WHERE t.city.id = :cityId AND t.timestamp BETWEEN :fromDate AND :untilDate")
    List<Temperature> findBetweenDates(@Param("cityId") Integer cityId, @Param("fromDate") Date fromDate, @Param("untilDate") Date untilDate);
}
