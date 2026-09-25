package com.example.gimnasio.model;

public class FactoryPlanPersonalizado implements FactoryPlanEntrenamiento {

    private int cantidadSesionesEntrenador;
    private String especialidadRequerida;
    private String objetivosCliente;

    public FactoryPlanPersonalizado(int cantidadSesionesEntrenador, String especialidadRequerida, String objetivosCliente) {
        this.cantidadSesionesEntrenador = cantidadSesionesEntrenador;
        this.especialidadRequerida = especialidadRequerida;
        this.objetivosCliente = objetivosCliente;
    }

    @Override
    public PlanEntrenamiento crearPlan(String codigo, String nombre, String descripcion, int duracionMeses, double valorMensual, EstadoPlan estado) {
        return new PlanPersonalizado.Builder()
                .codigo(codigo)
                .nombre(nombre)
                .descripcion(descripcion)
                .duracionMeses(duracionMeses)
                .valorMensual(valorMensual)
                .estado(estado)
                .cantidadSesionesEntrenador(cantidadSesionesEntrenador)
                .especialidadRequerida(especialidadRequerida)
                .objetivosCliente(objetivosCliente)
                .build();
    }
}
