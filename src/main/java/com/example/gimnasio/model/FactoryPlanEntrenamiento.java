package com.example.gimnasio.model;

public interface FactoryPlanEntrenamiento {

    PlanEntrenamiento crearPlan(String codigo, String nombre, String descripcion, int duracionMeses, double valorMensual, EstadoPlan estado);
}
