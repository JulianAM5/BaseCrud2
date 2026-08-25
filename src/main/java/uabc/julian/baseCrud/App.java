package uabc.julian.baseCrud;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import uabc.julian.baseCrud.view.PersonaFullView;

/**
 * Hello world!
 */
public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Controlador controlador = new Controlador();

        root.getChildren().add(new PersonaFullView(controlador, 1, ""));

        Scene scene = new Scene(root, 600, 800);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
}
