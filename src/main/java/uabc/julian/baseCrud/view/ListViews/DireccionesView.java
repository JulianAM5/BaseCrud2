package uabc.julian.baseCrud.view.ListViews;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Eventos.Listener;
import uabc.julian.baseCrud.controladores.Lector;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.view.Creador;

/**
 * DireccionesView
 */
public class DireccionesView extends VBox implements Listener {
    private Lector lector;
    private Creador creador;

    public DireccionesView(Lector lector, Creador creador) {
        this.lector = lector;
        this.creador = creador;
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

        cargarDirecciones(scrollPane, botonAgregar);
        setPadding(new Insets(10));

        setAlignment(Pos.CENTER);
        getChildren().addAll(tituloLabel, scrollPane, botonAgregar);
    }

    private void cargarDirecciones(ScrollPane scrollPane, Button botonAgregar) {
        ArrayList<Direccion> direcciones = new ArrayList<>(lector.leerDirecciones());
        VBox holder = new VBox();

        botonAgregar.setOnAction(e -> {
            creador.crearAgregarDireccionesPanel();
        });

        for (Direccion direccion : direcciones) {
            holder.getChildren().add(creador.crearDireccionSmallView(direccion, true));
        }

        holder.setSpacing(3);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(holder);
    }

	@Override
	public void actualizar() {
        setLayout();
	}
}
