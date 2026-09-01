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
        return repositorio.agregarPersona(persona);
	}

	@Override
	public boolean agregarDireccion(Direccion direccion) {
        return repositorio.agregarDireccion(direccion);
	}

	@Override
	public boolean agregarTelefono(Telefono telefono) {
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eliminarPersona'");
	}

	@Override
	public boolean eliminarDireccion(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eliminarDireccion'");
	}

	@Override
	public boolean eliminarTelefono(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'eliminarTelefono'");
	}

	@Override
	public boolean asignarDireccionAPersona(int personaId, int direccionId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asignarDireccionAPersona'");
	}

	@Override
	public boolean desasignarDireccionAPersona(int personaId, int direccionId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'desasignarDireccionAPersona'");
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
        return new ArrayList<>();
	}

	@Override
	public ArrayList<Direccion> leerDireccionesAsignadasAPersona(int personaId) {
        return new ArrayList<>();
	}

	@Override
	public ArrayList<Telefono> leerTelefonosAsignadosAPersona(int personaId) {
        return new ArrayList<>();
	}

	@Override
	public ArrayList<Persona> leerPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona(2, "Julian", null, null));
        personas.add(new Persona(2, "Julian", null, null));
        personas.add(new Persona(2, "Julian", null, null));
        personas.add(new Persona(2, "Julian", null, null));
        personas.add(new Persona(2, "Julian", null, null));

        return personas;
	}

	@Override
	public ArrayList<Direccion> leerDirecciones() {
        return new ArrayList<>();
	}

	@Override
	public ArrayList<Telefono> leerTelefonos() {
        return new ArrayList<>();
	}
}
