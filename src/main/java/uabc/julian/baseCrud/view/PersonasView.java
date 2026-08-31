package uabc.julian.baseCrud.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.controladores.Lector;
import uabc.julian.baseCrud.data.Persona;

/**
 * PersonasView
 */
public class PersonasView extends VBox {

    private Lector lector;
    private Creador creador;

    public PersonasView(Lector lector) {
        this.lector = lector;
        setLayout();
    }

    private void setLayout() {
        getChildren().clear();
        Label tituloLabel = new Label("REGISTRO");

        ScrollPane scrollPane = new ScrollPane();

        Button botonAgregar = new Button("Agregar");

        tituloLabel.getStyleClass().add("custom-title");
        scrollPane.getStyleClass().add("custom-full-scrollPane");
        botonAgregar.getStyleClass().add("custom-add-button");

        cargarPersonas(scrollPane, botonAgregar);
        setPadding(new Insets(10));

        setAlignment(Pos.CENTER);
        getChildren().addAll(tituloLabel, scrollPane, botonAgregar);
    }

    private void cargarPersonas(ScrollPane scrollPane, Button botonAgregar) {
        ArrayList<Persona> personas = new ArrayList<>(lector.leerPersonas());
        VBox holder = new VBox();

        botonAgregar.setOnAction(e -> {
        });

        for (Persona persona : personas) {
            holder.getChildren().add(creador.crearPersonaSmallView(persona, true));
        }

        holder.setSpacing(3);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(holder);
    }
}
