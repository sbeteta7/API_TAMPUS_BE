package com.gestion.anuncios.service;



import com.gestion.anuncios.model.Anuncio;
import com.gestion.anuncios.model.Imagen;
import com.gestion.anuncios.repository.AnuncioRepository;
import com.gestion.anuncios.repository.ImagenRepository;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api_tampu/imagenes")
public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;
    @Autowired
    private AnuncioRepository anuncioRepository;

    @GetMapping("/getAll")
    public List<Imagen> getAll(){
        return imagenRepository.findAll();
    }

    @PostMapping(value="/upload",consumes = {"multipart/form-data"})
    //consumes = { "multipart/form-data" }

    public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("anuncioId") int anuncioId) {
        try {
            // Obtén el anuncio por su ID
            Anuncio anuncio = anuncioRepository.findById(anuncioId).orElse(null);

            if (anuncio == null) {
                return "El anuncio con ID " + anuncioId + " no existe.";
            }

            // Procesa la imagen
            Imagen imagen = new Imagen();
            imagen.setNombre(file.getOriginalFilename());
            imagen.setRuta(file.getBytes()); // Almacena los datos binarios de la imagen

            // Asocia la imagen con el anuncio
            imagen.setId_anuncio(anuncio);

            // Guarda la imagen en la base de datos
            imagenRepository.save(imagen);

            return "Imagen cargada con éxito y asociada al anuncio con ID " + anuncioId;
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
            return "Error al cargar la imagen.";
        }
    }



}