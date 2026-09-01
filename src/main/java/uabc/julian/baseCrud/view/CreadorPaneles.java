package uabc.julian.baseCrud.view;

import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.controladores.Lector;
import uabc.julian.baseCrud.controladores.NavegacionUI;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;
import uabc.julian.baseCrud.view.FullViews.FullViewDireccion;
import uabc.julian.baseCrud.view.FullViews.FullViewPersona;
import uabc.julian.baseCrud.view.ListViews.DireccionesView;
import uabc.julian.baseCrud.view.ListViews.PersonasView;
import uabc.julian.baseCrud.view.SmallViews.DireccionSmallView;
import uabc.julian.baseCrud.view.SmallViews.PersonaSmallView;
import uabc.julian.baseCrud.view.SmallViews.TelefonoSmallView;
import uabc.julian.baseCrud.view.agregarViews.agregarPersonaView;

/**
 * CreadorPaneles
 */
public class CreadorPaneles implements Creador{
    private Lector lector;
    private Escritor escritor;
    private NavegacionUI navegacion;

    public CreadorPaneles(Lector lector, Escritor escritor, NavegacionUI navegacion) {
        this.lector = lector;
        this.escritor = escritor;
        this.navegacion = navegacion;
    }

	@Override
	public Pane crearModificarPanel() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearModificarPanel'");
	}

	@Override
	public Pane crearFullViewPersonaPanel(Persona persona) {
        Pane fullView = new FullViewPersona(persona, lector, this, navegacion);
        navegacion.abrirPanel(fullView);
        return fullView;
	}

	@Override
	public Pane crearFullViewDireccionesPanel(Direccion direccion) {
        Pane fullView = new FullViewDireccion(direccion, lector, this, navegacion);
        navegacion.abrirPanel(fullView);
        return fullView;
	}

	@Override
	public Pane crearPreviewPersonasPanel() {
        Pane pane = new PersonasView(lector, this);
        return pane;
	}

	@Override
	public Pane crearPreviewDireccionesPanel() {
        Pane pane = new DireccionesView(lector, this);
        return pane;
	}

	@Override
	public Pane crearAgregarPersonasPanel() {
        Pane pane = new agregarPersonaView(escritor, navegacion);
        navegacion.abrirPanel(pane);
        return pane;
	}

	@Override
	public Pane crearAgregarDireccionesPanel() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearAgregarDireccionesPanel'");
	}

	@Override
	public TabPane crearTabsPanel() {
        return new MainTabs(this);
	}

	@Override
	public Pane crearDireccionSmallView(Direccion direccion, boolean aceptarModificaciones) {
        return new DireccionSmallView(direccion, this, aceptarModificaciones);
	}

	@Override
	public Pane crearPersonaSmallView(Persona persona, boolean aceptarModificaciones) {
        return new PersonaSmallView(persona, this, aceptarModificaciones);
	}

	@Override
	public Pane crearTelefonoSmallView(Telefono telefono, boolean aceptarModificaciones) {
        return new TelefonoSmallView(telefono, this, aceptarModificaciones);
	}
}
