module ProsjektoppgaveEMNMEM {
    requires javafx.controls;
    requires javafx.fxml;
    requires annotations;

    opens Dataamatorene to javafx.fxml;
    opens Dataamatorene.Controllers to javafx.fxml;
    opens Dataamatorene.Datakomponenter to javafx.base;
    opens Dataamatorene.Brukere to javafx.base;
    opens Dataamatorene.Bestilling to javafx.base;

    exports Dataamatorene;
}