module com.example.networkprogaming {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.networkprogaming to javafx.fxml;
    exports com.example.networkprogaming;
}