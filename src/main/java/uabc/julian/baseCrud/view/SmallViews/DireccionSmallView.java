package uabc.julian.baseCrud.view.SmallViews;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uabc.julian.baseCrud.data.Direccion;

/**
 * PersonaSmallView
 */
public class DireccionSmallView extends HBox {

    private Direccion direccion;
    private boolean aceptarModificaciones;

    public DireccionSmallView(Direccion direccion, boolean aceptarModificaciones) {
        this.direccion = direccion;
        this.aceptarModificaciones = aceptarModificaciones;
        setVista();
    }

    private void setVista() {
        getChildren().clear();

        Label dato = new Label(direccion.getDireccion());

        Button botonModificar = new Button();
        Button botonEliminar = new Button(); 
        
        botonModificar.setDisable(!aceptarModificaciones);

        botonModificar.setOnAction(e -> onModificar());
        botonEliminar.setOnAction(e -> onEliminar());

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

    public void setAceptarModificaciones(boolean aceptarModificaciones) {
        this.aceptarModificaciones = aceptarModificaciones;
        setVista();
    }   
}
