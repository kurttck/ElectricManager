package com.electricidad.controlmercaderia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idArticulo;

    private Long nroArticulo;

    @NotBlank
    private String nombreArticulo;

    @NotBlank
    private String descripcionArticulo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_imagen")
    private Imagen imagen;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fabrica_id")
    private Fabrica fabrica;

    private Boolean activo;


}
