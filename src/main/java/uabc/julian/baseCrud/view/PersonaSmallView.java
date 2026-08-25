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

        Button editarButton = new Button();
        Button borrarButton = new Button();

        editarButton.setOnAction(e -> {

        });

        borrarButton.setOnAction(e -> {

        });

        personaLabel.getStyleClass().add("custom-label-smallView");
        editarButton.getStyleClass().add("custom-edit-smallButton");
        borrarButton.getStyleClass().add("custom-delete-smallButton");

        getChildren().addAll(personaLabel, editarButton, borrarButton);
    }
}
