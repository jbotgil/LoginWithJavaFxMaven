package com.example.loginwithjavafxmaven;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.repositories.RepositoryUsuarioDB;

import java.util.ArrayList;
import java.util.List;

public class Prueba {

    private Usuario buscarUsuario(List<Usuario> usuarios, String mail) {
        if (usuarios == null) {
            System.out.println("La lista de usuarios es nula");
            return null;
        }

        Usuario buscarUsuario = null;
        try {
            buscarUsuario = usuarios.stream()
                    .filter(usuario -> usuario != null && mail.equals(usuario.getEmail()))
                    .findFirst()
                    .orElse(null);
        } catch (NullPointerException nullPointerException) {
            System.out.println("Usuario no encontrado");
        }
        return buscarUsuario;
    }

    public void usuarioEncontrado(List<Usuario> usuarios, String mail){
        if (buscarUsuario(usuarios,mail) != null){
            System.out.println("Usuario encontrado -> "+buscarUsuario(usuarios,mail));
        } else {
            System.out.println("Usuario no encontrado");
        }
    }


    public static void main(String[] args) {
        RepositoryUsuarioDB repositoryUsuarioDB = RepositoryUsuarioDB.getInstance();
        List<Usuario> usuarios = repositoryUsuarioDB.getUsuarios();


        //Prueba de busqueda con funcion lambda
        String pruebaMail = "jbgil0805@gmail.com";

        Prueba prueba = new Prueba();

        prueba.usuarioEncontrado(usuarios,pruebaMail);
    }
}
