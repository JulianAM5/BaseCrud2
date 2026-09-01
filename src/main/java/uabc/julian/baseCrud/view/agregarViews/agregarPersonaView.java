package uabc.julian.baseCrud.view.agregarViews;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.controladores.Lector;
import uabc.julian.baseCrud.controladores.NavegacionUI;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;
import uabc.julian.baseCrud.view.ListViews.DireccionesView;

/**
 * agregarPersonaView
 */
public class agregarPersonaView extends VBox {
    private Escritor escritor;
    private Persona persona;
    private NavegacionUI navegacion;

    public agregarPersonaView(Escritor escritor, NavegacionUI navegacion) {
        this.escritor = escritor;
        this.navegacion = navegacion;
        persona = new Persona(-1, "", null, null);
        setLayout();
    }

    private void setLayout() {
        Label nombre = new Label("Nombre");
        TextField fieldNombre = new TextField();

        Label telefono = new Label("Telefono");
        TextField fieldTelefono = new TextField();
        Button telefonoAñadir = new Button("Añadir");

        Label direccion = new Label("Direccion");
        TextField fieldDireccion = new TextField();
        Button direccionesAñadir = new Button("Añadir");
        
        HBox botones = new HBox();
        Button confirmar = new Button("Confirmar");
        Button cancelar = new Button("Cancelar");
        botones.setSpacing(10);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(confirmar, cancelar);

        telefonoAñadir.setOnAction(e -> {
            if (fieldTelefono.getText().isBlank()) { return; }

            persona.getTelefonos().add(new Telefono(-1, -1, fieldTelefono.getText()));
            fieldTelefono.clear();
        });

        direccionesAñadir.setOnAction(e -> {
            if (fieldDireccion.getText().isBlank()) { return; }

            persona.getDirecciones().add(new Direccion(-1, fieldDireccion.getText()));
            fieldDireccion.clear();
        });

        confirmar.setOnAction(e -> {
            if (nombre.getText().isEmpty()) { return; }

            persona.setNombre(fieldNombre.getText());

            if (!escritor.agregarPersona(persona)) {
                System.out.println("NO SE PUDO AGREGAR");
            } else {
                navegacion.cerrarPanel(this);
            }
        });

        cancelar.setOnAction(e -> {
            navegacion.cerrarPanel(this);
        });

        fieldNombre.getStyleClass().add("custom-field");
        fieldTelefono.getStyleClass().add("custom-field");
        fieldDireccion.getStyleClass().add("custom-field");
        getStyleClass().add("custom-edit-window");
        confirmar.getStyleClass().add("custom-confirm-button");
        cancelar.getStyleClass().add("custom-cancel-button");

        getChildren().addAll(nombre, fieldNombre, telefono, fieldTelefono, telefonoAñadir, direccion, fieldDireccion, direccionesAñadir, botones);
    }
}
