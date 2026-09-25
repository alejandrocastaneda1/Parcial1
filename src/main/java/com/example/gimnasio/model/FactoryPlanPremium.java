package com.example.gimnasio.model;

public class FactoryPlanPremium implements FactoryPlanEntrenamiento {

    @Override
    public PlanEntrenamiento crearPlan(String codigo, String nombre, String descripcion, int duracionMeses, double valorMensual, EstadoPlan estado) {
        return new PlanPremium(codigo, nombre, descripcion, duracionMeses, valorMensual, estado);
    }
}
