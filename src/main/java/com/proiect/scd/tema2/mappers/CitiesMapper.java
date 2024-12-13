package com.proiect.scd.tema2.mappers;

import com.proiect.scd.tema2.dto.CityDto;
import com.proiect.scd.tema2.entities.City;
import com.proiect.scd.tema2.entities.Country;
import com.proiect.scd.tema2.repositories.CountryRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CitiesMapper {

    @Autowired
    protected CountryRepository countryRepository;

//    @Mapping(source = "idCountry", target = "idCountry")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "latitude", target = "latitude")
//    @Mapping(source = "longitude", target = "longitude")
    public abstract City cityDtoToCity(CityDto cityDto);

//    @Mapping(source = "idCountry", target = "idCountry")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "latitude", target = "latitude")
//    @Mapping(source = "longitude", target = "longitude")
    public abstract CityDto cityToCityDto(City city);

    @AfterMapping
    public void mapCountry(@MappingTarget City city, CityDto cityDto) {
        if (cityDto.getIdCountry() != null) {
            Country country = countryRepository.findById(cityDto.getIdCountry()).orElse(null);
            city.setCountry(country);
        }
    }

}
