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

    public Controlador(StackPane root) {
        this.root = root;
    }

    public void abrirPanel(Pane pane) {
        root.getChildren().add(pane);
    }

    public void cerrarPanel(Pane pane) {
        root.getChildren().remove(pane);
    }

    public ArrayList<Persona> solicitarPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        return personas;
    }

    public ArrayList<Direccion> solicitarDirecciones() {
        ArrayList<Direccion> direcciones = new ArrayList<>();
        return direcciones;
    }

    public ArrayList<Direccion> solicitarDireccionesDePersona(int personaId) {
        ArrayList<Direccion> direcciones = new ArrayList<>();
        return direcciones;
    }

    public ArrayList<Telefono> solicitarTelefonosDePersona(int personaId) {
        ArrayList<Telefono> telefonos = new ArrayList<>();
        return telefonos;
    }

    public ArrayList<Persona> solicitarPersonasAsociadasADireccion(int direccionId) {
        ArrayList<Persona> personas = new ArrayList<>();
        return personas;
    }

    public boolean soliciarEdicionDeNombre() {
        return true;
    }
}
