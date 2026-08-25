package uabc.julian.baseCrud.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Controlador;

/**
 * agregarDireccionView
 */
public class agregarDireccionView extends VBox{

    private Controlador controlador;
    private int personaId;

    public agregarDireccionView(Controlador controlador, int personaId) {
        this.controlador = controlador;
        this.personaId = personaId;
        setLayout();
    }

    private void setLayout() {
        Label label = new Label("Ingresa la direccion");
        
        TextField inputField = new TextField();
        Button confirmarButton = new Button("Confirmar");
        Button cancelarButton = new Button("Cancelar");

        HBox botones = new HBox();
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(10);
        botones.getChildren().addAll(confirmarButton, cancelarButton);

        confirmarButton.setOnAction(e -> {
            if (inputField.getText().isEmpty()) {
                return;
            }

            if (personaId == -1) {
                if(controlador.solicitarAñadirDireccion(inputField.getText())) {
                    controlador.cerrarPanel(this);
                }

                return;
            }

            if (controlador.solicitarAñadirDireccion(inputField.getText(), personaId)){
                controlador.InvokeOnDataBaseChanged("", -1);
                controlador.cerrarPanel(this);
            }
        });

        cancelarButton.setOnAction(e -> {
            controlador.cerrarPanel(this);
        });

        confirmarButton.getStyleClass().add("custom-confirm-button");
        cancelarButton.getStyleClass().add("custom-cancel-button");
        label.getStyleClass().add("custom-text");
        getStyleClass().add("custom-edit-window");

        setSpacing(10);
        getChildren().addAll(label, inputField, botones);
    }
}
