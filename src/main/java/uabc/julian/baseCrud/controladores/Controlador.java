package uabc.julian.baseCrud.controladores;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import uabc.julian.baseCrud.BaseDatos.Repositorio;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;
import uabc.julian.baseCrud.view.Creador;

/**
 * Controlador
 */
public class Controlador implements Escritor, Lector, NavegacionUI {

    private Pane root;
    private Repositorio repositorio;

    public Controlador(Repositorio repositorio, Pane root) {
        this.root = root;
        this.repositorio = repositorio;
    }

	@Override
	public Persona leerPersona(int id) {
        Persona persona = new Persona(1, "", null, null);
        return persona;
	}

	@Override
	public Direccion leerDireccion(int id) {
        Direccion direccion = new Direccion(1, "");
        return direccion;
	}

	@Override
	public Telefono leerTelefono(int id) {
        Telefono telefono = new Telefono(1, 1, "");
        return telefono;
	}

	@Override
	public boolean agregarPersona(Persona persona) {
        if (persona.getNombre().isBlank()) { return false; }
        if (persona.getTelefonos().isEmpty()) { return false; }
        if (persona.getDirecciones().isEmpty()) { return false; }

        return repositorio.agregarPersona(persona);
	}

	@Override
	public boolean agregarDireccion(Direccion direccion) {
        if (direccion.getDireccion().isBlank()) { return false; }

        return repositorio.agregarDireccion(direccion) > 0;
	}

	@Override
	public boolean agregarTelefono(Telefono telefono) {
        if (telefono.getNumeroTelefonico().isBlank()) { return false; }

        return repositorio.agregarTelefono(telefono);
	}

	@Override
	public boolean modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'modificarPersona'");
	}

	@Override
	public boolean modificarDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'modificarDireccion'");
	}

	@Override
	public boolean modificarTelefono(Telefono telefono) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'modificarTelefono'");
	}

	@Override
	public boolean eliminarPersona(int id) {
        return repositorio.eliminarPersona(id);
	}

	@Override
	public boolean eliminarDireccion(int id) {
        return repositorio.eliminarDireccion(id);
	}

	@Override
	public boolean eliminarTelefono(int id) {
        return repositorio.eliminarTelefono(id);
	}

	@Override
	public boolean asignarDireccionAPersona(int personaId, int direccionId) {
        return repositorio.asignarDireccionAPersona(personaId, direccionId);
	}

	@Override
	public boolean desasignarDireccionAPersona(int personaId, int direccionId) {
        return repositorio.desasignarDireccionDePersona(personaId, direccionId);
	}

	@Override
	public void abrirPanel(Pane pane) {
        root.getChildren().add(pane);
	}

	@Override
	public void cerrarPanel(Pane pane) {
        root.getChildren().remove(pane);
	}

	@Override
	public ArrayList<Persona> leerPersonasAsignadasADireccion(int direccionId) {
        return repositorio.consultarPersonasEnDireccion(direccionId);
	}

	@Override
	public ArrayList<Direccion> leerDireccionesAsignadasAPersona(int personaId) {
        return repositorio.consultarDireccionesDePersona(personaId);
	}

	@Override
	public ArrayList<Telefono> leerTelefonosAsignadosAPersona(int personaId) {
        return repositorio.consultarTelefonosDePersona(personaId);
	}

	@Override
	public ArrayList<Persona> leerPersonas() {
        return repositorio.consultarTodasPersonas();
	}

	@Override
	public ArrayList<Direccion> leerDirecciones() {
        return repositorio.consultarTodasDirecciones();
	}
}
