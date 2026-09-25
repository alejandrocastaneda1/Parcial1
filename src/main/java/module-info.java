module com.example.gimnasio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gimnasio to javafx.fxml;
    exports com.example.gimnasio;
}