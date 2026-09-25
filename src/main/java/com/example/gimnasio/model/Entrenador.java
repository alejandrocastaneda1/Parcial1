package com.example.gimnasio.model;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private String identificacion;
    private String nombre;
    private String especialidad;
    private String telefono;
    private double tarifaSesion;

    // Asociaciones
    private List<Inscripcion> listInscripcionEntrenador = new ArrayList<>();
    private List<Cliente> listClienteEntrenador = new ArrayList<>();

    public Entrenador(String identificacion, String nombre, String especialidad, String telefono, double tarifaSesion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.tarifaSesion = tarifaSesion;
    }

    public double calcularCostoSesiones(int cantidadSesiones) {
        return tarifaSesion * cantidadSesiones;
    }

    // Metodos de apoyo para mantener la asociacion bidireccional con Inscripcion/Cliente
    public void agregarInscripcion(Inscripcion inscripcion) {
        if (inscripcion != null && !listInscripcionEntrenador.contains(inscripcion)) {
            listInscripcionEntrenador.add(inscripcion);
        }
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente != null && !listClienteEntrenador.contains(cliente)) {
            listClienteEntrenador.add(cliente);
        }
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getTarifaSesion() {
        return tarifaSesion;
    }

    public List<Inscripcion> getListInscripcionEntrenador() {
        return listInscripcionEntrenador;
    }

    public List<Cliente> getListClienteEntrenador() {
        return listClienteEntrenador;
    }
}