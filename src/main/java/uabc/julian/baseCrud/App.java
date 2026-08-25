package uabc.julian.baseCrud;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import uabc.julian.baseCrud.view.DireccionFullView;
import uabc.julian.baseCrud.view.MainTabs;
import uabc.julian.baseCrud.view.PersonaFullView;

/**
 * Hello world!
 */
public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        root.getStyleClass().add("custom-background");
        Controlador controlador = new Controlador(root);

        Scene scene = new Scene(root, 600, 800);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
}
