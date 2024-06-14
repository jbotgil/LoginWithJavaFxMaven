package com.example.loginwithjavafxmaven.controller;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.model.ModelUsuario;

import java.util.List;


public class UsuarioController {

    ModelUsuario modelUsuario = new ModelUsuario();

    public Usuario buscarUsuario(List<Usuario> usuarios,String mail) {
        return modelUsuario.buscarUsuario(usuarios,mail);
    }

}
