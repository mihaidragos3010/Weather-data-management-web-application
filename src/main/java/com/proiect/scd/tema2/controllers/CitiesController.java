package com.proiect.scd.tema2.controllers;

import com.proiect.scd.tema2.dto.CityDto;
import com.proiect.scd.tema2.entities.City;
import com.proiect.scd.tema2.entities.Country;
import com.proiect.scd.tema2.services.CityService;
import com.proiect.scd.tema2.services.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CitiesController {

    private final CityService cityService;
    private final CountryService countryService;

    @PostMapping("cities")
    public ResponseEntity<?> addCity(@Valid @RequestBody CityDto cityDto){

        Optional<Country> country = countryService.getCountryById(cityDto.getIdCountry());

        if(country.isPresent()) {
            Integer idCity = cityService.addCity(cityDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Map.of("id", idCity));
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("cities")
    public ResponseEntity<?> getAllCities(){

        List<CityDto> cities = cityService.getAllCities();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cities);
    }

    @GetMapping("cities/country/")
    public ResponseEntity<?> getCitiesWithoutCountry() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Collections.emptyList());
    }

    @GetMapping("cities/country/{idCountry}")
    public ResponseEntity<?> getCitiesByCountry(@PathVariable Integer idCountry) {
        List<CityDto> cities = cityService.getCitiesByIdCountry(idCountry);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cities);
    }

    @PutMapping("cities/{id}")
    public ResponseEntity<?> updateCity(@PathVariable Integer id, @Valid @RequestBody CityDto updatedCity) {

        /* Check updated city data has same id as PathVariable id */
        if(updatedCity.getId() == null|| !updatedCity.getId().equals(id)){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        Optional<City> city = cityService.getCityById(id);
        Optional<Country> country = countryService.getCountryById(updatedCity.getIdCountry());

        /* Check that city & country are found in database */
        if(city.isPresent() && country.isPresent()){
            cityService.updateCity(updatedCity);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping("cities/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Integer id) {

        Optional<City> city = cityService.getCityById(id);

        if(city.isPresent()){
            cityService.deleteCity(city.get());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
