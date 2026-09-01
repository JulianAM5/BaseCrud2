package uabc.julian.baseCrud.view.agregarViews;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.controladores.NavegacionUI;
import uabc.julian.baseCrud.data.Direccion;

/**
 * AgregarDireccionView
 */
public class AgregarDireccionView extends VBox {

    private Escritor escritor;
    private NavegacionUI navegacion;

    public AgregarDireccionView(Escritor escritor, NavegacionUI navegacion) {
        this.escritor = escritor;
        this.navegacion = navegacion;
        setLayout();
    }

    private void setLayout() {
        Label direccion = new Label("Direccion");
        TextField fieldDireccion = new TextField();

        HBox botones = new HBox();
        Button confirmar = new Button("Confirmar");
        Button cancelar = new Button("Cancelar");
        botones.setSpacing(10);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(confirmar, cancelar);

        confirmar.setOnAction(e -> {
            if (fieldDireccion.getText().isBlank()) { return; }

            if (escritor.agregarDireccion(new Direccion(-1, fieldDireccion.getText()))) {
                navegacion.cerrarPanel(this);
            } else {
                fieldDireccion.clear();
            }
        });

        cancelar.setOnAction(e -> {
            navegacion.cerrarPanel(this);
        });

        fieldDireccion.getStyleClass().add("custom-field");
        getStyleClass().add("custom-edit-window");
        confirmar.getStyleClass().add("custom-confirm-button");
        cancelar.getStyleClass().add("custom-cancel-button");

        getChildren().addAll(direccion, fieldDireccion, botones);
    }
}
