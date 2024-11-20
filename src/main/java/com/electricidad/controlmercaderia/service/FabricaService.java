package com.electricidad.controlmercaderia.service;

import com.electricidad.controlmercaderia.model.Fabrica;
import com.electricidad.controlmercaderia.repository.FabricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FabricaService {

    @Autowired
    private FabricaRepository fabricaRepository;


    public Fabrica obtenerFabrica(UUID id) {
        Optional<Fabrica> respuesta = fabricaRepository.findById(id);

        if(respuesta.isPresent()) {
            return respuesta.get();
        }else {
            return null;
        }
    }

    public List<Fabrica> listarFabricas() {
        return fabricaRepository.findAll();
    }

    @Transactional
    public void crearFabrica(Fabrica sony) {

        fabricaRepository.save(sony);
    }
}
