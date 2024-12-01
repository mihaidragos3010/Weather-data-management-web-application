package com.proiect.scd.tema2.services;

import com.proiect.scd.tema2.dto.CityDto;
import com.proiect.scd.tema2.entities.City;
import com.proiect.scd.tema2.mappers.CitiesMapper;
import com.proiect.scd.tema2.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CitiesMapper citiesMapper;
    private final CityRepository cityRepository;

    public Integer addCity(CityDto cityDto){

        City city = citiesMapper.cityDtoToCity(cityDto);
        City savedCity = cityRepository.save(city);

        return savedCity.getId();
    }

    public Optional<City> getCityById(Integer id){
        return cityRepository.findById(id);
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public List<City> getCitiesByIdCountry(Integer idCountry) {
        return cityRepository.findByIdCountry(idCountry);
    }

    public void updateCity(City updatedCity){
        cityRepository.save(updatedCity);
    }

    public void deleteCity(City city){
        cityRepository.delete(city);
    }
}
