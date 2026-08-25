package uabc.julian.baseCrud.view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import uabc.julian.baseCrud.Controlador;

/**
 * MainTabs
 */
public class MainTabs extends TabPane {

    private Controlador controlador;

    public MainTabs(Controlador controlador) {
        this.controlador = controlador;

        setTabs();
    }

    private void setTabs() {
        Preview previewPersonas = new Preview(controlador);
        Preview previewDirecciones = new Preview(controlador);
        previewPersonas.cargarPersonas();
        previewDirecciones.cargarDirecciones();

        Tab tabPersonas = new Tab();
        tabPersonas.setText("Personas");
        tabPersonas.setContent(previewPersonas);

        Tab tabDirecciones = new Tab();
        tabDirecciones.setText("Direcciones");
        tabDirecciones.setContent(previewDirecciones);

        tabPersonas.setClosable(false);
        tabDirecciones.setClosable(false);

        getTabs().addAll(tabPersonas, tabDirecciones);
    }
}
