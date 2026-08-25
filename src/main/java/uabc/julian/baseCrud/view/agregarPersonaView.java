package uabc.julian.baseCrud.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import uabc.julian.baseCrud.Controlador;
import uabc.julian.baseCrud.data.Direccion;

/**
 * agregarPersonaView
 */
public class agregarPersonaView extends VBox{

    private Controlador controlador;

    public agregarPersonaView(Controlador controlador) {
        this.controlador = controlador;
        setLayout();
    }

    public void setLayout() {
        Label nombreLabel = new Label("Nueva Persona");
        TextField inputNombre = new TextField();

        Button confirmarButton = new Button("Confirmar");
        Button cancelarButton = new Button("Cancelar");
        HBox botones = new HBox();
        botones.setSpacing(10);
        botones.getChildren().addAll(confirmarButton, cancelarButton);

        ChoiceBox<Direccion> direcciones = new ChoiceBox<>();

        ObservableList<Direccion> direccionesList = FXCollections.observableArrayList(controlador.solicitarDirecciones());
        direcciones.getItems().addAll(direccionesList);

        direcciones.setConverter(new StringConverter<Direccion>() {
            @Override
            public String toString(Direccion direccion) {
                return direccion != null ? direccion.getDireccion() : "";
            }

            @Override
            public Direccion fromString(String string) {
                // Usually not needed for ChoiceBox, but required by the interface
                return null;
            }
        });

        getChildren().addAll(nombreLabel, inputNombre, direcciones, botones);
        setSpacing(10);
        setAlignment(Pos.CENTER);
        botones.setAlignment(Pos.CENTER);

        getStyleClass().add("custom-edit-window");
        confirmarButton.getStyleClass().add("custom-confirm-button");
        cancelarButton.getStyleClass().add("custom-cancel-button");
        nombreLabel.getStyleClass().add("custom-text");
    }
}
