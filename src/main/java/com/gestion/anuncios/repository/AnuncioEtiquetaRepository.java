package com.gestion.anuncios.repository;
import com.gestion.anuncios.model.Anuncio;
import com.gestion.anuncios.model.AnuncioEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioEtiquetaRepository extends JpaRepository<AnuncioEtiqueta, Integer> {
}
