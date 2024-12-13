package com.proiect.scd.tema2.mappers;

import com.proiect.scd.tema2.dto.CountryDto;
import com.proiect.scd.tema2.entities.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountriesMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    Country countryDtoToCountry(CountryDto countryDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    CountryDto countryToCountryDto(Country country);
}

