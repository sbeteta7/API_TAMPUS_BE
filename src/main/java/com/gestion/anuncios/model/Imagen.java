package com.gestion.anuncios.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
@Table(name = "imagen")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_imagen;

    @ManyToOne
    @JoinColumn(name="id_anuncio")
    private Anuncio id_anuncio;

    private String nombre;

    private byte[] ruta;

    public Imagen() {
    }


    public void setRuta(byte[] ruta) {
        this.ruta = ruta;
    }


}
