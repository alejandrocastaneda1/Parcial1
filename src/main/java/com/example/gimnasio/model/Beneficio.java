package com.example.gimnasio.model;

public class Beneficio {

    private String nombre;
    private String descripcion;

    public Beneficio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre + (descripcion != null && !descripcion.isEmpty() ? " - " + descripcion : "");
    }
}
