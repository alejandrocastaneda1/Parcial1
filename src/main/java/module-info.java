module com.example.gimnasio {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    opens com.example.gimnasio to javafx.fxml, org.junit.platform.commons;

    exports com.example.gimnasio;
    exports com.example.gimnasio.model;
}