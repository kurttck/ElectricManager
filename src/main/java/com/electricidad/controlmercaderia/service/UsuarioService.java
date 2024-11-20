package com.electricidad.controlmercaderia.service;

import com.electricidad.controlmercaderia.model.Rol;
import com.electricidad.controlmercaderia.model.Usuario;
import com.electricidad.controlmercaderia.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    //METODO PARA REGISTRAR USUARIO
    @Transactional
    public void registrar(String username, String nombre, String apellido, String password, String password2) throws Exception {

        validar(username, nombre, apellido, password, password2);

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);

        usuarioRepository.save(usuario);

    }

    //METODO PARA VALIDAR DATOS DE USUARIO
    public void validar(String username, String nombre, String apellido, String password, String password2) throws Exception {
        if(!password.equals(password2)){
            throw new Exception("Las contraseñas no coinciden");
        }
        if(username.isEmpty() || username.equals(null)){
            throw new Exception("El username no puede estar vacio");
        }
        if(nombre.isEmpty() || nombre.equals(null)){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (apellido.isEmpty() || apellido.equals(null)) {
            throw new Exception("El apellido no puede estar vacio");
        }
        if (password.isEmpty() || password.equals(null)) {
            throw new Exception("La contraseña no puede estar vacia");
        }
    }


    //METODO PARA AUTENTICACION DE USUARIO CON SPRING SECURITY
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = usuarioRepository.findByUsername(username);

        if(user != null){
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" +user.getRol().toString());
            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession sesion =attr.getRequest().getSession(true);
            sesion.setAttribute("usuariosession", user);

            System.out.println(permisos);

            User u = new User(user.getUsername(), user.getPassword(), permisos);
            return u;
        }else{
            return null;
        }
    }
}
