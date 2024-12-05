package com.proiect.scd.tema2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureDto {

    @JsonProperty("id_oras")
    private Integer idCity;

    @JsonProperty("valoare")
    private Double value;
}
