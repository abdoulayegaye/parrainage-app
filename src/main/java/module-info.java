module sn.dev.parrainageapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;


    opens sn.dev.parrainageapp to javafx.fxml;
    exports sn.dev.parrainageapp;
    exports sn.dev.parrainageapp.controllers;
    opens sn.dev.parrainageapp.controllers to javafx.fxml;
}