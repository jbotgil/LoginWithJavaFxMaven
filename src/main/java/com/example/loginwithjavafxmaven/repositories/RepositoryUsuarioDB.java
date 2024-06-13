package com.example.loginwithjavafxmaven.repositories;

import com.example.loginwithjavafxmaven.dao.Usuario;
import com.example.loginwithjavafxmaven.util.SQLiteConnector;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class RepositoryUsuarioDB {

    private SQLiteConnector connector = SQLiteConnector.getInstance();
    private static RepositoryUsuarioDB instance;
    private RepositoryUsuarioDB(){}

    public static RepositoryUsuarioDB getInstance(){
        if (instance == null){
            instance = new RepositoryUsuarioDB();
        }
        return instance;
    }

    private List<Usuario> usuarios = listarUsuarios();

    public List<Usuario> getUsuarios() { //Usuarios del sistema
        return usuarios;
    }

    // Devuelve los usuarios de nuestra base de datos a traves de una consulta sql
    private List<Usuario> listarUsuarios(){


        String checkSQL = "SELECT * FROM Usuarios"; //Consulta a la base de datos

        List<Usuario> usuarios = new LinkedList<>(); //Coleccion en la que añadiremos todos los usuarios para poder listarlos

        try (var conn = connector.getConnection(); //Creamos la conexion
             var stmt = conn.createStatement(); //Creamos la declaracion del estado
             var rs = stmt.executeQuery(checkSQL))/*Ejecutamos la consulta*/ {

            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombreCompleto");
                String email = rs.getString("email");
                String passwd = rs.getString("passwd");

                Usuario usuario = new Usuario(id,nombre,passwd,email);

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    public void verificarCorreo(String mail){
        List<Usuario> usus = getUsuarios();


    }



}