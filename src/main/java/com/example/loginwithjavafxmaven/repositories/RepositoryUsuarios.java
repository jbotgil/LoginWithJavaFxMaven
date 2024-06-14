package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.util.SQLiteConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        return cargarUsuarios();
    }

    public List<Usuario> cargarUsuarios(){
        usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Connection conn = connector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombreCompleto");
                String mail = rs.getString("email");
                String passwd = rs.getString("passwd");

                Usuario usuario = new Usuario(id,nombre,passwd,mail);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    /**
     * Metodo para buscar usuarios a traves del mail en una base de datos
     *
     * @param mail Mail que queremos buscar en la base de datos
     *
     * @return En el caso de que el usuario exista, devolverá el objeto Usuario, en caso constrario devolverá null
     */
    public Usuario buscarUsuario(List<Usuario> usuarios, String mail) {

        if (usuarios == null) {
            System.out.println("La lista de usuarios es nula");
            return null;
        }

        for (Usuario usuario : usuarios) {
            if (usuario != null && mail.equals(usuario.getEmail())) {
                return usuario;
            }
        }
        return null;
    }

}