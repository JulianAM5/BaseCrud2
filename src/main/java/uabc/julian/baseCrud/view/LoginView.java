 package uabc.julian.baseCrud.view;   

import java.util.ArrayList;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import uabc.julian.baseCrud.Controlador;
import uabc.julian.baseCrud.EnlaceDB;

public class LoginView extends VBox {
    private Controlador controlador;
    public LoginView(Controlador controlador) {
        this.controlador = controlador;
        setLayout();
    }

    private void setLayout() {
        Label usuarioLabel = new Label("Usuario");
        Label contraseñaLabel = new Label("Contraseña");

        TextField usuarioField = new TextField();
        TextField contraseñaField = new TextField();
        
        Button loginButton = new Button("Iniciar Sesión");
        usuarioLabel.getStyleClass().add("custom-text");
        contraseñaLabel.getStyleClass().add("custom-text");

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(usuarioField);
        nodes.add(contraseñaField);
        nodes.add(loginButton);

        loginButton.setOnAction(e -> {
            EnlaceDB enlaceDB = new EnlaceDB(usuarioField.getText(), contraseñaField.getText());
            
            if(enlaceDB.ConectarAServidor()) {
                loginButton.setDisable(true);
                controlador.setDB(enlaceDB);
            } else {
                startRedBlink(nodes);
            }
        });

        loginButton.getStyleClass().add("custom-login-button");
        getStyleClass().add("vbox");
        usuarioField.getStyleClass().add("custom-field");
        contraseñaField.getStyleClass().add("custom-password");

        getChildren().addAll(usuarioLabel, usuarioField, contraseñaLabel, contraseñaField, loginButton);
        setAlignment(Pos.CENTER);
        setSpacing(10);
    }

    private void startRedBlink(ArrayList<Node> nodes) {
        for (Node node : nodes) {
            node.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 3px;");
        }

        PauseTransition pause = new PauseTransition(Duration.millis(300));
        pause.setOnFinished(e -> {
            for (Node node : nodes) {
                node.setStyle("");
            }
        });
        pause.play();
    }
}
