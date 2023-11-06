package com.gestion.anuncios.repository;

import com.gestion.anuncios.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {

}
