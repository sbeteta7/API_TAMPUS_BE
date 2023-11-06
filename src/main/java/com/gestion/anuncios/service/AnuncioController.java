package com.gestion.anuncios.service;

import com.gestion.anuncios.model.Anuncio;
import com.gestion.anuncios.model.AnuncioEtiqueta;
import com.gestion.anuncios.model.Etiqueta;
import com.gestion.anuncios.model.Imagen;
import com.gestion.anuncios.repository.AnuncioRepository;
import com.gestion.anuncios.repository.AnuncioEtiquetaRepository;
import com.gestion.anuncios.repository.EtiquetaRepository;
import com.gestion.anuncios.repository.ImagenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api_tampu/anuncios")
public class AnuncioController {
    @Autowired
    private  ImagenRepository imagenRepository;
    private AnuncioRepository anuncioRepository;
    private EtiquetaRepository etiquetaRepository;
    private AnuncioEtiquetaRepository anuncioEtiquetaRepository;

    @Autowired
    public AnuncioController(AnuncioRepository anuncioRepository, EtiquetaRepository etiquetaRepository, AnuncioEtiquetaRepository anuncioEtiquetaRepository
            , ImagenRepository imagenRepository) {
        this.anuncioRepository = anuncioRepository;
        this.etiquetaRepository = etiquetaRepository;
        this.anuncioEtiquetaRepository = anuncioEtiquetaRepository;
        this.imagenRepository = imagenRepository;

    }
    // @Transactional
    @PostMapping("/store")
    public ResponseEntity<Anuncio> createAnuncio(@RequestBody Anuncio anuncio
                                                 // ,@RequestPart List<MultipartFile> imagenes
    ) {
        try {
            Anuncio createdAnuncio = anuncioRepository.save(anuncio);
            //   return anuncioRepository.save(anuncio);
            return new ResponseEntity<>(createdAnuncio, HttpStatus.CREATED);
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al guardar el curso: " + e.getMessage());
        }
    }
    @GetMapping("/getAll")
    public List<Anuncio> getAllAnuncios() {
        return anuncioRepository.findAll();
    }
}
