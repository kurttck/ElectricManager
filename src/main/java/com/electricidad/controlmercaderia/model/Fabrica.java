package com.electricidad.controlmercaderia.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "fabricas")
public class Fabrica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFabrica;

    @NotBlank
    private String nombre;

    @OneToMany (mappedBy = "fabrica")
    private List<Articulo> articulos;
}
