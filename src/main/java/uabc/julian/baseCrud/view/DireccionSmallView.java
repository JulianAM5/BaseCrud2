package uabc.julian.baseCrud.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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

        Button editarButton = new Button();
        Button borrarButton = new Button();

        editarButton.setOnAction(e -> {

        });

        borrarButton.setOnAction(e -> {

        });

        getChildren().addAll(direccionLabel, editarButton, borrarButton);
    }
}
