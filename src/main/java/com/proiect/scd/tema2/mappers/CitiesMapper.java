package com.proiect.scd.tema2.mappers;

import com.proiect.scd.tema2.dto.CityDto;
import com.proiect.scd.tema2.entities.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CitiesMapper {

    @Mapping(source = "idCountry", target = "idCountry")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    City cityDtoToCity(CityDto cityDto);

    @Mapping(source = "idCountry", target = "idCountry")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    CityDto cityToCityDto(City city);
}
