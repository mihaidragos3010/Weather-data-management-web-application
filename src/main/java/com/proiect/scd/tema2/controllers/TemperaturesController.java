package com.proiect.scd.tema2.controllers;

import com.proiect.scd.tema2.dto.TemperatureDto;
import com.proiect.scd.tema2.entities.City;
import com.proiect.scd.tema2.entities.Temperature;
import com.proiect.scd.tema2.services.CityService;
import com.proiect.scd.tema2.services.TemperatureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class TemperaturesController {

    private final CityService cityService;
    private final TemperatureService temperatureService;

    @PostMapping("temperatures")
    public ResponseEntity<?> addTemperature(@Valid @RequestBody TemperatureDto temperatureDto){

        Optional<City> city = cityService.getCityById(temperatureDto.getIdCity());

        if(city.isPresent()) {
            Integer idTemperature = temperatureService.addTemperature(temperatureDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Map.of("id", idTemperature));
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("temperatures")
    public ResponseEntity<?> getTemperaturesByLatitudeAndLongitude(
            @RequestParam(required = false) Optional<Double> lat,
            @RequestParam(required = false) Optional<Double> lon,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> until) {

        List<TemperatureDto> response = temperatureService.getTemperatures(lat, lon, from, until);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("temperatures/cities/")
    public ResponseEntity<List<Temperature>> getTemperaturesByCityDummy() {

        // If no date parameters are provided, return an empty list
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Collections.emptyList());
    }

    @GetMapping("temperatures/cities/{idCity}")
    public ResponseEntity<?> getTemperaturesByCity(
            @PathVariable Integer idCity,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> until) {

        List<TemperatureDto> response = temperatureService.getTemperaturesByCity(idCity, from, until);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("temperatures/countries/")
    public ResponseEntity<List<Temperature>> getTemperaturesByCountryDummy() {

        // If no date parameters are provided, return an empty list
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Collections.emptyList());
    }


    @GetMapping("temperatures/countries/{idCountry}")
    public ResponseEntity<?> getTemperaturesByCountry(
            @PathVariable Integer idCountry,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> until) {

        List<TemperatureDto> response = temperatureService.getTemperaturesByCountry(idCountry, from, until);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("temperatures/{id}")
    public ResponseEntity<?> updateTemperature(@PathVariable Integer id, @Valid @RequestBody TemperatureDto updatedTemperatureDto) {

        /* Check updated city data has same id as PathVariable id */
        if(updatedTemperatureDto.getId() == null || !updatedTemperatureDto.getId().equals(id)){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        Optional<Temperature> temperature = temperatureService.getTemperatureById(id);
        Optional<City> city = cityService.getCityById(updatedTemperatureDto.getIdCity());

        /* Check that city & country are found in database */
        if(temperature.isPresent() && city.isPresent()){
            temperatureService.updateTemperature(updatedTemperatureDto);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping("temperatures/{id}")
    public ResponseEntity<?> deleteTemperature(@PathVariable Integer id) {

        Optional<Temperature> temperature = temperatureService.getTemperatureById(id);

        if(temperature.isPresent()){
            temperatureService.deleteTemperature(temperature.get());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

}
