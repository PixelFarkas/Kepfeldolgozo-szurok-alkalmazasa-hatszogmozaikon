module com.example.szakdolgozat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens com.example.szakdolgozat to javafx.fxml;
    exports com.example.szakdolgozat;
    exports com.example.szakdolgozat.Masks;
    opens com.example.szakdolgozat.Masks to javafx.fxml;
    exports com.example.szakdolgozat.JFrame;
    opens com.example.szakdolgozat.JFrame to javafx.fxml;
}