package com.electricidad.controlmercaderia.controller;

import com.electricidad.controlmercaderia.model.Articulo;
import com.electricidad.controlmercaderia.model.Imagen;
import com.electricidad.controlmercaderia.service.ArticuloService;
import com.electricidad.controlmercaderia.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/imagen")
public class ImagenController {

    @Autowired
    private ArticuloService articuloService;

    //EN ARTICULO LIST SE LLAMA A ESTE METODO PARA OBTENER LA IMAGEN
    @GetMapping("/articulo/{id}")
    public ResponseEntity<byte[]> imagenArticulo(@PathVariable UUID id){
        Articulo articulo = articuloService.obtenerArticulo(id);

        System.out.println(id);

        if (articulo.getImagen() == null || articulo.getImagen().getContenido() == null) {
            return ResponseEntity.notFound().header("Error", "No se encontro la imagen").build();
        }

        byte[] imagen = articulo.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);

    }
}
