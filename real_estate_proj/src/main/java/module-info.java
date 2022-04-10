module bg.tuvarna.sit.real_estate_proj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.sql;

   /* opens bg.tuvarna.sit.real_estate_proj to javafx.fxml;
    exports bg.tuvarna.sit.real_estate_proj;*/
    exports bg.tuvarna.sit.real_estate_proj.application;
    opens bg.tuvarna.sit.real_estate_proj.application to javafx.fxml;

    opens bg.tuvarna.sit.real_estate_proj.data.entities to org.hibernate.orm.core;
    exports bg.tuvarna.sit.real_estate_proj.data.entities;
    exports bg.tuvarna.sit.real_estate_proj.presentation.controllers;
    opens bg.tuvarna.sit.real_estate_proj.presentation.controllers to javafx.fxml;

}