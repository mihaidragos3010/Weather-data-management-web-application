package com.proiect.scd.tema2.controllers;

import com.proiect.scd.tema2.dto.CountryDto;
import com.proiect.scd.tema2.entities.Country;
import com.proiect.scd.tema2.services.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CountriesController {

    private final CountryService countryService;

    @PostMapping("countries")
    public ResponseEntity<?> addCountry(@Valid @RequestBody CountryDto countryDto){

        Integer idCountry = countryService.addCountry(countryDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("id", idCountry));
    }

    @GetMapping("countries")
    public ResponseEntity<?> getAllCountries(){

        List<CountryDto> countries = countryService.getAllCountries();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(countries);
    }

    @PutMapping("countries/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable Integer id, @Valid @RequestBody CountryDto updatedCountry) {

        Optional<Country> country = countryService.getCountryById(id);

        /* Check updated country data has same id as PathVariable id */
        if(updatedCountry.getId() == null || !updatedCountry.getId().equals(id)){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        if(country.isPresent()){
            countryService.updateCountry(updatedCountry);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping("countries/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Integer id) {

        Optional<Country> country = countryService.getCountryById(id);

        if(country.isPresent()){
            countryService.deleteCountry(country.get());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
