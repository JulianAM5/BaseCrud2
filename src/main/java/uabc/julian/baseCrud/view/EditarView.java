package uabc.julian.baseCrud.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uabc.julian.baseCrud.Controlador;

/**
 * EditarView
 */
public class EditarView extends VBox{
    enum Tipo {
        PERSONA,
        DIRECCION,
        TELEFONO,
    }

    private Controlador controlador;
    private Tipo tipo;

    public EditarView(Controlador controlador, int id) {
        this.controlador = controlador;
        TextField textField = new TextField();
        Button confirmarButton = new Button("Confirmar");
        Button cancelarButton = new Button("Cancelar");

        setButtonEvent(confirmarButton, id, textField);
        cancelarButton.setOnAction(e -> { controlador.cerrarPanel(this);});
        HBox botones = new HBox();
        botones.setSpacing(10);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(confirmarButton, cancelarButton);

        getChildren().addAll(textField, botones);
        setSpacing(10);
        setPadding(new Insets(10));
    }

    private void setButtonEvent(Button button, int id, TextField textField) {
        switch (tipo) {
            case PERSONA:
                button.setOnAction(e -> {
                    if (controlador.solicitarModificarNombre(id, textField.getText())) {
                        controlador.cerrarPanel(this);
                    }
                });
                break;
            case DIRECCION:
                button.setOnAction(e -> {
                    if (controlador.solicitarModificarDireccion(id, textField.getText())) {
                        controlador.cerrarPanel(this);
                    }
                });
                break;
            case TELEFONO:
                button.setOnAction(e -> {
                    if(controlador.solicitarModificarTelefono(id, textField.getText())) {
                        controlador.cerrarPanel(this);
                    }
                });
                break;
            default:
                break;
        }
    }
}
