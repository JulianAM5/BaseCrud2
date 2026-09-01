package uabc.julian.baseCrud;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import uabc.julian.baseCrud.BaseDatos.MariaRepo;
import uabc.julian.baseCrud.controladores.Controlador;
import uabc.julian.baseCrud.view.CreadorPaneles;
import uabc.julian.baseCrud.view.MainTabs;

/**
 * Hello world!
 */
public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        root.getStyleClass().add("custom-background");

        MariaRepo repo = new MariaRepo(USER, PASSWORD);
        repo.iniciarConexion();

        Controlador controlador = new Controlador(repo, root);
        CreadorPaneles creador = new CreadorPaneles(controlador, controlador, controlador);

        root.getChildren().add(creador.crearTabsPanel());


        Scene scene = new Scene(root, 600, 800);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}
}
