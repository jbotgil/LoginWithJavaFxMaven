package com.example.loginwithjavafxmaven.model;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.repositories.RepositoryUsuarios;

import java.util.List;

public class ModelUsuario {

    RepositoryUsuarios repositoryUsuarios = RepositoryUsuarios.getInstance();

    public Usuario buscarUsuario(String mail) {
        return repositoryUsuarios.buscarUsuario(mail);
    }

}
