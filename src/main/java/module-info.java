module com.example.gimnasio {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    exports com.example.gimnasio;
    exports com.example.gimnasio.model;
    exports com.example.gimnasio.view;
    exports com.example.gimnasio.viewController;

    opens com.example.gimnasio to javafx.fxml, org.junit.platform.commons;
    opens com.example.gimnasio.model to javafx.fxml;
    opens com.example.gimnasio.view to javafx.fxml;
    opens com.example.gimnasio.viewController to javafx.fxml;
}