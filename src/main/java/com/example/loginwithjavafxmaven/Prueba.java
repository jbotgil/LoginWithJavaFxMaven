package com.example.loginwithjavafxmaven;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.repositories.RepositoryUsuarioDB;

import java.util.ArrayList;
import java.util.List;

public class Prueba {

    public static void main(String[] args) {
        RepositoryUsuarioDB repositoryUsuarioDB = RepositoryUsuarioDB.getInstance();

        List<Usuario> usuarios = repositoryUsuarioDB.listarUsuarios();

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }

    }
}
