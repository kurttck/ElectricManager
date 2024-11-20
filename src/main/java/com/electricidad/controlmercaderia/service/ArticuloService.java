package com.electricidad.controlmercaderia.service;

import com.electricidad.controlmercaderia.model.Articulo;
import com.electricidad.controlmercaderia.model.Fabrica;
import com.electricidad.controlmercaderia.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private FabricaService fabricaService;

    public List<Articulo> listarArticulos() {
        return articuloRepository.findAllByOrderByNroArticuloAsc();
    }

    @Transactional
    public void crearArticulo(String nombre, String descripcion, Fabrica fabrica) {

        var articulo = new Articulo();


        articulo.setNombreArticulo(nombre);
        articulo.setDescripcionArticulo(descripcion);
        articulo.setFabrica(fabrica);

        articuloRepository.save(articulo);
    }

    public Articulo obtenerArticulo(UUID id) {
        return articuloRepository.getReferenceById(id);
    }

    @Transactional
    public void actualizarArticulo(UUID id, String nombre, String descripcion, UUID idFabrica) {

        var fabrica = fabricaService.obtenerFabrica(idFabrica);

        var articulo = articuloRepository.getReferenceById(id);

        articulo.setNombreArticulo(nombre);
        articulo.setDescripcionArticulo(descripcion);
        articulo.setFabrica(fabrica);
    }
}
