package com.example.gimnasio.viewController;

import com.example.gimnasio.model.Beneficio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeneficioViewController {

    @FXML
    private TableView<Beneficio> tablaBeneficios;

    @FXML
    private TableColumn<Beneficio, String> colNombre;

    @FXML
    private TableColumn<Beneficio, String> colDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtDescripcion;

    private List<Beneficio> listaBeneficios = new ArrayList<>();


    @FXML
    public void initialize() {

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        colDescripcion.setCellValueFactory(
                new PropertyValueFactory<>("descripcion")
        );

        cargarEjemplos();
        actualizarTabla();
    }


    private void cargarEjemplos() {

        listaBeneficios.add(
                new Beneficio(
                        "Acceso a zona de pesas",
                        "Acceso completo a la zona de musculación."
                )
        );

        listaBeneficios.add(
                new Beneficio(
                        "Clases grupales",
                        "Acceso a clases dirigidas por instructores."
                )
        );

        listaBeneficios.add(
                new Beneficio(
                        "Entrenador personalizado",
                        "Acompañamiento individual con un entrenador."
                )
        );

        listaBeneficios.add(
                new Beneficio(
                        "Acceso a cardio",
                        "Acceso a máquinas de entrenamiento cardiovascular."
                )
        );
    }


    private void actualizarTabla() {

        tablaBeneficios.setItems(
                FXCollections.observableArrayList(listaBeneficios)
        );
    }


    @FXML
    private void crearBeneficio() {

        Beneficio beneficio = new Beneficio(
                txtNombre.getText(),
                txtDescripcion.getText()
        );

        listaBeneficios.add(beneficio);

        actualizarTabla();

        limpiar();
    }


    @FXML
    private void eliminarBeneficio() {

        Beneficio seleccionado =
                tablaBeneficios.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            listaBeneficios.remove(seleccionado);

            actualizarTabla();
        }
    }


    @FXML
    private void cargarBeneficio() {

        Beneficio seleccionado =
                tablaBeneficios.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            txtNombre.setText(
                    seleccionado.getNombre()
            );

            txtDescripcion.setText(
                    seleccionado.getDescripcion()
            );
        }
    }


    @FXML
    private void limpiar() {

        txtNombre.clear();
        txtDescripcion.clear();
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
    private void abrirPlanes() {
        cambiarVista("PlanEntrenamiento.fxml");
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
                    (Stage) tablaBeneficios.getScene().getWindow();

            stage.setScene(
                    new Scene(vista)
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}