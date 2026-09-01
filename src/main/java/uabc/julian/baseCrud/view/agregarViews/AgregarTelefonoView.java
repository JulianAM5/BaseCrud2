package uabc.julian.baseCrud.view.agregarViews;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.controladores.NavegacionUI;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * AgregarTelefonoView
 */
public class AgregarTelefonoView extends VBox {

    private Escritor escritor;
    private NavegacionUI navegacion;
    private Persona persona;

    public AgregarTelefonoView(Escritor escritor, NavegacionUI navegacion, Persona persona) {
        this.escritor = escritor;
        this.navegacion = navegacion;
        this.persona = persona;
        setLayout();
    }

    private void setLayout() {
        Label telefono = new Label("Telefono");
        TextField fieldTelefono = new TextField();

        HBox botones = new HBox();
        Button confirmar = new Button("Confirmar");
        Button cancelar = new Button("Cancelar");
        botones.setSpacing(10);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(confirmar, cancelar);

        confirmar.setOnAction(e -> {
            if (fieldTelefono.getText().isBlank()) { return; }

            if (escritor.agregarTelefono(new Telefono(-1, persona.getId(), fieldTelefono.getText()))) {
                navegacion.cerrarPanel(this);
            } else {
                fieldTelefono.clear();
            }
        });

        cancelar.setOnAction(e -> {
            navegacion.cerrarPanel(this);
        });

        fieldTelefono.getStyleClass().add("custom-field");
        getStyleClass().add("custom-edit-window");
        confirmar.getStyleClass().add("custom-confirm-button");
        cancelar.getStyleClass().add("custom-cancel-button");

        getChildren().addAll(telefono, fieldTelefono, botones);
    }
}
