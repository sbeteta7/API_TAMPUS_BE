package com.gestion.anuncios.model;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "anuncio")
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_anuncio;


    private String user;

    @Column(length = 50)
    private String proposito;

    @Column(length = 30)
    private String titulo;

    @Column(length = 100)
    private String descripcion;

    @Column(length = 50)
    private String ubicacion;


    private BigDecimal precio_min;
    private BigDecimal precio_max;

    @Column(length = 30)
    private String tipo_espacio;
    private int num_hab;
    private int num_cama;
    private BigDecimal dimensiones;

    @Column(length = 1)
    private char estado_anuncio;
}
