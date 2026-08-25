package uabc.julian.baseCrud.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import uabc.julian.baseCrud.Controlador;

/**
 * DireccionSmallView
 */
public class DireccionSmallView extends HBox {

    private Controlador controlador;

    public DireccionSmallView(Controlador controlador, int id, String direccion) {
        this.controlador = controlador;

        setDireccionSmallView(id, direccion);
    }

    private void setDireccionSmallView(int id, String direccion) {
        Label direccionLabel = new Label(direccion);

        Button editarButton = new Button("Editar");
        Button borrarButton = new Button("\u274C");

        editarButton.setOnAction(e -> {

        });

        borrarButton.setOnAction(e -> {

        });

        direccionLabel.getStyleClass().add("custom-label-smallView");
        editarButton.getStyleClass().add("custom-edit-smallButton");
        borrarButton.getStyleClass().add("custom-delete-smallButton");

        getChildren().addAll(direccionLabel, editarButton, borrarButton);

        getStyleClass().add("custom-smallView");

    }
}
