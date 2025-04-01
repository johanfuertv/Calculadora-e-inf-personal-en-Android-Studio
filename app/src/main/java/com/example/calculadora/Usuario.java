package com.example.calculadora;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String correo;
    private int edad;
    private String contrasena;
    private String direccion;
    private String codigo;
    private String universidad;
    private String carrera;
    private String generoMusical;
    private String deporte;
    private String genero; // Masculino o Femenino

    // Constructor completo
    public Usuario(String nombre, String apellido, String correo, int edad, String contrasena,
                   String direccion, String codigo, String universidad, String carrera,
                   String generoMusical, String deporte, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.codigo = codigo;
        this.universidad = universidad;
        this.carrera = carrera;
        this.generoMusical = generoMusical;
        this.deporte = deporte;
        setGenero(genero); // Se usa el setter para validar
    }

    // Constructor simplificado para búsqueda por código
    public Usuario(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters y Setters
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino")) {
            this.genero = genero;
        } else {
            throw new IllegalArgumentException("Género inválido. Debe ser 'Masculino' o 'Femenino'.");
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Correo: " + correo + "\n" +
                "Edad: " + edad + "\n" +
                "Dirección: " + direccion + "\n" +
                "Código: " + codigo + "\n" +
                "Universidad: " + universidad + "\n" +
                "Carrera: " + carrera + "\n" +
                "Género Musical: " + generoMusical + "\n" +
                "Deporte: " + deporte + "\n" +
                "Género: " + genero;
    }
}
