package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.util.SQLiteConnector;

import java.util.List;

public class RepositoryUsuarios {
    private static RepositoryUsuarios instance;
    private SQLiteConnector connector;
    private List<Usuario> usuarios;


    private RepositoryUsuarios() {
        connector = SQLiteConnector.getInstance();
        RepositoryUsuarioDB repositoryUsuarioDB = RepositoryUsuarioDB.getInstance();
        usuarios = repositoryUsuarioDB.getUsuarios();
    }

    //Método estático para obtener la instancia única
    public static RepositoryUsuarios getInstance() {
        if (instance == null) {
            instance = new RepositoryUsuarios();
        }
        return instance;
    }

    //Método para obtener la lista de usuarios
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Metodo para buscar usuarios a traves del mail en una base de datos
     *
     * @param mail Mail que queremos buscar en la base de datos
     *
     * @return En el caso de que el usuario exista, devolverá el objeto Usuario, en caso constrario devolverá null
     */
    public Usuario buscarUsuario(String mail) {
        List<Usuario> usuarios = getUsuarios();

        if (usuarios == null) {
            System.out.println("La lista de usuarios es nula");
            return null;
        }

        Usuario usuarioEncontrado;

         return usuarioEncontrado = usuarios.stream()
                .filter(usuario -> usuario != null && mail.equals(usuario.getEmail()))
                .findFirst()
                .orElse(null);
    }
}