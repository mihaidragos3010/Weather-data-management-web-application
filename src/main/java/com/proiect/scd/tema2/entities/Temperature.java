package com.proiect.scd.tema2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Temperaturi", uniqueConstraints = @UniqueConstraint(columnNames = {"id_oras", "timestamp"}))
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @NonNull
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @JsonProperty("idOras")
    @Column(name = "id_oras", insertable = false, updatable = false)
    private Integer idCity;

    @JsonProperty("valoare")
    @Column(name = "valoare")
    private Double value;

    @JsonProperty("timestamp")
    @Column(name = "timestamp")
    private Date timestamp;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_oras", nullable = false)
    private City city;
}
