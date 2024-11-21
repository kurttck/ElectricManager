package com.electricidad.controlmercaderia.repository;

import com.electricidad.controlmercaderia.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, UUID> {

}
