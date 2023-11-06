package com.gestion.anuncios.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
@Table(name = "etiqueta")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_etiqueta;
    private String nombre;



    public void setId(Integer id_etiqueta) {
        this.id_etiqueta = id_etiqueta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
