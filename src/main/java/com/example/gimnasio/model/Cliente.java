package com.example.gimnasio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private int edad;
    private LocalDate fechaRegistro;

    private List<Inscripcion> listInscripcionCliente = new ArrayList<>();

    public Cliente(String nombreCompleto, String documentoIdentidad, String telefono, String correoElectronico, int edad, LocalDate fechaRegistro) {
        this.nombre = nombreCompleto;
        this.cedula = documentoIdentidad;
        this.telefono = telefono;
        this.correo = correoElectronico;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        listInscripcionCliente.add(inscripcion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public List<Inscripcion> getListInscripcionCliente() {
        return listInscripcionCliente;
    }
}