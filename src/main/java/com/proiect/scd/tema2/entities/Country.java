package com.proiect.scd.tema2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Tari")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nume_tara", unique = true)
    private String name;

    @Column(name = "latitudine")
    private Double latitude;

    @Column(name = "longitudine")
    private Double longitude;
}
