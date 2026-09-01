package uabc.julian.baseCrud.controladores;

import java.util.ArrayList;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Lector
 */
public interface Lector {
    ArrayList<Persona> leerPersonas();
    ArrayList<Direccion> leerDirecciones();

    ArrayList<Persona> leerPersonasAsignadasADireccion(int direccionId);
    ArrayList<Direccion> leerDireccionesAsignadasAPersona(int personaId);
    ArrayList<Telefono> leerTelefonosAsignadosAPersona(int personaId);

    Persona leerPersona(int id);
    Direccion leerDireccion(int id);
    Telefono leerTelefono(int id);
}
