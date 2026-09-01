package uabc.julian.baseCrud.BaseDatos;

import java.util.ArrayList;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Repositorio
 */
public interface Repositorio {

    boolean iniciarConexion();
    boolean cerrarConexion();

    ArrayList<Persona> consultarTodasPersonas();
    Persona consultarPersona(int id);

    ArrayList<Direccion> consultarTodasDirecciones();
    Direccion consultarDireccion(int id);

    Telefono consultarTelefono(int id);

    ArrayList<Telefono> consultarTelefonosDePersona(int personaId);
    ArrayList<Direccion> consultarDireccionesDePersona(int personaId);
    ArrayList<Persona> consultarPersonasEnDireccion(int direccionId);

    boolean agregarPersona(Persona persona);
    boolean agregarTelefono(Telefono telefono);
    int agregarDireccion(Direccion direccion);

    boolean modificarPersona(Persona persona);
    boolean modificarDireccion(Direccion direccion);
    boolean modificarTelefono(Telefono telefono);

    boolean asignarDireccionAPersona(int personaId, int direccionId);

    boolean desasignarDireccionDePersona(int personaId, int direccionId);

    boolean eliminarPersona(int id);
    boolean eliminarDireccion(int id);
    boolean eliminarTelefono(int id);
}
