package uabc.julian.baseCrud.view;

import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import uabc.julian.baseCrud.controladores.Escritor;
import uabc.julian.baseCrud.controladores.Lector;
import uabc.julian.baseCrud.controladores.NavegacionUI;

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
	public Pane crearFullViewPersonaPanel() {
		throw new UnsupportedOperationException("Unimplemented method 'crearFullViewPersonaPanel'");
	}

	@Override
	public Pane crearFullViewDireccionesPanel() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearFullViewDireccionesPanel'");
	}

	@Override
	public Pane crearPreviewPersonasPanel() {
        Pane pane = new PersonasView(lector);
        return pane;
	}

	@Override
	public Pane crearPreviewDireccionesPanel() {
        Pane pane = new DireccionesView(lector);
        return pane;
	}

	@Override
	public Pane crearAgregarPersonasPanel() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearAgregarPersonasPanel'");
	}

	@Override
	public Pane crearAgregarDireccionesPanel() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearAgregarDireccionesPanel'");
	}

	@Override
	public Pane crearSmallView(Visualizable visualizable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearSmallView'");
	}

	@Override
	public TabPane crearTabsPanel() {
        return new MainTabs(this);
	}
}
