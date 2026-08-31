package uabc.julian.baseCrud.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import uabc.julian.baseCrud.Controlador;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;

/**
 * DireccionFullView
 */
public class DireccionFullView extends VBox {

    private Controlador controlador;
    private int id;
    private String direccion;
    private Label direccionLabel;

    public DireccionFullView(Controlador controlador, int id, String direccion) {
        this.controlador = controlador;
        this.id = id;
        this.direccion = direccion;
        setLayout();
    }

    private void setLayout() {
        getChildren().clear();

        HBox top = new HBox();
        
        direccionLabel = new Label(direccion);
        Button editarDireccion = new Button("Editar");

        Button cerrarButton = new Button("\u274C");

        top.getChildren().addAll(direccionLabel, cerrarButton);

        Label personasLabel = new Label("Personas Asociadas");
        ScrollPane personasSPane = new ScrollPane();
        Button agregarPersonaButton = new Button("Agregar");

        setPersonas(personasSPane, id);

        editarDireccion.setOnAction(e -> { controlador.abrirPanel(new EditarView(controlador, id, EditarView.Tipo.DIRECCION));});
        cerrarButton.setOnAction(e -> { controlador.cerrarPanel(this); });
        agregarPersonaButton.setOnAction(e -> {
            VBox vbox = new VBox();
            Label label = new Label("Selecciona una persona");

            ChoiceBox<Persona> personas = new ChoiceBox<>();
            ObservableList<Persona> personasList = FXCollections.observableArrayList(controlador.solicitarPersonas());
            personas.getItems().addAll(personasList);
            personas.setConverter(new StringConverter<Persona>() {
                @Override
                public String toString(Persona persona) {
                    return persona != null ? persona.getNombre() : "";
                }

                @Override
                public Persona fromString(String string) {
                    return null;
                }
            });

            Button confirmarButton = new Button("Confirmar");
            Button cancelarButton = new Button("Cancelar");

            cancelarButton.setOnAction(i -> { controlador.cerrarPanel(vbox); });
            confirmarButton.setOnAction(i -> {
                if (personas.getValue() == null) {
                    return;
                }

                if (controlador.solicitarAsociacionPersonaDireccion(personas.getValue().getId(), id)) {
                    controlador.InvokeOnDataBaseChanged("", -1);
                    controlador.cerrarPanel(vbox);
                }
            });

            HBox botones = new HBox();
            botones.getChildren().addAll(confirmarButton, cancelarButton);
            botones.setSpacing(10);
            botones.setAlignment(Pos.CENTER);

            vbox.setSpacing(10);
            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(label, personas, botones);

            vbox.getStyleClass().add("custom-edit-window");
            confirmarButton.getStyleClass().add("custom-confirm-button");
            cancelarButton.getStyleClass().add("custom-cancel-button");
            label.getStyleClass().add("custom-text");

            controlador.abrirPanel(vbox);
        });

        direccionLabel.getStyleClass().add("custom-title");
        editarDireccion.getStyleClass().add("custom-edit-smallButton");
        personasLabel.getStyleClass().add("custom-title");
        agregarPersonaButton.getStyleClass().add("custom-add-button");
        personasSPane.getStyleClass().add("custom-full-scrollPane");
        cerrarButton.getStyleClass().add("custom-delete-smallButton");
        getStyleClass().add("vbox");

        personasLabel.setPadding(new Insets(40, 0, 0, 0));
        setPadding(new Insets(10));

        getChildren().addAll(top, editarDireccion, personasLabel, personasSPane, agregarPersonaButton);
    }

    private void setPersonas(ScrollPane pane, int direccionId) {
        ArrayList<Persona> personas = controlador.solicitarPersonasAsociadasADireccion(direccionId);
        VBox holder = new VBox();

        for (Persona persona : personas) {
            PersonaSmallView personaSmallView = new PersonaSmallView(controlador, persona.getId(), persona.getNombre());
            personaSmallView.desactivarEdicion(true);
            holder.getChildren().add(personaSmallView);
        }

        holder.setSpacing(3);
        pane.setFitToWidth(true);
        pane.setContent(holder);
    }
}
