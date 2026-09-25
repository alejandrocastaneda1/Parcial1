package com.example.gimnasio.model;

import com.example.gimnasio.model.EstadoPlan;
import com.example.gimnasio.model.PlanEntrenamiento;

public class PlanPersonalizado extends PlanEntrenamiento {

    private int cantidadSesionesEntrenador;
    private String especialidadRequerida;
    private String objetivosCliente;

    public PlanPersonalizado(String codigo, String nombre, String descripcion, int duracionMeses, double valorMensual,
                             EstadoPlan estado, int cantidadSesionesEntrenador, String especialidadRequerida, String objetivosCliente) {
        super(codigo, nombre, descripcion, duracionMeses, valorMensual, estado);
        this.cantidadSesionesEntrenador = cantidadSesionesEntrenador;
        this.especialidadRequerida = especialidadRequerida;
        this.objetivosCliente = objetivosCliente;
    }

    @Override
    public double calcularCostoEntrenador(double tarifaSesion) {
        return tarifaSesion * cantidadSesionesEntrenador;
    }

    public int getCantidadSesionesEntrenador() {
        return cantidadSesionesEntrenador;
    }

    public String getEspecialidadRequerida() {
        return especialidadRequerida;
    }

    public String getObjetivosCliente() {
        return objetivosCliente;
    }
}