package uabc.julian.baseCrud;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Controlador
 */
public class Controlador {

    private StackPane root;
    private EnlaceDB enlaceDB;

    public Controlador(StackPane root) {
        this.root = root;
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

    public boolean soliciarEdicionDeNombre() {
        return true;
    }
}
