package uabc.julian.baseCrud.view.SmallViews;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.view.Creador;

/**
 * PersonaSmallView
 */
public class PersonaSmallView extends HBox {

    private Persona persona;
    private boolean aceptarModificaciones;
    private Creador creador;
    private Escritor escritor;

    public PersonaSmallView(Persona persona, Creador creador, Escritor escritor, boolean aceptarModificaciones) {
        this.persona = persona;
        this.creador = creador;
        this.escritor = escritor;
        this.aceptarModificaciones = aceptarModificaciones;
        setVista();
    }

    private void setVista() {
        getChildren().clear();

        Label dato = new Label(persona.getNombre());

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
        creador.crearFullViewPersonaPanel(persona);
    }

    private void onEliminar() {
        escritor.eliminarPersona(persona.getId());
    }

    public void setAceptarModificaciones(boolean aceptarModificaciones) {
        this.aceptarModificaciones = aceptarModificaciones;
        setVista();
    }   
}
