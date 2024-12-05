package com.proiect.scd.tema2.services;

import com.proiect.scd.tema2.dto.TemperatureDto;
import com.proiect.scd.tema2.entities.City;
import com.proiect.scd.tema2.entities.Temperature;
import com.proiect.scd.tema2.mappers.TemperaturesMapper;
import com.proiect.scd.tema2.repositories.CityRepository;
import com.proiect.scd.tema2.repositories.TemperatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemperatureService {

    private final TemperaturesMapper temperaturesMapper;
    private final CityRepository cityRepository;
    private final TemperatureRepository temperatureRepository;

    public Integer addTemperature(TemperatureDto temperatureDto){

        Temperature temperature = temperaturesMapper.temperatureDtoToTemperature(temperatureDto);
        Temperature savedTemperature = temperatureRepository.save(temperature);

        return savedTemperature.getId();
    }

    public Optional<Temperature> getTemperatureById(Integer id){
        return temperatureRepository.findById(id);
    }

    public void updateTemperature(Temperature updatedTemperature){
        temperatureRepository.save(updatedTemperature);
    }

    public void deleteTemperature(Temperature temperature){
        temperatureRepository.delete(temperature);
    }

    public List<Temperature> getTemperatures(Optional<Double> latitude, Optional<Double> longitude, Optional<Date> fromDate, Optional<Date> untilDate){

        List<City> cities = new ArrayList<>();
        if(latitude.isEmpty() && longitude.isEmpty()){
            cities = cityRepository.findAll();
        }

        if(latitude.isPresent() && longitude.isEmpty()){
            cities = cityRepository.findByLatitude(latitude.get());
        }

        if(latitude.isEmpty() && longitude.isPresent()){
            cities = cityRepository.findByLongitude(longitude.get());
        }

        if(latitude.isPresent() && longitude.isPresent()){
            cities = cityRepository.findByLatitudeAndLongitude(latitude.get(), longitude.get());
        }

        List<Temperature> temperatures = new ArrayList<>();
        for(City city : cities) {
            if (fromDate.isEmpty() && untilDate.isEmpty()) {
                temperatures.addAll(temperatureRepository.findByIdCity(city.getId()));
            }

            if (fromDate.isPresent() && untilDate.isEmpty()) {
                temperatures.addAll(temperatureRepository.findFromDate(city.getId(), fromDate.get()));
            }

            if (fromDate.isEmpty() && untilDate.isPresent()) {
                temperatures.addAll(temperatureRepository.findUntilDate(city.getId(), untilDate.get()));
            }

            if (fromDate.isPresent() && untilDate.isPresent()) {
                temperatures.addAll(temperatureRepository.findBetweenDates(city.getId(), fromDate.get(), untilDate.get()));
            }
        }

        return temperatures;
    }

    public List<Temperature> getTemperaturesByCity(Integer idCity, Optional<Date> fromDate, Optional<Date> untilDate){

        List<Temperature> temperatures = new ArrayList<>();
        if (fromDate.isEmpty() && untilDate.isEmpty()) {
            temperatures.addAll(temperatureRepository.findByIdCity(idCity));
        }

        if (fromDate.isPresent() && untilDate.isEmpty()) {
            temperatures.addAll(temperatureRepository.findFromDate(idCity, fromDate.get()));
        }

        if (fromDate.isEmpty() && untilDate.isPresent()) {
            temperatures.addAll(temperatureRepository.findUntilDate(idCity, untilDate.get()));
        }

        if (fromDate.isPresent() && untilDate.isPresent()) {
            temperatures.addAll(temperatureRepository.findBetweenDates(idCity, fromDate.get(), untilDate.get()));
        }

        return temperatures;
    }

    public List<Temperature> getTemperaturesByCountry(Integer idCountry, Optional<Date> fromDate, Optional<Date> untilDate){

        List<City> cities = cityRepository.findByIdCountry(idCountry);

        List<Temperature> temperatures = new ArrayList<>();
        for(City city : cities) {
            if (fromDate.isEmpty() && untilDate.isEmpty()) {
                temperatures.addAll(temperatureRepository.findByIdCity(city.getId()));
            }

            if (fromDate.isPresent() && untilDate.isEmpty()) {
                temperatures.addAll(temperatureRepository.findFromDate(city.getId(), fromDate.get()));
            }

            if (fromDate.isEmpty() && untilDate.isPresent()) {
                temperatures.addAll(temperatureRepository.findUntilDate(city.getId(), untilDate.get()));
            }

            if (fromDate.isPresent() && untilDate.isPresent()) {
                temperatures.addAll(temperatureRepository.findBetweenDates(city.getId(), fromDate.get(), untilDate.get()));
            }
        }

        return temperatures;
    }
}
