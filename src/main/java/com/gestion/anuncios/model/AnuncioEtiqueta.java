package com.gestion.anuncios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "AnuncioEtiqueta")
public class AnuncioEtiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_anuncio")
    private Anuncio anuncio;

    @ManyToOne
    @JoinColumn(name = "id_etiqueta")
    private Etiqueta etiqueta;



    // Constructor, getters y setters

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }
}
