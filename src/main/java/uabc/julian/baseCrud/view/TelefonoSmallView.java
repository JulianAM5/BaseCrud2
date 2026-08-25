package uabc.julian.baseCrud.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uabc.julian.baseCrud.Controlador;

/**
 * TelefonoSmallView
 */
public class TelefonoSmallView extends HBox {

    private Controlador controlador;

    public TelefonoSmallView(Controlador controlador, int personaId, String telefono) {
        this.controlador = controlador;

        setTelefonoSmallView(personaId, telefono);
    }

    private void setTelefonoSmallView(int personaId, String telefono) {
        Label telefonoLabel = new Label(telefono);

        Button editarButton = new Button();
        Button borrarButton = new Button();

        editarButton.setOnAction(e -> {

        });

        borrarButton.setOnAction(e -> {

        });

        getChildren().addAll(telefonoLabel, editarButton, borrarButton);
    }
}
