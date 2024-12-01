package com.proiect.scd.tema2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {

    @JsonProperty("idTara")
    private Integer idCountry;

    @JsonProperty("nume")
    private String name;

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lon")
    private Double longitude;
}
