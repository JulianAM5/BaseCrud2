 package uabc.julian.baseCrud.view;   

import java.util.ArrayList;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import uabc.julian.baseCrud.EnlaceDB;
import uabc.julian.baseCrud.BaseDatos.MariaRepo;
import uabc.julian.baseCrud.controladores.NavegacionUI;

public class LoginView extends VBox {

    private MariaRepo repo;
    private NavegacionUI navegacion;
    private Creador creador;

    public LoginView(MariaRepo repo, NavegacionUI navegacion, Creador creador) {
        this.repo = repo;
        this.navegacion = navegacion;
        this.creador = creador;
        setLayout();
    }

    private void setLayout() {
        Label usuarioLabel = new Label("Usuario");
        Label contraseñaLabel = new Label("Contraseña");

        TextField usuarioField = new TextField();
        PasswordField contraseñaField = new PasswordField();
        
        Button loginButton = new Button("Iniciar Sesión");
        usuarioLabel.getStyleClass().add("custom-text");
        contraseñaLabel.getStyleClass().add("custom-text");

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(usuarioField);
        nodes.add(contraseñaField);
        nodes.add(loginButton);

        loginButton.setOnAction(e -> {
            EnlaceDB enlaceDB = new EnlaceDB(usuarioField.getText(), contraseñaField.getText());
            repo.setCredenciales(usuarioField.getText(), contraseñaField.getText());
            if(repo.iniciarConexion()) {
                loginButton.setDisable(true);
                creador.crearTabsPanel();
                navegacion.getRoot().getChildren().add(creador.crearTabsPanel());
                navegacion.cerrarPanel(this);
            } else {
                startRedBlink(nodes);
            }
        });

        loginButton.getStyleClass().add("custom-login-button");
        getStyleClass().add("vbox");
        usuarioField.getStyleClass().add("custom-field");
        contraseñaField.getStyleClass().add("custom-field");

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
