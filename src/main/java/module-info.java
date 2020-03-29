module Dataamatorene {
    requires javafx.controls;
    requires javafx.fxml;

    opens Dataamatorene to javafx.fxml;
    opens Dataamatorene.Controllers to javafx.fxml;
    opens Dataamatorene.Datakomponenter to javafx.base;
    opens Dataamatorene.Brukere to javafx.base;

    exports Dataamatorene;
}