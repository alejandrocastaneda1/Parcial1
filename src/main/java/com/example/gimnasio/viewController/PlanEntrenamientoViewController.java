package com.example.gimnasio.viewController;

import com.example.gimnasio.model.EstadoPlan;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanEntrenamientoViewController {

    @FXML
    private TableView<PlanEntrenamiento> tablaPlanes;

    @FXML
    private TableColumn<PlanEntrenamiento, String> colCodigo;

    @FXML
    private TableColumn<PlanEntrenamiento, String> colNombre;

    @FXML
    private TableColumn<PlanEntrenamiento, String> colDescripcion;

    @FXML
    private TableColumn<PlanEntrenamiento, Integer> colDuracion;

    @FXML
    private TableColumn<PlanEntrenamiento, Double> colValor;

    @FXML
    private TableColumn<PlanEntrenamiento, EstadoPlan> colEstado;

    @FXML
    private ComboBox<String> comboTipo;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtValor;

    @FXML
    private ComboBox<EstadoPlan> comboEstado;

    @FXML
    private TextField txtSesiones;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextArea txtObjetivos;

    private List<PlanEntrenamiento> listaPlanes = new ArrayList<>();


    @FXML
    public void initialize() {

        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colDescripcion.setCellValueFactory(
                new PropertyValueFactory<>("descripcion"));

        colDuracion.setCellValueFactory(
                new PropertyValueFactory<>("duracionMeses"));

        colValor.setCellValueFactory(
                new PropertyValueFactory<>("valorMensual"));

        colEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado"));

        comboTipo.setItems(FXCollections.observableArrayList(
                "Plan Básico",
                "Plan Premium",
                "Plan Personalizado"
        ));

        comboEstado.setItems(
                FXCollections.observableArrayList(EstadoPlan.values())
        );

        comboTipo.setValue("Plan Básico");

        if (EstadoPlan.values().length > 0) {
            comboEstado.setValue(EstadoPlan.values()[0]);
        }

        cargarEjemplos();
        actualizarTabla();
    }


    private void cargarEjemplos() {

        PlanBasico basico = new PlanBasico(
                "BAS-001",
                "Plan Básico",
                "Acceso general al gimnasio.",
                3,
                80000,
                EstadoPlan.values()[0]
        );

        basico.agregarBeneficio("Acceso a zona de pesas");
        basico.agregarBeneficio("Acceso a cardio");

        listaPlanes.add(basico);


        PlanPremium premium = new PlanPremium(
                "PRE-001",
                "Plan Premium",
                "Plan completo con beneficios adicionales.",
                6,
                140000,
                EstadoPlan.values()[0]
        );

        premium.agregarBeneficio("Clases grupales");
        premium.agregarBeneficio("Acceso a todas las zonas");

        listaPlanes.add(premium);


        PlanPersonalizado personalizado = new PlanPersonalizado.Builder()
                .codigo("PER-001")
                .nombre("Plan Personalizado")
                .descripcion("Plan diseñado según los objetivos del cliente.")
                .duracionMeses(12)
                .valorMensual(220000)
                .estado(EstadoPlan.values()[0])
                .cantidadSesionesEntrenador(8)
                .especialidadRequerida("Musculación")
                .objetivosCliente("Aumento de masa muscular")
                .build();

        personalizado.agregarBeneficio("Entrenador personalizado");
        personalizado.agregarBeneficio("Plan adaptado al cliente");

        listaPlanes.add(personalizado);
    }


    private void actualizarTabla() {

        tablaPlanes.setItems(
                FXCollections.observableArrayList(listaPlanes)
        );
    }


    @FXML
    private void crearPlan() {

        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String descripcion = txtDescripcion.getText();

        int duracion = Integer.parseInt(
                txtDuracion.getText()
        );

        double valor = Double.parseDouble(
                txtValor.getText()
        );

        EstadoPlan estado = comboEstado.getValue();

        String tipo = comboTipo.getValue();


        PlanEntrenamiento plan;


        if (tipo.equals("Plan Básico")) {

            plan = new PlanBasico(
                    codigo,
                    nombre,
                    descripcion,
                    duracion,
                    valor,
                    estado
            );

        } else if (tipo.equals("Plan Premium")) {

            plan = new PlanPremium(
                    codigo,
                    nombre,
                    descripcion,
                    duracion,
                    valor,
                    estado
            );

        } else {

            int sesiones = Integer.parseInt(
                    txtSesiones.getText()
            );

            plan = new PlanPersonalizado.Builder()
                    .codigo(codigo)
                    .nombre(nombre)
                    .descripcion(descripcion)
                    .duracionMeses(duracion)
                    .valorMensual(valor)
                    .estado(estado)
                    .cantidadSesionesEntrenador(sesiones)
                    .especialidadRequerida(
                            txtEspecialidad.getText()
                    )
                    .objetivosCliente(
                            txtObjetivos.getText()
                    )
                    .build();
        }


        listaPlanes.add(plan);

        actualizarTabla();

        limpiar();
    }


    @FXML
    private void eliminarPlan() {

        PlanEntrenamiento seleccionado =
                tablaPlanes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            listaPlanes.remove(seleccionado);

            actualizarTabla();
        }
    }


    @FXML
    private void cargarPlan() {

        PlanEntrenamiento seleccionado =
                tablaPlanes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            txtCodigo.setText(
                    seleccionado.getCodigo()
            );

            txtNombre.setText(
                    seleccionado.getNombre()
            );

            txtDescripcion.setText(
                    seleccionado.getDescripcion()
            );

            txtDuracion.setText(
                    String.valueOf(
                            seleccionado.getDuracionMeses()
                    )
            );

            txtValor.setText(
                    String.valueOf(
                            seleccionado.getValorMensual()
                    )
            );

            comboEstado.setValue(
                    seleccionado.getEstado()
            );


            if (seleccionado instanceof PlanBasico) {

                comboTipo.setValue("Plan Básico");

            } else if (seleccionado instanceof PlanPremium) {

                comboTipo.setValue("Plan Premium");

            } else if (seleccionado instanceof PlanPersonalizado) {

                comboTipo.setValue("Plan Personalizado");

                PlanPersonalizado personalizado =
                        (PlanPersonalizado) seleccionado;

                txtSesiones.setText(
                        String.valueOf(
                                personalizado.getCantidadSesionesEntrenador()
                        )
                );

                txtEspecialidad.setText(
                        personalizado.getEspecialidadRequerida()
                );

                txtObjetivos.setText(
                        personalizado.getObjetivosCliente()
                );
            }
        }
    }


    @FXML
    private void limpiar() {

        txtCodigo.clear();
        txtNombre.clear();
        txtDescripcion.clear();
        txtDuracion.clear();
        txtValor.clear();

        txtSesiones.clear();
        txtEspecialidad.clear();
        txtObjetivos.clear();

        comboTipo.setValue("Plan Básico");

        if (EstadoPlan.values().length > 0) {
            comboEstado.setValue(
                    EstadoPlan.values()[0]
            );
        }
    }


    // ==========================================
    // NAVEGACIÓN
    // ==========================================

    @FXML
    private void abrirInicio() {
        cambiarVista("Inicio.fxml");
    }


    @FXML
    private void abrirClientes() {
        cambiarVista("Cliente.fxml");
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
                    (Stage) tablaPlanes.getScene().getWindow();

            stage.setScene(
                    new Scene(vista)
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}