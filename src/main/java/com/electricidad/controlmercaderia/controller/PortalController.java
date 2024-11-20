package com.electricidad.controlmercaderia.controller;

import com.electricidad.controlmercaderia.model.Usuario;
import com.electricidad.controlmercaderia.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String registro(){
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String username, @RequestParam String nombre, @RequestParam String apellido,
                           @RequestParam String password, String password2){

        try{
            usuarioService.registrar(username, nombre, apellido, password, password2);

            System.out.println("Usuario registrado");

            return "index.html";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "registro.html";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    //METODO PARA DEFINIR REGLAS DE AUTORIZACION DE USUARIOS
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session){

        Usuario logueado = (Usuario) session.getAttribute("usuariosession");

        if(logueado == null){
            return "redirect:/login";
        }

        //System.out.println("EMAIL Y ROL DEL USUARIO: "+logueado.getUsername()+logueado.getRol().toString());

        /*if(logueado.getRol().toString().equals("ADMIN")){
            return "redirect:/admin/dashboard";
        }*/

        return "dashboard.html";

    }

}
