package com.example.gimnasio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("/com/example/gimnasio/Inicio.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Sistema de Gestión del Gimnasio");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}