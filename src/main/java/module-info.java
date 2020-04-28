module Dataamatorene {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires annotations;
    requires java.desktop;
    requires com.jfoenix;

    opens Dataamatorene to javafx.fxml, java.desktop;
    opens Dataamatorene.Controllers to javafx.fxml;
    opens Dataamatorene.Datakomponenter to javafx.base;
    opens Dataamatorene.Brukere to javafx.base;
    opens Dataamatorene.Bestilling to javafx.base;

    exports Dataamatorene;
}