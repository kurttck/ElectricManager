package com.electricidad.controlmercaderia.repository;


import com.electricidad.controlmercaderia.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, UUID> {


    List<Articulo> findAllByOrderByNroArticuloAsc();  // Orden ascendente


}
