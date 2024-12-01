package com.proiect.scd.tema2.services;

import com.proiect.scd.tema2.dto.CountryDto;
import com.proiect.scd.tema2.entities.Country;
import com.proiect.scd.tema2.mappers.CountriesMapper;
import com.proiect.scd.tema2.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountriesMapper countriesMapper;
    private final CountryRepository countryRepository;

    public Integer addCountry(CountryDto countryDto){

        Country country = countriesMapper.countryDtoToCountry(countryDto);
        Country savedCountry = countryRepository.save(country);

        return savedCountry.getId();
    }

    public Optional<Country> getCountryById(Integer id){
        return countryRepository.findById(id);
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public void updateCountry(Country updatedCountry){
        countryRepository.save(updatedCountry);
    }

    public void deleteCountry(Country country){
        countryRepository.delete(country);
    }

}
