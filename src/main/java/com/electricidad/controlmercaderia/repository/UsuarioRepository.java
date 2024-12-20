package com.electricidad.controlmercaderia.repository;

import com.electricidad.controlmercaderia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {


    Usuario findByUsername(String username);
}
