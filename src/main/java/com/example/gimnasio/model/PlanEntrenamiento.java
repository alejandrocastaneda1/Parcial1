package com.example.gimnasio.model;

import java.util.ArrayList;
import java.util.List;

public abstract class PlanEntrenamiento {

    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionMeses;
    private double valorMensual;
    private EstadoPlan estado;

    private List<Beneficio> listBeneficios = new ArrayList<>();

    public PlanEntrenamiento(String codigo, String nombre, String descripcion, int duracionMeses, double valorMensual, EstadoPlan estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMeses = duracionMeses;
        this.valorMensual = valorMensual;
        this.estado = estado;
    }

    public void agregarBeneficio(String beneficio) {
        listBeneficios.add(new Beneficio(beneficio, ""));
    }

    public double calcularValorBase(int meses) {
        return valorMensual * meses;
    }

    // Por defecto un plan no incluye sesiones con entrenador.
    // PlanPersonalizado sobreescribe este metodo.
    public double calcularCostoEntrenador(double tarifaSesion) {
        return 0.0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public EstadoPlan getEstado() {
        return estado;
    }

    public void setEstado(EstadoPlan estado) {
        this.estado = estado;
    }

    public List<Beneficio> getListBeneficios() {
        return listBeneficios;
    }
}
