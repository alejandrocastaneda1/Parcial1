package com.example.gimnasio.viewController;

import com.example.gimnasio.model.Cliente;
import com.example.gimnasio.model.Entrenador;
import com.example.gimnasio.model.EstadoPlan;
import com.example.gimnasio.model.Inscripcion;
import com.example.gimnasio.model.PlanBasico;
import com.example.gimnasio.model.PlanEntrenamiento;
import com.example.gimnasio.model.PlanPersonalizado;
import com.example.gimnasio.model.PlanPremium;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InscripcionViewController {

    @FXML
    private TableView<Inscripcion> tablaInscripciones;

    @FXML
    private TableColumn<Inscripcion, String> colCodigo;

    @FXML
    private TableColumn<Inscripcion, LocalDate> colFecha;

    @FXML
    private TableColumn<Inscripcion, String> colCliente;

    @FXML
    private TableColumn<Inscripcion, String> colPlan;

    @FXML
    private TableColumn<Inscripcion, Integer> colDuracion;

    @FXML
    private TableColumn<Inscripcion, Double> colValor;


    @FXML
    private TextField txtCodigo;

    @FXML
    private DatePicker dateFecha;

    @FXML
    private ComboBox<Cliente> comboCliente;

    @FXML
    private ComboBox<PlanEntrenamiento> comboPlan;

    @FXML
    private ComboBox<Entrenador> comboEntrenador;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtDescuento;

    @FXML
    private Label lblValorPlan;

    @FXML
    private Label lblCostoEntrenador;

    @FXML
    private Label lblValorFinal;


    private List<Cliente> listaClientes = new ArrayList<>();

    private List<PlanEntrenamiento> listaPlanes = new ArrayList<>();

    private List<Entrenador> listaEntrenadores = new ArrayList<>();

    private List<Inscripcion> listaInscripciones = new ArrayList<>();


    @FXML
    public void initialize() {

        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo")
        );

        colFecha.setCellValueFactory(
                new PropertyValueFactory<>("fechaInscripcion")
        );

        colDuracion.setCellValueFactory(
                new PropertyValueFactory<>("duracionContratada")
        );

        colValor.setCellValueFactory(
                new PropertyValueFactory<>("valorFinal")
        );


        cargarClientes();

        cargarPlanes();

        cargarEntrenadores();

        cargarCombos();

        cargarEjemplos();

        dateFecha.setValue(LocalDate.now());

        actualizarTabla();
    }


    private void cargarClientes() {

        listaClientes.add(
                new Cliente(
                        "Alejandro Castañeda",
                        "1001001001",
                        "3001234567",
                        "alejandro@gmail.com",
                        20,
                        LocalDate.now()
                )
        );

        listaClientes.add(
                new Cliente(
                        "Laura Martínez",
                        "1002002002",
                        "3019876543",
                        "laura@gmail.com",
                        24,
                        LocalDate.now()
                )
        );

        listaClientes.add(
                new Cliente(
                        "Carlos Rodríguez",
                        "1003003003",
                        "3104567890",
                        "carlos@gmail.com",
                        29,
                        LocalDate.now()
                )
        );
    }


    private void cargarPlanes() {

        listaPlanes.add(
                new PlanBasico(
                        "BAS-001",
                        "Plan Básico",
                        "Acceso a las zonas principales del gimnasio.",
                        3,
                        80000,
                        EstadoPlan.values()[0]
                )
        );

        listaPlanes.add(
                new PlanPremium(
                        "PRE-001",
                        "Plan Premium",
                        "Acceso completo y clases grupales.",
                        6,
                        140000,
                        EstadoPlan.values()[0]
                )
        );

        listaPlanes.add(
                new PlanPersonalizado.Builder()
                        .codigo("PER-001")
                        .nombre("Plan Personalizado")
                        .descripcion("Plan diseñado según los objetivos del cliente.")
                        .duracionMeses(12)
                        .valorMensual(220000)
                        .estado(EstadoPlan.values()[0])
                        .cantidadSesionesEntrenador(8)
                        .especialidadRequerida("Musculación")
                        .objetivosCliente("Aumento de masa muscular")
                        .build()
        );
    }


    private void cargarEntrenadores() {

        listaEntrenadores.add(
                new Entrenador(
                        "ENT-001",
                        "Carlos Gómez",
                        "Musculación",
                        "3001112233",
                        35000
                )
        );

        listaEntrenadores.add(
                new Entrenador(
                        "ENT-002",
                        "Laura Pérez",
                        "Cardio",
                        "3012223344",
                        30000
                )
        );

        listaEntrenadores.add(
                new Entrenador(
                        "ENT-003",
                        "Andrés Ramírez",
                        "Entrenamiento funcional",
                        "3103334455",
                        40000
                )
        );
    }


    private void cargarCombos() {

        comboCliente.setItems(
                FXCollections.observableArrayList(listaClientes)
        );

        comboPlan.setItems(
                FXCollections.observableArrayList(listaPlanes)
        );

        comboEntrenador.setItems(
                FXCollections.observableArrayList(listaEntrenadores)
        );

        comboCliente.setCellFactory(
                lista -> new javafx.scene.control.ListCell<Cliente>() {
                    @Override
                    protected void updateItem(Cliente cliente, boolean empty) {
                        super.updateItem(cliente, empty);

                        if (empty || cliente == null) {
                            setText(null);
                        } else {
                            setText(cliente.getNombre());
                        }
                    }
                }
        );

        comboCliente.setButtonCell(
                new javafx.scene.control.ListCell<Cliente>() {
                    @Override
                    protected void updateItem(Cliente cliente, boolean empty) {
                        super.updateItem(cliente, empty);

                        if (empty || cliente == null) {
                            setText(null);
                        } else {
                            setText(cliente.getNombre());
                        }
                    }
                }
        );


        comboPlan.setCellFactory(
                lista -> new javafx.scene.control.ListCell<PlanEntrenamiento>() {
                    @Override
                    protected void updateItem(
                            PlanEntrenamiento plan,
                            boolean empty
                    ) {
                        super.updateItem(plan, empty);

                        if (empty || plan == null) {
                            setText(null);
                        } else {
                            setText(plan.getNombre());
                        }
                    }
                }
        );

        comboPlan.setButtonCell(
                new javafx.scene.control.ListCell<PlanEntrenamiento>() {
                    @Override
                    protected void updateItem(
                            PlanEntrenamiento plan,
                            boolean empty
                    ) {
                        super.updateItem(plan, empty);

                        if (empty || plan == null) {
                            setText(null);
                        } else {
                            setText(plan.getNombre());
                        }
                    }
                }
        );


        comboEntrenador.setCellFactory(
                lista -> new javafx.scene.control.ListCell<Entrenador>() {
                    @Override
                    protected void updateItem(
                            Entrenador entrenador,
                            boolean empty
                    ) {
                        super.updateItem(entrenador, empty);

                        if (empty || entrenador == null) {
                            setText(null);
                        } else {
                            setText(entrenador.getNombre());
                        }
                    }
                }
        );

        comboEntrenador.setButtonCell(
                new javafx.scene.control.ListCell<Entrenador>() {
                    @Override
                    protected void updateItem(
                            Entrenador entrenador,
                            boolean empty
                    ) {
                        super.updateItem(entrenador, empty);

                        if (empty || entrenador == null) {
                            setText(null);
                        } else {
                            setText(entrenador.getNombre());
                        }
                    }
                }
        );
    }


    private void cargarEjemplos() {

        if (listaClientes.isEmpty()
                || listaPlanes.isEmpty()) {
            return;
        }

        Inscripcion inscripcion = new Inscripcion.Builder()
                .codigo("INS-001")
                .fechaInscripcion(LocalDate.now())
                .duracionContratada(3)
                .descuento(20000)
                .cliente(listaClientes.get(0))
                .plan(listaPlanes.get(0))
                .build();

        inscripcion.asignarEntrenador(
                listaEntrenadores.get(0)
        );

        inscripcion.calcularValorFinal();

        listaInscripciones.add(inscripcion);
    }


    private void actualizarTabla() {

        tablaInscripciones.setItems(
                FXCollections.observableArrayList(listaInscripciones)
        );
    }


    @FXML
    private void calcularValor() {

        PlanEntrenamiento plan =
                comboPlan.getValue();

        Entrenador entrenador =
                comboEntrenador.getValue();

        if (plan == null) {
            return;
        }

        int duracion =
                Integer.parseInt(txtDuracion.getText());

        double descuento = 0;

        if (!txtDescuento.getText().isEmpty()) {
            descuento =
                    Double.parseDouble(txtDescuento.getText());
        }


        double valorPlan =
                plan.calcularValorBase(duracion);

        double costoEntrenador = 0;

        if (entrenador != null) {

            costoEntrenador =
                    plan.calcularCostoEntrenador(
                            entrenador.getTarifaSesion()
                    );
        }


        double valorFinal =
                valorPlan
                        + costoEntrenador
                        - descuento;


        lblValorPlan.setText(
                "$ " + String.format("%.0f", valorPlan)
        );

        lblCostoEntrenador.setText(
                "$ " + String.format("%.0f", costoEntrenador)
        );

        lblValorFinal.setText(
                "$ " + String.format("%.0f", valorFinal)
        );
    }


    @FXML
    private void crearInscripcion() {

        Cliente cliente =
                comboCliente.getValue();

        PlanEntrenamiento plan =
                comboPlan.getValue();

        Entrenador entrenador =
                comboEntrenador.getValue();


        if (cliente == null || plan == null) {
            return;
        }


        int duracion =
                Integer.parseInt(txtDuracion.getText());


        double descuento = 0;

        if (!txtDescuento.getText().isEmpty()) {
            descuento =
                    Double.parseDouble(txtDescuento.getText());
        }


        Inscripcion inscripcion =
                new Inscripcion.Builder()
                        .codigo(txtCodigo.getText())
                        .fechaInscripcion(dateFecha.getValue())
                        .duracionContratada(duracion)
                        .descuento(descuento)
                        .cliente(cliente)
                        .plan(plan)
                        .build();


        if (entrenador != null) {

            inscripcion.asignarEntrenador(entrenador);
        }


        inscripcion.calcularValorFinal();

        listaInscripciones.add(inscripcion);

        actualizarTabla();

        limpiar();
    }


    @FXML
    private void cargarInscripcion() {

        Inscripcion seleccionada =
                tablaInscripciones
                        .getSelectionModel()
                        .getSelectedItem();

        if (seleccionada != null) {

            txtCodigo.setText(
                    seleccionada.getCodigo()
            );

            dateFecha.setValue(
                    seleccionada.getFechaInscripcion()
            );

            txtDuracion.setText(
                    String.valueOf(
                            seleccionada.getDuracionContratada()
                    )
            );

            txtDescuento.setText(
                    String.valueOf(
                            seleccionada.getDescuento()
                    )
            );

            comboCliente.setValue(
                    seleccionada.getTheCliente()
            );

            comboPlan.setValue(
                    seleccionada.getThePlan()
            );

            comboEntrenador.setValue(
                    seleccionada.getTheEntrenador()
            );

            calcularValor();
        }
    }


    @FXML
    private void eliminarInscripcion() {

        Inscripcion seleccionada =
                tablaInscripciones
                        .getSelectionModel()
                        .getSelectedItem();

        if (seleccionada != null) {

            listaInscripciones.remove(seleccionada);

            actualizarTabla();

            limpiar();
        }
    }


    @FXML
    private void limpiar() {

        txtCodigo.clear();

        dateFecha.setValue(LocalDate.now());

        comboCliente.setValue(null);

        comboPlan.setValue(null);

        comboEntrenador.setValue(null);

        txtDuracion.clear();

        txtDescuento.clear();

        lblValorPlan.setText("$ 0");

        lblCostoEntrenador.setText("$ 0");

        lblValorFinal.setText("$ 0");
    }


    @FXML
    private void abrirInicio() {

        cambiarVista("Inicio.fxml");
    }


    @FXML
    private void abrirClientes() {

        cambiarVista("Cliente.fxml");
    }


    @FXML
    private void abrirEntrenadores() {

        cambiarVista("Entrenador.fxml");
    }


    @FXML
    private void abrirPlanes() {

        cambiarVista("PlanEntrenamiento.fxml");
    }


    @FXML
    private void abrirBeneficios() {

        cambiarVista("Beneficio.fxml");
    }


    private void cambiarVista(String archivo) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/gimnasio/" + archivo
                    )
            );

            Parent vista = loader.load();

            Stage stage =
                    (Stage) tablaInscripciones
                            .getScene()
                            .getWindow();

            stage.setScene(
                    new Scene(vista)
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}