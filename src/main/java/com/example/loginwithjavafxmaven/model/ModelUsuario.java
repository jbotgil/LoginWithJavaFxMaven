package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.repositories.RepositoryUsuarios;

import java.util.List;

public class ModelUsuario {

    RepositoryUsuarios repositoryUsuarios = RepositoryUsuarios.getInstance();

    public Usuario buscarUsuario(List<Usuario> usuarios,String mail) {
        return repositoryUsuarios.buscarUsuario(usuarios,mail);
    }

}
