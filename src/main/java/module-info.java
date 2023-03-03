module com.example.proje2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.proje2 to javafx.fxml;
    exports com.example.proje2;
}