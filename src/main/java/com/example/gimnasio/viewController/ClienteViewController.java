package com.example.gimnasio.viewController;

import com.example.gimnasio.model.Cliente;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteViewController {

    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colCedula;
    @FXML
    private TableColumn<Cliente, String> colTelefono;
    @FXML
    private TableColumn<Cliente, String> colCorreo;
    @FXML
    private TableColumn<Cliente, Integer> colEdad;
    @FXML
    private TableColumn<Cliente, LocalDate> colFecha;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtEdad;
    @FXML
    private DatePicker dateFecha;

    private List<Cliente> listaClientes = new ArrayList<>();

    @FXML
    public void initialize() {

        colNombre.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("nombre"));

        colCedula.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("cedula"));

        colTelefono.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("telefono"));

        colCorreo.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("correo"));

        colEdad.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("edad"));

        colFecha.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("fechaRegistro"));

        cargarEjemplos();
        actualizarTabla();
    }

    private void cargarEjemplos() {

        listaClientes.add(new Cliente(
                "Alejandro Castañeda",
                "1001001001",
                "3001234567",
                "alejandro@gmail.com",
                20,
                LocalDate.now()
        ));

        listaClientes.add(new Cliente(
                "Laura Martínez",
                "1002002002",
                "3019876543",
                "laura@gmail.com",
                24,
                LocalDate.now()
        ));

        listaClientes.add(new Cliente(
                "Carlos Rodríguez",
                "1003003003",
                "3104567890",
                "carlos@gmail.com",
                29,
                LocalDate.now()
        ));
    }

    private void actualizarTabla() {
        tablaClientes.setItems(
                FXCollections.observableArrayList(listaClientes)
        );
    }

    @FXML
    private void crearCliente() {

        Cliente cliente = new Cliente(
                txtNombre.getText(),
                txtCedula.getText(),
                txtTelefono.getText(),
                txtCorreo.getText(),
                Integer.parseInt(txtEdad.getText()),
                dateFecha.getValue()
        );

        listaClientes.add(cliente);

        actualizarTabla();
        limpiar();
    }

    @FXML
    private void eliminarCliente() {

        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            listaClientes.remove(seleccionado);
            actualizarTabla();
        }
    }

    @FXML
    private void cargarCliente() {

        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            txtNombre.setText(seleccionado.getNombre());
            txtCedula.setText(seleccionado.getCedula());
            txtTelefono.setText(seleccionado.getTelefono());
            txtCorreo.setText(seleccionado.getCorreo());
            txtEdad.setText(String.valueOf(seleccionado.getEdad()));
            dateFecha.setValue(seleccionado.getFechaRegistro());
        }
    }

    @FXML
    private void limpiar() {

        txtNombre.clear();
        txtCedula.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtEdad.clear();
        dateFecha.setValue(null);
    }

    // =========================
    // NAVEGACIÓN
    // =========================

    @FXML
    private void abrirInicio() {
        cambiarVista("Inicio.fxml");
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

            Stage stage = (Stage) tablaClientes.getScene().getWindow();

            stage.setScene(new Scene(vista));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}