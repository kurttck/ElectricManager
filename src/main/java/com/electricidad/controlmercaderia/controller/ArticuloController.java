package com.electricidad.controlmercaderia.controller;

import com.electricidad.controlmercaderia.model.Articulo;
import com.electricidad.controlmercaderia.model.Fabrica;
import com.electricidad.controlmercaderia.service.ArticuloService;
import com.electricidad.controlmercaderia.service.FabricaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private FabricaService fabricaService;

    @PostMapping("/registro")
    public String registrarArticulo(String nombre, String descripcion, UUID idFabrica, RedirectAttributes redirect) throws Exception {

        validar(nombre, descripcion, idFabrica);

        var fabrica = fabricaService.obtenerFabrica(idFabrica);

        System.out.println(nombre.toUpperCase()+" | " +descripcion.toUpperCase()+" | "+fabrica.getIdFabrica());


        articuloService.crearArticulo(nombre, descripcion, fabrica);

        redirect.addFlashAttribute("successMessage", "Articulo creado con exito");

        return "redirect:/articulo/lista";

    }

    public void validar(String nombre, String descriptioon, UUID idFabrica ) throws Exception{
        if (nombre.isEmpty() || nombre.equals(null)) {
            throw new Exception("El nombre no puede estar vacio");
        }
        if (descriptioon.isEmpty() || descriptioon.equals(null)) {
            throw new Exception("La descripcion no puede estar vacia");
        }

        if (idFabrica == null) {
            throw new Exception("La fabrica no puede estar vacia");
        }
    }

    @GetMapping("/lista")
    public String lista(ModelMap model){

        /*Fabrica sony =  new Fabrica();
        sony.setNombre("Apple");

        fabricaService.crearFabrica(sony);*/

        List<Articulo> articuloList = articuloService.listarArticulos();
        List<Fabrica> fabricaList = fabricaService.listarFabricas();

        model.addAttribute("articulos", articuloList);
        model.addAttribute("fabricas", fabricaList);

        return "articulo_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap model){
        Articulo articulo = articuloService.obtenerArticulo(id);
        List<Fabrica> fabricaList = fabricaService.listarFabricas();

        //Ordernar la lista de fabricas y colocar la fabrica del articulo en la posicion 0
        Fabrica articuloFabrica = articulo.getFabrica();
        fabricaList.remove(articuloFabrica);
        fabricaList.add(0, articuloFabrica);

        System.out.println("HOLA INTENTANDO ENTRAR EN MODIFICAR");
        System.out.println("Fabricas"+fabricaList);
        System.out.println("Articulo"+articulo);
        model.addAttribute("fabricas", fabricaList);
        model.addAttribute("articulo", articulo);

        return "articulo_modificador.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, String nombre, String descripcion, UUID idFabrica) throws Exception {
        validar(nombre, descripcion, idFabrica);

        articuloService.actualizarArticulo(id, nombre, descripcion, idFabrica);

        return "redirect:/articulo/lista";
    }


}
