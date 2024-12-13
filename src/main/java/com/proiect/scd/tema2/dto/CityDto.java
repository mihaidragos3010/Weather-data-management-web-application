package com.proiect.scd.tema2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {

    @JsonProperty("id")
    private Integer id;

    @NotNull
    @JsonProperty("idTara")
    private Integer idCountry;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @JsonProperty("nume")
    private String name;

    @NotNull
    @JsonProperty("lat")
    private Double latitude;

    @NotNull
    @JsonProperty("lon")
    private Double longitude;
}
