package uabc.julian.baseCrud.controladores;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import uabc.julian.baseCrud.BaseDatos.Repositorio;
import uabc.julian.baseCrud.Eventos.Listener;
import uabc.julian.baseCrud.Eventos.Subscriptor;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;
import uabc.julian.baseCrud.view.Creador;

/**
 * Controlador
 */
public class Controlador implements Escritor, Lector, NavegacionUI, Subscriptor {

    private Pane root;
    private Repositorio repositorio;

    public Controlador(Repositorio repositorio, Pane root) {
        this.root = root;
        this.repositorio = repositorio;
    }

	@Override
	public Persona leerPersona(int id) {
        return repositorio.consultarPersona(id);
	}

	@Override
	public Direccion leerDireccion(int id) {
        return repositorio.consultarDireccion(id);
	}

	@Override
	public Telefono leerTelefono(int id) {
        return new Telefono(-1, -1, "");
    }

    @Override
    public boolean agregarPersona(Persona persona) {
        if (persona.getNombre().isBlank()) { return false; }
        if (persona.getTelefonos().isEmpty()) { return false; }
        if (persona.getDirecciones().isEmpty()) { return false; }

        boolean resultado = repositorio.agregarPersona(persona);
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean agregarDireccion(Direccion direccion) {
        if (direccion.getDireccion().isBlank()) { return false; }

        boolean resultado = repositorio.agregarDireccion(direccion) > 0;
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean agregarTelefono(Telefono telefono) {
        if (telefono.getNumeroTelefonico().isBlank()) { return false; }

        boolean resultado = repositorio.agregarTelefono(telefono);
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean modificarPersona(Persona persona) {
        boolean resultado = repositorio.modificarPersona(persona);
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean modificarDireccion(Direccion direccion) {
        boolean resultado = repositorio.modificarDireccion(direccion);
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean modificarTelefono(Telefono telefono) {
        boolean resultado = repositorio.modificarTelefono(telefono);
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean eliminarPersona(int id) {
        boolean resultado = repositorio.eliminarPersona(id);
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean eliminarDireccion(int id) {
        boolean resultado = repositorio.eliminarDireccion(id);
        if (resultado) { invocarListeners(); }
        return resultado;
    }

    @Override
    public boolean eliminarTelefono(int id) {
        boolean resultado = repositorio.eliminarTelefono(id);
        if (resultado) { invocarListeners(); }
        return resultado;
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

    @Override
    public void invocarListeners() {
        for (Node child : root.getChildren()) {
            if (child instanceof Listener) {
                ((Listener) child).actualizar();
            }
        }
    }
}
