package com.example.gimnasio;

import com.example.gimnasio.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class GimnasioTest {

    // =====================================================
    // BENEFICIO
    // =====================================================

    @Test
    void probarBeneficio() {

        Beneficio beneficio = new Beneficio(
                "Zona deportiva",
                "Acceso a zona deportiva"
        );

        assertEquals("Zona deportiva", beneficio.getNombre());
        assertEquals(
                "Acceso a zona deportiva",
                beneficio.getDescripcion()
        );

        assertEquals(
                "Zona deportiva - Acceso a zona deportiva",
                beneficio.toString()
        );
    }


    // =====================================================
    // CLIENTE
    // =====================================================

    @Test
    void probarCliente() {

        LocalDate fecha = LocalDate.now();

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                fecha
        );

        assertEquals("Alejandro", cliente.getNombre());
        assertEquals("123456", cliente.getCedula());
        assertEquals("3001234567", cliente.getTelefono());
        assertEquals("alejandro@gmail.com", cliente.getCorreo());
        assertEquals(20, cliente.getEdad());
        assertEquals(fecha, cliente.getFechaRegistro());
    }


    // =====================================================
    // ENTRENADOR
    // =====================================================

    @Test
    void probarCostoSesionesEntrenador() {

        Entrenador entrenador = new Entrenador(
                "E001",
                "Carlos",
                "Musculación",
                "3001111111",
                50000
        );

        assertEquals(
                150000,
                entrenador.calcularCostoSesiones(3)
        );
    }


    @Test
    void probarAgregarClienteEntrenador() {

        Entrenador entrenador = new Entrenador(
                "E001",
                "Carlos",
                "Musculación",
                "3001111111",
                50000
        );

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        entrenador.agregarCliente(cliente);

        assertEquals(
                1,
                entrenador.getListClienteEntrenador().size()
        );

        assertTrue(
                entrenador.getListClienteEntrenador().contains(cliente)
        );
    }


    @Test
    void probarNoAgregarClienteDosVeces() {

        Entrenador entrenador = new Entrenador(
                "E001",
                "Carlos",
                "Musculación",
                "3001111111",
                50000
        );

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        entrenador.agregarCliente(cliente);
        entrenador.agregarCliente(cliente);

        assertEquals(
                1,
                entrenador.getListClienteEntrenador().size()
        );
    }


    // =====================================================
    // PLAN BÁSICO
    // =====================================================

    @Test
    void probarValorBasePlan() {

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico del gimnasio",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        assertEquals(
                300000,
                plan.calcularValorBase(3)
        );
    }


    @Test
    void probarAgregarBeneficio() {

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        plan.agregarBeneficio(
                "Acceso a zona deportiva"
        );

        assertEquals(
                1,
                plan.getListaBeneficios().size()
        );
    }


    @Test
    void probarCambiarEstadoPlan() {

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        plan.setEstado(EstadoPlan.SUSPENDIDO);

        assertEquals(
                EstadoPlan.SUSPENDIDO,
                plan.getEstado()
        );
    }


    @Test
    void probarCostoEntrenadorPlanBasico() {

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        assertEquals(
                0,
                plan.calcularCostoEntrenador(50000)
        );
    }


    // =====================================================
    // PLAN PERSONALIZADO
    // =====================================================

    @Test
    void probarCostoEntrenadorPlanPersonalizado() {

        PlanPersonalizado plan = new PlanPersonalizado.Builder()
                .codigo("P003")
                .nombre("Plan Personalizado")
                .descripcion("Plan personalizado")
                .duracionMeses(3)
                .valorMensual(200000)
                .estado(EstadoPlan.ACTIVO)
                .cantidadSesionesEntrenador(4)
                .especialidadRequerida("Musculación")
                .objetivosCliente("Aumentar masa muscular")
                .build();

        assertEquals(
                200000,
                plan.calcularCostoEntrenador(50000)
        );
    }


    @Test
    void probarDatosPlanPersonalizado() {

        PlanPersonalizado plan = new PlanPersonalizado.Builder()
                .codigo("P003")
                .nombre("Plan Personalizado")
                .descripcion("Plan personalizado")
                .duracionMeses(3)
                .valorMensual(200000)
                .estado(EstadoPlan.ACTIVO)
                .cantidadSesionesEntrenador(4)
                .especialidadRequerida("Musculación")
                .objetivosCliente("Aumentar masa muscular")
                .build();

        assertEquals(
                4,
                plan.getCantidadSesionesEntrenador()
        );

        assertEquals(
                "Musculación",
                plan.getEspecialidadRequerida()
        );

        assertEquals(
                "Aumentar masa muscular",
                plan.getObjetivosCliente()
        );
    }


    // =====================================================
    // SERVICIO ADICIONAL
    // =====================================================

    @Test
    void probarServicioAdicional() {

        ServicioAdicional servicio = new ServicioAdicional(
                "S001",
                "Clase grupal",
                "Clase de entrenamiento grupal",
                30000,
                true
        );

        assertEquals(
                "Clase grupal",
                servicio.getNombre()
        );

        assertEquals(
                30000,
                servicio.getPrecio()
        );

        assertTrue(
                servicio.estaDisponible()
        );
    }


    @Test
    void probarCambiarDisponibilidadServicio() {

        ServicioAdicional servicio = new ServicioAdicional(
                "S001",
                "Clase grupal",
                "Clase de entrenamiento grupal",
                30000,
                true
        );

        servicio.setDisponible(false);

        assertFalse(
                servicio.estaDisponible()
        );
    }


    @Test
    void probarCambiarPrecioServicio() {

        ServicioAdicional servicio = new ServicioAdicional(
                "S001",
                "Clase grupal",
                "Clase grupal",
                30000,
                true
        );

        servicio.setPrecio(40000);

        assertEquals(
                40000,
                servicio.getPrecio()
        );
    }


    // =====================================================
    // INSCRIPCIÓN
    // =====================================================

    @Test
    void probarInscripcion() {

        LocalDate fecha = LocalDate.now();

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                fecha
        );

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        Inscripcion inscripcion = new Inscripcion.Builder()
                .codigo("I001")
                .fechaInscripcion(fecha)
                .duracionContratada(3)
                .descuento(0)
                .cliente(cliente)
                .plan(plan)
                .build();

        assertNotNull(inscripcion);

        assertEquals(
                "I001",
                inscripcion.getCodigo()
        );

        assertEquals(
                cliente,
                inscripcion.getTheCliente()
        );

        assertEquals(
                plan,
                inscripcion.getThePlan()
        );
    }


    @Test
    void probarValorPlanInscripcion() {

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        Inscripcion inscripcion = new Inscripcion.Builder()
                .codigo("I001")
                .fechaInscripcion(LocalDate.now())
                .duracionContratada(3)
                .descuento(0)
                .cliente(cliente)
                .plan(plan)
                .build();

        assertEquals(
                300000,
                inscripcion.calcularValorPlan()
        );
    }


    @Test
    void probarAgregarServicioInscripcion() {

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        Inscripcion inscripcion = new Inscripcion.Builder()
                .codigo("I001")
                .fechaInscripcion(LocalDate.now())
                .duracionContratada(3)
                .descuento(0)
                .cliente(cliente)
                .plan(plan)
                .build();

        ServicioAdicional servicio = new ServicioAdicional(
                "S001",
                "Clase grupal",
                "Clase grupal",
                30000,
                true
        );

        inscripcion.agregarServicio(servicio);

        assertEquals(
                30000,
                inscripcion.calcularValorServicios()
        );
    }


    @Test
    void probarCostoEntrenadorInscripcion() {

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        PlanPersonalizado plan = new PlanPersonalizado.Builder()
                .codigo("P003")
                .nombre("Plan Personalizado")
                .descripcion("Plan personalizado")
                .duracionMeses(3)
                .valorMensual(200000)
                .estado(EstadoPlan.ACTIVO)
                .cantidadSesionesEntrenador(4)
                .especialidadRequerida("Musculación")
                .objetivosCliente("Ganar masa muscular")
                .build();

        Inscripcion inscripcion = new Inscripcion.Builder()
                .codigo("I001")
                .fechaInscripcion(LocalDate.now())
                .duracionContratada(3)
                .descuento(0)
                .cliente(cliente)
                .plan(plan)
                .build();

        Entrenador entrenador = new Entrenador(
                "E001",
                "Carlos",
                "Musculación",
                "3001111111",
                50000
        );

        inscripcion.asignarEntrenador(entrenador);

        assertEquals(
                200000,
                inscripcion.calcularCostoEntrenador()
        );
    }


    @Test
    void probarValorFinalInscripcion() {

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        Inscripcion inscripcion = new Inscripcion.Builder()
                .codigo("I001")
                .fechaInscripcion(LocalDate.now())
                .duracionContratada(3)
                .descuento(10000)
                .cliente(cliente)
                .plan(plan)
                .build();

        ServicioAdicional servicio = new ServicioAdicional(
                "S001",
                "Clase grupal",
                "Clase grupal",
                30000,
                true
        );

        inscripcion.agregarServicio(servicio);

        assertEquals(
                320000,
                inscripcion.calcularValorFinal()
        );
    }


    // =====================================================
    // GIMNASIO
    // =====================================================

    @Test
    void probarRegistrarClienteGimnasio() {

        Gimnasio gimnasio = new Gimnasio(
                "Smart Gym",
                "900123456",
                "Armenia",
                "3001234567",
                "gym@gmail.com"
        );

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        gimnasio.registrarCliente(cliente);

        assertEquals(
                1,
                gimnasio.getListClientes().size()
        );
    }


    @Test
    void probarRegistrarEntrenadorGimnasio() {

        Gimnasio gimnasio = new Gimnasio(
                "Smart Gym",
                "900123456",
                "Armenia",
                "3001234567",
                "gym@gmail.com"
        );

        Entrenador entrenador = new Entrenador(
                "E001",
                "Carlos",
                "Musculación",
                "3001111111",
                50000
        );

        gimnasio.registrarEntrenador(entrenador);

        assertEquals(
                1,
                gimnasio.getListEntrenadores().size()
        );
    }


    @Test
    void probarRegistrarPlanGimnasio() {

        Gimnasio gimnasio = new Gimnasio(
                "Smart Gym",
                "900123456",
                "Armenia",
                "3001234567",
                "gym@gmail.com"
        );

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                3,
                100000,
                EstadoPlan.ACTIVO
        );

        gimnasio.registrarPlan(plan);

        assertEquals(
                1,
                gimnasio.getListPlanEntrenamientos().size()
        );
    }


    @Test
    void probarBuscarClientePorTelefono() {

        Gimnasio gimnasio = new Gimnasio(
                "Smart Gym",
                "900123456",
                "Armenia",
                "3001234567",
                "gym@gmail.com"
        );

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        gimnasio.registrarCliente(cliente);

        Cliente resultado =
                gimnasio.buscarClientePorTelefono("3001234567");

        assertEquals(
                cliente,
                resultado
        );
    }


    @Test
    void probarClienteNoEncontrado() {

        Gimnasio gimnasio = new Gimnasio(
                "Smart Gym",
                "900123456",
                "Armenia",
                "3001234567",
                "gym@gmail.com"
        );

        Cliente resultado =
                gimnasio.buscarClientePorTelefono("9999999999");

        assertNull(resultado);
    }


    @Test
    void probarCalcularIngresos() {

        Gimnasio gimnasio = new Gimnasio(
                "Smart Gym",
                "900123456",
                "Armenia",
                "3001234567",
                "gym@gmail.com"
        );

        Cliente cliente = new Cliente(
                "Alejandro",
                "123456",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        );

        PlanBasico plan = new PlanBasico(
                "P001",
                "Plan Básico",
                "Plan básico",
                1,
                100000,
                EstadoPlan.ACTIVO
        );

        Inscripcion inscripcion = new Inscripcion.Builder()
                .codigo("I001")
                .fechaInscripcion(LocalDate.now())
                .duracionContratada(1)
                .descuento(0)
                .cliente(cliente)
                .plan(plan)
                .build();

        gimnasio.registrarCliente(cliente);
        gimnasio.registrarPlan(plan);
        gimnasio.registrarInscripcion(inscripcion);

        double ingresos = gimnasio.calcularIngresos(
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(1)
        );

        assertEquals(
                100000,
                ingresos
        );
    }
}