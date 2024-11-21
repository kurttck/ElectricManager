package com.electricidad.controlmercaderia.service;

import com.electricidad.controlmercaderia.model.Imagen;
import com.electricidad.controlmercaderia.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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


}
