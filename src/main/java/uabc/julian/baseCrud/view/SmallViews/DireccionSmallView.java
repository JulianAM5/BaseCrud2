package uabc.julian.baseCrud.view.SmallViews;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.view.Creador;

/**
 * PersonaSmallView
 */
public class DireccionSmallView extends HBox {

    private Direccion direccion;
    private Creador creador;
    private Escritor escritor;
    private boolean aceptarModificaciones;

    public DireccionSmallView(Direccion direccion, Creador creador, Escritor escritor, boolean aceptarModificaciones) {
        this.direccion = direccion;
        this.creador = creador;
        this.escritor = escritor;
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
        creador.crearFullViewDireccionesPanel(direccion);
    }

    private void onEliminar() {
        escritor.eliminarDireccion(direccion.getId());
    }

    public void setAceptarModificaciones(boolean aceptarModificaciones) {
        this.aceptarModificaciones = aceptarModificaciones;
        setVista();
    }   
}
