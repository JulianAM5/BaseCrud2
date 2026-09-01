package uabc.julian.baseCrud.view.FullViews;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Eventos.Listener;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.controladores.Lector;
import uabc.julian.baseCrud.controladores.NavegacionUI;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.view.Creador;
import uabc.julian.baseCrud.view.SmallViews.PersonaSmallView;
/**
 * FullViewDireccion
 */
public class FullViewDireccion extends VBox implements Listener {

    private Direccion direccion;
    private Lector lector;
    private Escritor escritor;
    private Creador creador;
    private NavegacionUI navegacion;

    public FullViewDireccion(Direccion direccion, Lector lector, Escritor escritor, Creador creador, NavegacionUI navegacion) {
        this.creador = creador;
        this.lector = lector;
        this.escritor = escritor;
        this.direccion = direccion;
        this.navegacion = navegacion;

        setLayout();
    }

    private void setLayout() {
        getChildren().clear();

        HBox top = new HBox();

        TextField nombreLabel = new TextField(direccion.getDireccion());
        Button editarNombre = new Button("Editar");

        Button cerrarButton = new Button("\u274C");

        top.getChildren().addAll(nombreLabel, cerrarButton);

        Label personasLabel = new Label("Personas");
        ScrollPane personasSPane = new ScrollPane(); 
        Button agregarPersonaButton = new Button("Agregar");

        cerrarButton.setOnAction(e -> { navegacion.cerrarPanel(this); });
        editarNombre.setOnAction(e -> {
            if (nombreLabel.getText().isBlank()) { return; }

            direccion.setDireccion(nombreLabel.getText());
            escritor.modificarDireccion(direccion);
        });

        setPersonas(personasSPane);

        nombreLabel.getStyleClass().add("custom-title-fullView");
        editarNombre.getStyleClass().add("custom-edit-smallButton");
        personasLabel.getStyleClass().add("custom-title");
        agregarPersonaButton.getStyleClass().add("custom-add-button");
        personasSPane.getStyleClass().add("custom-full-scrollPane");
        cerrarButton.getStyleClass().add("custom-delete-smallButton");
        getStyleClass().add("vbox");

        personasLabel.setPadding(new Insets(40, 0, 0, 0));

        getChildren().addAll(top, editarNombre, personasLabel, personasSPane, agregarPersonaButton);

        setPadding(new Insets(10));
    }

    private void setPersonas(ScrollPane pane) {
        ArrayList<Persona> personas = lector.leerPersonasAsignadasADireccion(direccion.getId());
        VBox holder = new VBox();

        for (Persona persona : personas) {
            holder.getChildren().add(creador.crearPersonaSmallView(persona, false));
        }

        holder.setSpacing(3);
        pane.setFitToWidth(true);
        pane.setContent(holder);
    }

	@Override
	public void actualizar() {
        direccion = lector.leerDireccion(direccion.getId());
        setLayout();
	}
}
