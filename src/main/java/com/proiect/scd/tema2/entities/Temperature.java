package com.proiect.scd.tema2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Temperaturi", uniqueConstraints = @UniqueConstraint(columnNames = {"id_oras", "timestamp"}))
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_oras", insertable=false, updatable=false)
    private Integer idCity;

    @Column(name = "valoare")
    private Double value;

    @Column(name = "timestamp")
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "id_oras", nullable = false)
    private City city;
}
