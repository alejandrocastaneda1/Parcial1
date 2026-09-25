package com.example.gimnasio.model;

import com.example.gimnasio.model.EstadoPlan;
import com.example.gimnasio.model.PlanEntrenamiento;

public class PlanPersonalizado extends PlanEntrenamiento {

    private int cantidadSesionesEntrenador;
    private String especialidadRequerida;
    private String objetivosCliente;

    public PlanPersonalizado(Builder builder) {
        super(builder.codigo, builder.nombre, builder.descripcion, builder.duracionMeses, builder.valorMensual, builder.estado);
        this.cantidadSesionesEntrenador = builder.cantidadSesionesEntrenador;
        this.especialidadRequerida = builder.especialidadRequerida;
        this.objetivosCliente = builder.objetivosCliente;
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

    public static class Builder {
        private String codigo;
        private String nombre;
        private String descripcion;
        private int duracionMeses;
        private double valorMensual;
        private EstadoPlan estado;
        private int cantidadSesionesEntrenador;
        private String especialidadRequerida;
        private String objetivosCliente;

        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder duracionMeses(int duracionMeses) {
            this.duracionMeses = duracionMeses;
            return this;
        }

        public Builder valorMensual(double valorMensual) {
            this.valorMensual = valorMensual;
            return this;
        }

        public Builder estado(EstadoPlan estado) {
            this.estado = estado;
            return this;
        }

        public Builder cantidadSesionesEntrenador(int cantidadSesionesEntrenador) {
            this.cantidadSesionesEntrenador = cantidadSesionesEntrenador;
            return this;
        }

        public Builder especialidadRequerida(String especialidadRequerida) {
            this.especialidadRequerida = especialidadRequerida;
            return this;
        }

        public Builder objetivosCliente(String objetivosCliente) {
            this.objetivosCliente = objetivosCliente;
            return this;
        }

        public PlanPersonalizado build() {
            return new PlanPersonalizado(this);
        }
    }
}