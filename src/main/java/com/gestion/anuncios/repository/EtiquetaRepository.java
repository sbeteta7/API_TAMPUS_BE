package com.gestion.anuncios.repository;


import com.gestion.anuncios.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
}
