package com.proiect.scd.tema2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Tari")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "id")
    private Integer id;

    @JsonProperty("nume")
    @Column(name = "nume_tara", unique = true)
    private String name;

    @JsonProperty("lat")
    @Column(name = "latitudine")
    private Double latitude;

    @JsonProperty("lon")
    @Column(name = "longitudine")
    private Double longitude;

    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;
}
