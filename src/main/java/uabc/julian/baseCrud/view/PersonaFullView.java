package uabc.julian.baseCrud.view;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Controlador;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Telefono;

/**
 * PersonaFullView
 */
public class PersonaFullView extends VBox {
    
    private Controlador controlador;

    public PersonaFullView(Controlador controlador, int id, String nombre) {
        this.controlador = controlador;
        setLayout(nombre, id);
    }

    private void setLayout(String nombre, int id) {
        HBox top = new HBox();
        
        Label nombreLabel = new Label(nombre);
        Button editarNombre = new Button("Editar");

        Button cerrarButton = new Button("X");

        top.getChildren().addAll(nombreLabel, cerrarButton);

        Label telefonosLabel = new Label("Telefonos");
        ScrollPane telefonosSPane = new ScrollPane();
        Button agregarTelefonoButton = new Button("Agregar");

        Label direccionesLabel = new Label("Direcciones");
        ScrollPane direccionesSPane = new ScrollPane(); 
        Button agregarDireccionButton = new Button("Agregar");
        
        setTelefonos(telefonosSPane, id);
        setDirecciones(direccionesSPane, id);


        cerrarButton.setOnAction(e -> { controlador.cerrarPanel(this); });


        nombreLabel.getStyleClass().add("custom-title");
        editarNombre.getStyleClass().add("custom-edit-smallButton");
        telefonosLabel.getStyleClass().add("custom-title");
        direccionesLabel.getStyleClass().add("custom-title");
        agregarTelefonoButton.getStyleClass().add("custom-add-button");
        agregarDireccionButton.getStyleClass().add("custom-add-button");
        direccionesSPane.getStyleClass().add("custom-mini-scrollPane");
        telefonosSPane.getStyleClass().add("custom-mini-scrollPane");
        cerrarButton.getStyleClass().add("custom-cerrar-button");

        telefonosLabel.setPadding(new Insets(40, 0, 0, 0));
        direccionesLabel.setPadding(new Insets(40, 0, 0, 0));

        getChildren().addAll(top, editarNombre, telefonosLabel, telefonosSPane, agregarTelefonoButton, direccionesLabel, direccionesSPane, agregarDireccionButton);

        setPadding(new Insets(10));
    }

    private void setTelefonos(ScrollPane pane, int personaId) {
        ArrayList<Telefono> telefonos = controlador.solicitarTelefonosDePersona(personaId);
        VBox holder = new VBox();

        for (Telefono telefono : telefonos) {
            holder.getChildren().add(new TelefonoSmallView(controlador, personaId, telefono.getNumeroTelefonico()));
        }

        holder.setSpacing(3);
        pane.setFitToWidth(true);
        pane.setContent(holder);
    }

    private void setDirecciones(ScrollPane pane, int personaId) {
        ArrayList<Direccion> direcciones = controlador.solicitarDireccionesDePersona(personaId);

        VBox holder = new VBox();

        for (Direccion direccion : direcciones) {
            holder.getChildren().add(new DireccionSmallView(controlador, personaId, direccion.getDireccion()));
        }

        holder.setSpacing(3);
        pane.setFitToWidth(true);
        pane.setContent(holder);
    }
}
