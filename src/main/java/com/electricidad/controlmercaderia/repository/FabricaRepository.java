package com.electricidad.controlmercaderia.repository;

import com.electricidad.controlmercaderia.model.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FabricaRepository extends JpaRepository<Fabrica, UUID> {
}
