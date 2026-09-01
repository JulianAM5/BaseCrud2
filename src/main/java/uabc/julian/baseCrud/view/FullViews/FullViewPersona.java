package uabc.julian.baseCrud.view.FullViews;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.controladores.Lector;
import uabc.julian.baseCrud.controladores.NavegacionUI;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;
import uabc.julian.baseCrud.view.Creador;

/**
 * FullViewPersona
 */
public class FullViewPersona extends VBox {

    private Persona persona;
    private Lector lector;
    private Creador creador;
    private NavegacionUI navegacion;

    public FullViewPersona(Persona persona, Lector lector, Creador creador, NavegacionUI navegacion) {
        this.persona = persona;
        this.lector = lector;
        this.creador = creador;
        this.navegacion = navegacion;
        
        setLayout();
    }

    private void setLayout() {
        getChildren().clear();

        HBox top = new HBox();

        Label nombreLabel = new Label(persona.getNombre());
        Button editarNombre = new Button("Editar");

        Button cerrarButton = new Button("\u274C");

        top.getChildren().addAll(nombreLabel, cerrarButton);

        Label telefonosLabel = new Label("Telefonos");
        ScrollPane telefonosSPane = new ScrollPane();
        Button agregarTelefonoButton = new Button("Agregar");

        Label direccionesLabel = new Label("Direcciones");
        ScrollPane direccionesSPane = new ScrollPane(); 
        Button agregarDireccionButton = new Button("Agregar");

        cerrarButton.setOnAction(e -> { navegacion.cerrarPanel(this); });
        agregarTelefonoButton.setOnAction(e -> {
            creador.crearAgregarTelefonoPanel(persona);
        });

        agregarDireccionButton.setOnAction(e -> {
            creador.crearAgregarDireccionesPanel();
        });

        setTelefonos(telefonosSPane);
        setDirecciones(direccionesSPane);

        nombreLabel.getStyleClass().add("custom-title");
        editarNombre.getStyleClass().add("custom-edit-smallButton");
        telefonosLabel.getStyleClass().add("custom-title");
        direccionesLabel.getStyleClass().add("custom-title");
        agregarTelefonoButton.getStyleClass().add("custom-add-button");
        agregarDireccionButton.getStyleClass().add("custom-add-button");
        direccionesSPane.getStyleClass().add("custom-mini-scrollPane");
        telefonosSPane.getStyleClass().add("custom-mini-scrollPane");
        cerrarButton.getStyleClass().add("custom-delete-smallButton");
        getStyleClass().add("vbox");

        telefonosLabel.setPadding(new Insets(40, 0, 0, 0));
        direccionesLabel.setPadding(new Insets(40, 0, 0, 0));

        getChildren().addAll(top, editarNombre, telefonosLabel, telefonosSPane, agregarTelefonoButton, direccionesLabel, direccionesSPane, agregarDireccionButton);

        setPadding(new Insets(10));
    }

    private void setTelefonos(ScrollPane pane) {
        VBox holder = new VBox();

        for (Telefono telefono : persona.getTelefonos()) {
            holder.getChildren().add(creador.crearTelefonoSmallView(telefono, true));
        }

        holder.setSpacing(3);
        pane.setFitToWidth(true);
        pane.setContent(holder);
    }

    private void setDirecciones(ScrollPane pane) {
        VBox holder = new VBox();

        for (Direccion direccion : persona.getDirecciones()) {
            holder.getChildren().add(creador.crearDireccionSmallView(direccion, true));
        }

        holder.setSpacing(3);
        pane.setFitToWidth(true);
        pane.setContent(holder);
    }
}
