package com.proiect.scd.tema2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TemperatureDto {

    @JsonProperty("id")
    private Integer id;

    @NotNull
    @JsonProperty("idOras")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idCity;

    @NotNull
    @JsonProperty("valoare")
    private Double value;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date timestamp;

}
