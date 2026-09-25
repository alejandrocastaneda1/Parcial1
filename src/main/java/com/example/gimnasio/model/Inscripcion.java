package com.example.gimnasio.model;

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
    private List<ServicioAdicional> listServicioAdicionalInscripcion;

    public Inscripcion(Builder builder) {
        this.codigo = builder.codigo;
        this.fechaInscripcion = builder.fechaInscripcion;
        this.duracionContratada = builder.duracionContratada;
        this.descuento = builder.descuento;
        this.listServicioAdicionalInscripcion = new ArrayList<>();
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

    public static class Builder{
        private String codigo;
        private LocalDate fechaInscripcion;
        private int duracionContratada;
        private double descuento;
        private double valorFinal;

        public Builder codigo(String codigo){
            this.codigo = codigo;
            return this;
        }

        public Builder fechaInscripcion(LocalDate fechaInscripcion){
            this.fechaInscripcion = fechaInscripcion;
            return this;
        }

        public Builder duracionContratada(int duracionContratada){
            this.duracionContratada = duracionContratada;
            return this;
        }

        public Builder descuento(double descuento){
            this.descuento = descuento;
            return this;
        }

        public Builder valorFinal(double valorFinal){
            this.valorFinal = valorFinal;
            return this;
        }

        public Inscripcion build(){
            return new Inscripcion(this);
        }


    }

}