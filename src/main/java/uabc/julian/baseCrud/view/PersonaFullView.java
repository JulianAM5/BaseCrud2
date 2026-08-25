package uabc.julian.baseCrud.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Controlador;

/**
 * PersonaFullView
 */
public class PersonaFullView extends VBox {
    
    private Controlador controlador;

    public PersonaFullView(Controlador controlador, int id, String nombre) {
        this.controlador = controlador;
        setLayout(nombre);
    }

    private void setLayout(String nombre) {
        Label nombreLabel = new Label(nombre);
        Button editarNombre = new Button("Editar");

        Label telefonosLabel = new Label("Telefonos");
        ScrollPane telefonosSPane = new ScrollPane();
        Button agregarTelefonoButton = new Button("Agregar");

        Label direccionesLabel = new Label("Direcciones");
        ScrollPane direccionesSPane = new ScrollPane(); 
        Button agregarDireccionButton = new Button("Agregar");
        
        agregarTelefonoButton.getStyleClass().add("custom-add-button");
        agregarDireccionButton.getStyleClass().add("custom-add-button");

        direccionesSPane.getStyleClass().add("custom-mini-scrollPane");
        telefonosSPane.getStyleClass().add("custom-mini-scrollPane");

        getChildren().addAll(nombreLabel, editarNombre, telefonosLabel, telefonosSPane, agregarTelefonoButton, direccionesLabel, direccionesSPane, agregarDireccionButton);

        setPadding(new Insets(10));
    }
}
