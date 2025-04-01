package com.example.calculadora;

public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private int edad;
    private String contrasena;
    private String direccion;
    private String codigo;

    public Usuario(String nombre, String apellido, String correo, int edad, String contrasena, String direccion, String codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.codigo = codigo;
    }

    public Usuario(String codigo, String nombre) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Correo: " + correo + "\n" +
                "Edad: " + edad + "\n" +
                "Dirección: " + direccion + "\n" +
                "Código: " + codigo;
    }
}