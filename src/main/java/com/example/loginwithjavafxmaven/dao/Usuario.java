package com.example.loginwithjavafxmaven.dao;

public class Usuario {

    private String nombreCompleto;

    private String passwd;

    private String email;

    private int id;

    public Usuario(int id, String nombreCompleto, String passwd, String email) {
        this.nombreCompleto = nombreCompleto;
        this.passwd = passwd;
        this.email = email;
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[ ID: "+this.getId()+" | Mail: "+this.getEmail()+" | Nombre: "+this.getNombreCompleto()+" | Passwd: " + this.getPasswd()+" ]";
    }
}