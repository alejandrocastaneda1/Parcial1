package com.example.gimnasio.model;

public class FactoryPlanBasico implements FactoryPlanEntrenamiento {

    @Override
    public PlanEntrenamiento crearPlan(String codigo, String nombre, String descripcion, int duracionMeses, double valorMensual, EstadoPlan estado) {
        return new PlanBasico(codigo, nombre, descripcion, duracionMeses, valorMensual, estado);
    }
}
