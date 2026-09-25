package com.example.gimnasio.model;

import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Entrenador;
import com.example.gimnasio.model.PlanEntrenamiento;
import com.example.gimnasio.model.ServicioAdicional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inscripcion {

    private String codigo;
    private LocalDate fechaInscripcion;
    private int duracionContratada;
    private double descuento;
    private double valorFinal;

    private Cliente theCliente;
    private PlanEntrenamiento thePlan;
    private Entrenador theEntrenador;
    private List<ServicioAdicional> listServicioAdicionalInscripcion = new ArrayList<>();

    public Inscripcion(String codigo, LocalDate fechaInscripcion, int duracionContratada, double descuento, Cliente cliente, PlanEntrenamiento plan) {
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.duracionContratada = duracionContratada;
        this.descuento = descuento;
        this.theCliente = cliente;
        this.thePlan = plan;
        if (cliente != null) {
            cliente.agregarInscripcion(this);
        }
    }

    public void agregarServicio(ServicioAdicional servicio) {
        listServicioAdicionalInscripcion.add(servicio);
    }

    public void asignarEntrenador(Entrenador entrenador) {
        this.theEntrenador = entrenador;
        if (entrenador != null) {
            entrenador.agregarInscripcion(this);
            entrenador.agregarCliente(this.theCliente);
        }
    }

    public double calcularValorPlan() {
        return thePlan.calcularValorBase(duracionContratada);
    }

    public double calcularValorServicios() {
        double total = 0.0;
        for (ServicioAdicional servicio : listServicioAdicionalInscripcion) {
            total += servicio.getPrecio();
        }
        return total;
    }

    public double calcularCostoEntrenador() {
        if (theEntrenador == null) {
            return 0.0;
        }
        return thePlan.calcularCostoEntrenador(theEntrenador.getTarifaSesion());
    }

    public double calcularValorFinal() {
        double total = calcularValorPlan() + calcularValorServicios() + calcularCostoEntrenador() - descuento;
        this.valorFinal = total;
        return total;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public int getDuracionContratada() {
        return duracionContratada;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public Cliente getTheCliente() {
        return theCliente;
    }

    public PlanEntrenamiento getThePlan() {
        return thePlan;
    }

    public Entrenador getTheEntrenador() {
        return theEntrenador;
    }

    public List<ServicioAdicional> getListServicioAdicionalInscripcion() {
        return listServicioAdicionalInscripcion;
    }
}