package com.example.gimnasio.model;

import com.example.gimnasio.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gimnasio {

    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String correo;

    private List<Cliente> listClientes = new ArrayList<>();
    private List<Entrenador> listEntrenadores = new ArrayList<>();
    private List<PlanEntrenamiento> listPlanEntrenamientos = new ArrayList<>();
    private List<ServicioAdicional> listServicioAdicionales = new ArrayList<>();
    private List<Inscripcion> listInscripciones = new ArrayList<>();

    public Gimnasio(String nombreComercial, String nit, String direccion, String telefono, String correo) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public void registrarCliente(Cliente cliente) {
        listClientes.add(cliente);
    }

    public void registrarEntrenador(Entrenador entrenador) {
        listEntrenadores.add(entrenador);
    }

    public void registrarPlan(PlanEntrenamiento plan) {
        listPlanEntrenamientos.add(plan);
    }

    public void registrarServicio(ServicioAdicional servicio) {
        listServicioAdicionales.add(servicio);
    }

    public void registrarInscripcion(Inscripcion inscripcion) {
        listInscripciones.add(inscripcion);
        if (inscripcion.getTheCliente() != null) {
            inscripcion.getTheCliente().agregarInscripcion(inscripcion);
        }
    }

    public Cliente buscarClientePorTelefono(String telefono) {
        for (Cliente cliente : listClientes) {
            if (cliente.getTelefono() != null && cliente.getTelefono().equals(telefono)) {
                return cliente;
            }
        }
        return null;
    }

    public double calcularIngresos(LocalDate inicio, LocalDate fin) {
        double total = 0.0;
        for (Inscripcion inscripcion : listInscripciones) {
            LocalDate fecha = inscripcion.getFechaInscripcion();
            boolean dentroDelRango = !fecha.isBefore(inicio) && !fecha.isAfter(fin);
            if (dentroDelRango) {
                total += inscripcion.calcularValorFinal();
            }
        }
        return total;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public List<Entrenador> getListEntrenadores() {
        return listEntrenadores;
    }

    public List<PlanEntrenamiento> getListPlanEntrenamientos() {
        return listPlanEntrenamientos;
    }

    public List<ServicioAdicional> getListServicioAdicionales() {
        return listServicioAdicionales;
    }

    public List<Inscripcion> getListInscripciones() {
        return listInscripciones;
    }
}