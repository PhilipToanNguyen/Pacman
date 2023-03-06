module com.example.oblig {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.oblig to javafx.fxml;
    exports com.example.oblig;
}