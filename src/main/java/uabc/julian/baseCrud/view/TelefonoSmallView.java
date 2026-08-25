package uabc.julian.baseCrud.view;

import javafx.geometry.Pos;
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

        setMaxWidth(Double.MAX_VALUE);
        setTelefonoSmallView(personaId, telefono);
    }

    private void setTelefonoSmallView(int personaId, String telefono) {
        Label telefonoLabel = new Label(telefono);

        Button editarButton = new Button("Editar");
        Button borrarButton = new Button("\u274C");

        editarButton.setOnAction(e -> {

        });

        borrarButton.setOnAction(e -> {

        });
 
        telefonoLabel.getStyleClass().add("custom-label-smallView");
        editarButton.getStyleClass().add("custom-edit-smallButton");
        borrarButton.getStyleClass().add("custom-delete-smallButton");

        getChildren().addAll(telefonoLabel, editarButton, borrarButton);

        getStyleClass().add("custom-smallView");
    }
}
