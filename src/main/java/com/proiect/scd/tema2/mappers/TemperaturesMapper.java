package com.proiect.scd.tema2.mappers;

import com.proiect.scd.tema2.dto.TemperatureDto;
import com.proiect.scd.tema2.entities.City;
import com.proiect.scd.tema2.entities.Temperature;
import com.proiect.scd.tema2.repositories.CityRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper(componentModel = "spring")
public abstract class TemperaturesMapper {

    @Autowired
    protected CityRepository cityRepository;

    @Mapping(source = "idCity", target = "idCity")
    @Mapping(source = "value", target = "value")
    @Mapping(target = "timestamp", expression = "java(getFormattedCurrentDate())")
    @Mapping(target = "city", expression = "java(getCityById(temperatureDto))")
    public abstract Temperature temperatureDtoToTemperature(TemperatureDto temperatureDto);

    @Mapping(source = "id", target = "id")
    @Mapping(ignore = true, target = "idCity")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "timestamp", target = "timestamp")
    public abstract TemperatureDto temperatureToTemperatureDto(Temperature temperature);

    protected Date getFormattedCurrentDate() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDate = formatter.format(new Date());
            return formatter.parse(formattedDate);
        } catch (Exception e) {
            throw new RuntimeException("Failed to format current date", e);
        }
    }

    protected City getCityById(TemperatureDto temperatureDto) {
        return cityRepository.findById(temperatureDto.getIdCity()).orElse(null);
    }

}
