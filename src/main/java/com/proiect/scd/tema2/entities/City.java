package com.proiect.scd.tema2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Orase", uniqueConstraints = @UniqueConstraint(columnNames = {"id_tara", "nume_oras"}))
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "id")
    private Integer id;

    @JsonProperty("idTara")
    @Column(name = "id_tara", insertable = false, updatable = false)
    private Integer idCountry;

    @JsonProperty("nume")
    @Column(name = "nume_oras")
    private String name;

    @JsonProperty("lat")
    @Column(name = "latitudine")
    private Double latitude;

    @JsonProperty("lon")
    @Column(name = "longitudine")
    private Double longitude;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tara", nullable = false)
    private Country country;
}
