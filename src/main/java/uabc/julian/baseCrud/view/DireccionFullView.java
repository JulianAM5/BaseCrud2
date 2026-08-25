package uabc.julian.baseCrud.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Controlador;
import uabc.julian.baseCrud.data.Persona;

/**
 * DireccionFullView
 */
public class DireccionFullView extends VBox {

    private Controlador controlador;

    public DireccionFullView(Controlador controlador, int id, String direccion) {
        this.controlador = controlador;
        setLayout(id, direccion);
    }

    private void setLayout(int id, String direccion) {
        HBox top = new HBox();
        
        Label direccionLabel = new Label(direccion);
        Button editarDireccion = new Button("Editar");

        Button cerrarButton = new Button("\u274C");

        top.getChildren().addAll(direccionLabel, cerrarButton);

        Label personasLabel = new Label("Personas Asociadas");
        ScrollPane personasSPane = new ScrollPane();
        Button agregarPersonaButton = new Button("Agregar");

        setPersonas(personasSPane, id);

        direccionLabel.getStyleClass().add("custom-title");
        editarDireccion.getStyleClass().add("custom-edit-smallButton");
        personasLabel.getStyleClass().add("custom-title");
        agregarPersonaButton.getStyleClass().add("custom-add-button");
        personasSPane.getStyleClass().add("custom-full-scrollPane");
        cerrarButton.getStyleClass().add("custom-delete-smallButton");

        personasLabel.setPadding(new Insets(40, 0, 0, 0));
        setPadding(new Insets(10));

        getChildren().addAll(top, editarDireccion, personasLabel, personasSPane, agregarPersonaButton);
    }

    private void setPersonas(ScrollPane pane, int direccionId) {
        ArrayList<Persona> personas = controlador.solicitarPersonasAsociadasADireccion(direccionId);
        VBox holder = new VBox();

        for (Persona persona : personas) {
            holder.getChildren().add(new PersonaSmallView(controlador, persona.getId(), persona.getNombre()));
        }

        holder.setSpacing(3);
        pane.setFitToWidth(true);
        pane.setContent(holder);
    }
}
