package com.electricidad.controlmercaderia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    @Column(name="id_imagen")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    private String nombre;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "LONGBLOB")
    private byte[] contenido;
}
