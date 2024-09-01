module com.example.kartgp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.opencsv;
    requires org.apache.commons.lang3;

    exports com.example.kartgp;
    opens com.example.kartgp to javafx.fxml;
    exports com.example.kartgp.controller;
    opens com.example.kartgp.controller to javafx.fxml;
    exports com.example.kartgp.bean;
    opens com.example.kartgp.bean to javafx.fxml;
}