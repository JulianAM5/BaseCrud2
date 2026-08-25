package uabc.julian.baseCrud;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import jdk.jfr.Enabled;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;
import uabc.julian.baseCrud.view.OnDataBaseChangeListener;

/**
 * Controlador
 */
public class Controlador {

    private StackPane root;
    private ArrayList<OnDataBaseChangeListener> listeners;
    private EnlaceDB enlaceDB;

    public Controlador(StackPane root) {
        this.root = root;
        listeners = new ArrayList<>();
        enlaceDB = new EnlaceDB();
    }

    public void abrirPanel(Pane pane) {
        root.getChildren().add(pane);
    }

    public void cerrarPanel(Pane pane) {
        root.getChildren().remove(pane);
    }

    public ArrayList<Persona> solicitarPersonas() {
        return enlaceDB.RecuperarPersonas();
    }

    public ArrayList<Direccion> solicitarDirecciones() {
        return enlaceDB.RecuperarDirecciones();
    }

    public ArrayList<Direccion> solicitarDireccionesDePersona(int personaId) {
        return enlaceDB.RecuperarDireccionesDePersona(personaId);
    }

    public ArrayList<Telefono> solicitarTelefonosDePersona(int personaId) {
        return enlaceDB.RecuperarTelefonosDePersona(personaId);
    }

    public ArrayList<Persona> solicitarPersonasAsociadasADireccion(int direccionId) {
        return enlaceDB.RecuperarPersonasAsociadasADireccion(direccionId);
    }

    public boolean solicitarEliminarTelefono(int personaId, String telefono) {
        return enlaceDB.EliminarTelefono(personaId, telefono);
    }

    public boolean solicitarEliminarDireccion(int direccionId) {
        return enlaceDB.EliminarDireccion(direccionId);
    }

    public boolean solicitarEliminarPersona(int personaId) {
        return enlaceDB.EliminarPersona(personaId);
    }

    public boolean solicitarModificarNombre(int personaId, String nombre) {
        return enlaceDB.ModificarPersona(personaId, nombre);
    }

    public boolean solicitarModificarDireccion(int direccionId, String direccion) {
        return enlaceDB.ModificarDireccion(direccionId, direccion);
    }

    public boolean solicitarModificarTelefono(int personaId, String telefono) {
        return enlaceDB.ModificarTelefono(personaId, telefono);
    }

    public boolean solicitarAñadirPersona(String nombre) {
        return enlaceDB.AñadirPersona(nombre);
    }

    public boolean solicitarAñadirTelefono(int personaId, String telefono) {
        return enlaceDB.AñadirTelefono(personaId, telefono);
    }

    public boolean solicitarAñadirDireccion(String direccion) {
        return enlaceDB.AñadirDireccion(direccion);
    }

    public boolean solicitarAñadirDireccion(String direccion, int personaId) {
        return enlaceDB.AñadirDireccion(direccion, personaId);
    }

    public boolean solicitarAsociacionPersonaDireccion(int personaId, int direccionId) {
        return enlaceDB.AsociarPersonaDireccion(personaId, direccionId);
    }

    public void addOnDataBaseListener(OnDataBaseChangeListener listener) {
        listeners.add(listener);
    }

    public void InvokeOnDataBaseChanged(String newValue, int tipo) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).OnDataBaseChanged(newValue, tipo);
        }
    }
}
