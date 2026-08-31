package uabc.julian.baseCrud.view.SmallViews;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uabc.julian.baseCrud.data.Telefono;
import uabc.julian.baseCrud.view.Creador;

/**
 * PersonaSmallView
 */
public class TelefonoSmallView extends HBox {

    private Telefono telefono;
    private Creador creador;
    private boolean aceptarModificaciones;

    public TelefonoSmallView(Telefono telefono, Creador creador, boolean aceptarModificaciones) {
        this.telefono = telefono;
        this.creador = creador;
        this.aceptarModificaciones = aceptarModificaciones;
        setVista();
    }

    private void setVista() {
        getChildren().clear();

        Label dato = new Label(telefono.getNumeroTelefonico());

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
