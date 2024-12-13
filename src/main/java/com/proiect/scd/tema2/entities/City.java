package com.proiect.scd.tema2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Orase", uniqueConstraints = @UniqueConstraint(columnNames = {"id_tara", "nume_oras"}))
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_tara", insertable = false, updatable = false)
    private Integer idCountry;

    @Column(name = "nume_oras")
    private String name;

    @Column(name = "latitudine")
    private Double latitude;

    @Column(name = "longitudine")
    private Double longitude;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tara", nullable = false)
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Temperature> temperatures;
}
