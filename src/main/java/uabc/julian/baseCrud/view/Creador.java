package uabc.julian.baseCrud.view;

import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

/**
 * Creador
 */
public interface Creador {
    TabPane crearTabsPanel();
    Pane crearSmallView(Visualizable visualizable);
    Pane crearModificarPanel();
    Pane crearFullViewPersonaPanel();
    Pane crearFullViewDireccionesPanel();
    Pane crearPreviewPersonasPanel();
    Pane crearPreviewDireccionesPanel();
    Pane crearAgregarPersonasPanel();
    Pane crearAgregarDireccionesPanel();
}
