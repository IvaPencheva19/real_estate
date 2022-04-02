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

    opens bg.tuvarna.sit.real_estate_proj to javafx.fxml;
    exports bg.tuvarna.sit.real_estate_proj;
    exports bg.tuvarna.sit.real_estate_proj.application;
    opens bg.tuvarna.sit.real_estate_proj.application to javafx.fxml;
}