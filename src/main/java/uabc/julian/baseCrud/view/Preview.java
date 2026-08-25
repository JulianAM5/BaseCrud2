package uabc.julian.baseCrud.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Controlador;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;

/**
 * Preview
 */
public class Preview extends VBox {

    private Controlador controlador;
    private ScrollPane scrollPane;

    public Preview(Controlador controlador) {
        this.controlador = controlador;
        setLayout();
    }

    private void setLayout() {
        Label tituloLabel = new Label("REGISTRO");

        scrollPane = new ScrollPane();

        Button agregarButton = new Button("Agregar");

        tituloLabel.getStyleClass().add("custom-title");
        scrollPane.getStyleClass().add("custom-full-scrollPane");
        agregarButton.getStyleClass().add("custom-add-button");

        setPadding(new Insets(10));

        setAlignment(Pos.CENTER);
        getChildren().addAll(tituloLabel, scrollPane, agregarButton);
    }

    public void cargarPersonas() {
        ArrayList<Persona> personas = controlador.solicitarPersonas();
        VBox holder = new VBox();

        for (Persona persona : personas) {
            holder.getChildren().add(new PersonaSmallView(controlador, persona.getId(), persona.getNombre()));
        }

        holder.setSpacing(3);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(holder);
    }

    public void cargarDirecciones() {
        ArrayList<Direccion> direcciones = controlador.solicitarDirecciones();
        VBox holder = new VBox();

        for (Direccion direccion : direcciones) {
            holder.getChildren().add(new DireccionSmallView(controlador, direccion.getId(), direccion.getDireccion()));
        }

        holder.setSpacing(3);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(holder);
    }
}
