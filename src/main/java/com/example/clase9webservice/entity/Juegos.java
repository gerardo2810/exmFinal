package com.example.clase9webservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "juegos")
public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego")
    private Integer idjuego;

    @Column(name = "nombre", length = 50)
    private String name;

    @Column(name = "descripcion", length = 448)
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "image", length = 400)
    private String image;
    @Column(name = "idgenero")
    private int idgenero;
    @Column(name = "idplataforma")
    private int idplataforma;
    @Column(name = "ideditora")
    private int ideditora;
    @Column(name = "iddistribuidora")
    private int iddistribuidora;


}
