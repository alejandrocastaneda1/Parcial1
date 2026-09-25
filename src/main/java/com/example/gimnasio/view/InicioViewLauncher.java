package com.example.gimnasio.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class    InicioViewLauncher {
    public static void main(String[] args) {
        Application.launch(InicioViewLoader.class, args);
    }

    public static class InicioViewLoader extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            URL formXml = getClass().getResource("/com/example/gimnasio/Inicio.fxml");
            Parent root = new FXMLLoader(formXml).load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("InicioViewLoader");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
}
