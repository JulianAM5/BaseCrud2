package uabc.julian.baseCrud.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uabc.julian.baseCrud.Controlador;

/**
 * PersonaSmallView
 */
public class PersonaSmallView extends HBox {
    
    private Controlador controlador;

    public PersonaSmallView(Controlador controlador, int id, String nombre) {
        this.controlador = controlador;
        
        setPersonaSmallView(id, nombre);
    }

    private void setPersonaSmallView(int id, String nombre) {
        

        Label personaLabel = new Label(nombre);

        Button editarButton = new Button("Editar");
        Button borrarButton = new Button("\u274C");

        editarButton.setOnAction(e -> {
            controlador.abrirPanel(new PersonaFullView(controlador, id, nombre));
        });

        borrarButton.setOnAction(e -> {
            if (controlador.solicitarEliminarPersona(id)) {
                controlador.InvokeOnDataBaseChanged("", -1);
            }
        });

        personaLabel.getStyleClass().add("custom-label-smallView");
        editarButton.getStyleClass().add("custom-edit-smallButton");
        borrarButton.getStyleClass().add("custom-delete-smallButton");

        getStyleClass().add("custom-smallView");
        getChildren().addAll(personaLabel, editarButton, borrarButton);
    }
}
