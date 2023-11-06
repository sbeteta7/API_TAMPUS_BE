package com.gestion.anuncios.service;

import com.gestion.anuncios.model.Etiqueta;
import com.gestion.anuncios.repository.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api_tampu/etiquetas")
public class EtiquetaController {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @GetMapping("/getAll")
    public List<Etiqueta> getAll(){
        return etiquetaRepository.findAll();
    }



}