package uabc.julian.baseCrud.view;

import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Creador
 */
public interface Creador {
    TabPane crearTabsPanel();
    Pane crearPersonaSmallView(Persona persona, boolean aceptarModificaciones);
    Pane crearDireccionSmallView(Direccion direccion, boolean aceptarModificaciones);
    Pane crearTelefonoSmallView(Telefono telefono, boolean aceptarModificaciones);
    Pane crearModificarPanel();
    Pane crearFullViewPersonaPanel();
    Pane crearFullViewDireccionesPanel();
    Pane crearPreviewPersonasPanel();
    Pane crearPreviewDireccionesPanel();
    Pane crearAgregarPersonasPanel();
    Pane crearAgregarDireccionesPanel();
}
