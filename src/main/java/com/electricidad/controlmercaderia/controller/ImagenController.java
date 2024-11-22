package com.electricidad.controlmercaderia.controller;

import com.electricidad.controlmercaderia.model.Articulo;
import com.electricidad.controlmercaderia.model.Imagen;
import com.electricidad.controlmercaderia.model.Usuario;
import com.electricidad.controlmercaderia.service.ArticuloService;
import com.electricidad.controlmercaderia.service.ImagenService;
import com.electricidad.controlmercaderia.service.UsuarioService;
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

    @Autowired
    private UsuarioService usuarioService;

    //EN ARTICULO LIST SE LLAMA A ESTE METODO PARA OBTENER LA IMAGEN
    @GetMapping("/articulo/{id}")
    public ResponseEntity<byte[]> imagenArticulo(@PathVariable UUID id){
        Articulo articulo = articuloService.obtenerArticulo(id);

        if (articulo.getImagen() == null || articulo.getImagen().getContenido() == null) {
            return ResponseEntity.notFound().header("Error", "No se encontro la imagen").build();
        }

        byte[] imagen = articulo.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);

    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable UUID id){

        Usuario user = usuarioService.obtenerUsuario(id);

        if (user.getImagen() == null || user.getImagen().getContenido() == null) {
            return ResponseEntity.notFound().header("Error", "No se encontro la imagen").build();
        }

        byte[] imagen = user.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);

    }
}
