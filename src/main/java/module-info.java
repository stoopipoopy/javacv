module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires org.bytedeco.opencv;

    opens org.example.javafx to javafx.fxml;
    exports org.example.javafx;
}