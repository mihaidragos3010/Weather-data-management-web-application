package com.proiect.scd.tema2.repositories;

import com.proiect.scd.tema2.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByIdCountry(Integer idCountry);

    List<City> findByLatitude(Double latitude);

    List<City> findByLongitude(Double longitude);

    List<City> findByLatitudeAndLongitude(Double latitude, Double longitude);
}
