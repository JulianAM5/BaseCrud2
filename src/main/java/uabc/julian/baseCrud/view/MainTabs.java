package uabc.julian.baseCrud.view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import uabc.julian.baseCrud.Controlador;

/**
 * MainTabs
 */
public class MainTabs extends TabPane {

    private Creador creador;

    public MainTabs(Creador creador) {
        this.creador = creador;
        setTabs();
    }

    private void setTabs() {       
        Tab tabPersonas = new Tab();
        tabPersonas.setText("Personas");
        tabPersonas.setContent(creador.crearPreviewPersonasPanel());

        Tab tabDirecciones = new Tab();
        tabDirecciones.setText("Direcciones");
        tabDirecciones.setContent(creador.crearPreviewDireccionesPanel());

        tabPersonas.setClosable(false);
        tabDirecciones.setClosable(false);

        getTabs().addAll(tabPersonas, tabDirecciones);
    }
}
