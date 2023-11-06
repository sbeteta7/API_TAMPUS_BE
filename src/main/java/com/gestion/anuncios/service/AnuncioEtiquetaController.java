package com.gestion.anuncios.service;
import com.gestion.anuncios.model.Anuncio;
import com.gestion.anuncios.model.AnuncioEtiqueta;
import com.gestion.anuncios.repository.AnuncioEtiquetaRepository;
import com.gestion.anuncios.repository.AnuncioRepository;
import com.gestion.anuncios.repository.EtiquetaRepository;
import com.gestion.anuncios.repository.ImagenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api_tampu/anuncioEtiquetas")
public class AnuncioEtiquetaController {
    @Autowired
    private AnuncioEtiquetaRepository anuncioEtiquetaRepository;
    @Autowired
    public AnuncioEtiquetaController(AnuncioEtiquetaRepository anuncioEtiquetaRepository) {
        this.anuncioEtiquetaRepository = anuncioEtiquetaRepository;
    }
    //@Transactional
    @PostMapping("/store")
    public ResponseEntity<AnuncioEtiqueta> createAnuncioEtiqueta(@RequestBody AnuncioEtiqueta anuncioEtiqueta) {
        try {
            AnuncioEtiqueta createdAnuncioEtiqueta = anuncioEtiquetaRepository.save(anuncioEtiqueta);

            return new ResponseEntity<>(createdAnuncioEtiqueta, HttpStatus.CREATED);
        }
        catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();  // Agregar manejo de errores adecuado
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
