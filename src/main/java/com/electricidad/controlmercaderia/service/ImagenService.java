package com.electricidad.controlmercaderia.service;

import com.electricidad.controlmercaderia.model.Imagen;
import com.electricidad.controlmercaderia.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRespositorio;

    @Transactional
    public Imagen guardarImagen(MultipartFile archivo) {

        if(archivo!=null){
            try{
                Imagen img = new Imagen();
                img.setNombre(archivo.getOriginalFilename());
                img.setContenido(archivo.getBytes());
                return imagenRespositorio.save(img);
            }catch(Exception e){
                return null;
            }
        }

        return null;
    }


    public Imagen actualizarImagen(UUID id, MultipartFile archivo) throws Exception {
        if(archivo!=null) {
            try {
                Imagen imagen = new Imagen();
                if(id!=null){
                    Optional<Imagen> img = imagenRespositorio.findById(id);
                    if(img.isPresent()){
                        imagen = img.get();
                    }

                }

                imagen.setNombre(archivo.getOriginalFilename());
                imagen.setContenido(archivo.getBytes());
                return imagenRespositorio.save(imagen);

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }
        return null;
    }
}
