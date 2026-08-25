package uabc.julian.baseCrud;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Pane(), 600, 800);
        stage.setScene(scene);
        stage.show();
	}
}
