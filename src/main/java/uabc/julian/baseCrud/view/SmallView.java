package uabc.julian.baseCrud.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.controladores.Lector;

/**
 * SmallView
 */
public class SmallView extends HBox {
    private Visualizable visualizable;

    public SmallView(Visualizable visualizable, Escritor escritor) {
        this.visualizable = visualizable;
        setVista();
    }

    private void setVista() {
        getChildren().clear();

        Label dato = new Label(visualizable.getTextoVisualizable());

        Button botonModificar = new Button();
        Button botonEliminar = new Button(); 

        dato.getStyleClass().add("custom-label-smallView");
        botonModificar.getStyleClass().add("custom-edit-smallButton");
        botonEliminar.getStyleClass().add("custom-delete-smallButton");

        getStyleClass().add("custom-smallView");
        getChildren().addAll(dato, botonModificar, botonEliminar);
    }

    private void onModificar() {

    }

    private void onEliminar() {

    }

    public void setVisualizable(Visualizable visualizable) {
        this.visualizable = visualizable;
    }
}
