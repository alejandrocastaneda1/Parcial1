package com.example.gimnasio.viewController;

import com.example.gimnasio.model.Entrenador;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorViewController {

    @FXML
    private TableView<Entrenador> tablaEntrenadores;

    @FXML
    private TableColumn<Entrenador, String> colIdentificacion;

    @FXML
    private TableColumn<Entrenador, String> colNombre;

    @FXML
    private TableColumn<Entrenador, String> colEspecialidad;

    @FXML
    private TableColumn<Entrenador, String> colTelefono;

    @FXML
    private TableColumn<Entrenador, Double> colTarifa;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtTarifa;

    private List<Entrenador> listaEntrenadores = new ArrayList<>();


    @FXML
    public void initialize() {

        colIdentificacion.setCellValueFactory(
                new PropertyValueFactory<>("identificacion")
        );

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        colEspecialidad.setCellValueFactory(
                new PropertyValueFactory<>("especialidad")
        );

        colTelefono.setCellValueFactory(
                new PropertyValueFactory<>("telefono")
        );

        colTarifa.setCellValueFactory(
                new PropertyValueFactory<>("tarifaSesion")
        );

        cargarEjemplos();
        actualizarTabla();
    }


    private void cargarEjemplos() {

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


    private void actualizarTabla() {

        tablaEntrenadores.setItems(
                FXCollections.observableArrayList(listaEntrenadores)
        );
    }


    @FXML
    private void crearEntrenador() {

        String identificacion = txtIdentificacion.getText();
        String nombre = txtNombre.getText();
        String especialidad = txtEspecialidad.getText();
        String telefono = txtTelefono.getText();

        double tarifa = Double.parseDouble(txtTarifa.getText());

        Entrenador entrenador = new Entrenador(
                identificacion,
                nombre,
                especialidad,
                telefono,
                tarifa
        );

        listaEntrenadores.add(entrenador);

        actualizarTabla();
        limpiar();
    }


    @FXML
    private void cargarEntrenador() {

        Entrenador seleccionado =
                tablaEntrenadores.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            txtIdentificacion.setText(
                    seleccionado.getIdentificacion()
            );

            txtNombre.setText(
                    seleccionado.getNombre()
            );

            txtEspecialidad.setText(
                    seleccionado.getEspecialidad()
            );

            txtTelefono.setText(
                    seleccionado.getTelefono()
            );

            txtTarifa.setText(
                    String.valueOf(seleccionado.getTarifaSesion())
            );
        }
    }


    @FXML
    private void eliminarEntrenador() {

        Entrenador seleccionado =
                tablaEntrenadores.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            listaEntrenadores.remove(seleccionado);

            actualizarTabla();
            limpiar();
        }
    }


    @FXML
    private void limpiar() {

        txtIdentificacion.clear();
        txtNombre.clear();
        txtEspecialidad.clear();
        txtTelefono.clear();
        txtTarifa.clear();
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
                    (Stage) tablaEntrenadores.getScene().getWindow();

            stage.setScene(new Scene(vista));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}