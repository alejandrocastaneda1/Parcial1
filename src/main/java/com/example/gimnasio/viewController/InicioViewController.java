package com.example.gimnasio.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioViewController {

    @FXML
    private Label lblClientes;

    @FXML
    private Label lblEntrenadores;

    @FXML
    private Label lblPlanes;

    @FXML
    private Label lblInscripciones;

    @FXML
    public void initialize() {
        actualizarEstadisticas();
    }

    private void actualizarEstadisticas() {

        lblClientes.setText("3");
        lblEntrenadores.setText("0");
        lblPlanes.setText("3");
        lblInscripciones.setText("0");
    }

    @FXML
    private void mostrarClientes() {
        abrirVentana("Cliente.fxml");
    }

    @FXML
    private void mostrarPlanes() {
        abrirVentana("PlanEntrenamiento.fxml");
    }

    @FXML
    private void mostrarServicios() {
        abrirVentana("Beneficio.fxml");
    }

    @FXML
    private void mostrarEntrenadores() {
        abrirVentana("Entrenador.fxml");
    }

    @FXML
    private void mostrarInscripciones() {
        abrirVentana("Inscripcion.fxml");
    }

    @FXML
    private void mostrarReportes() {
        System.out.println("Módulo de reportes próximamente.");
    }

    private void abrirVentana(String archivo) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/gimnasio/" + archivo
                    )
            );

            Parent vista = loader.load();

            Stage stage = new Stage();
            stage.setTitle("SmartGym");

            Scene scene = new Scene(vista);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}