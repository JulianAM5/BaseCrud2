package uabc.julian.baseCrud.BaseDatos;

import java.util.List;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Repositorio
 */
public interface Repositorio {

    boolean iniciarConexion();
    boolean cerrarConexion();

    List<Persona> consultarTodasPersonas();
    Persona consultarPersona(int id);

    List<Direccion> consultarTodasDirecciones();
    Direccion consultarDireccion(int id);

    List<Telefono> consultarTodosTelefonos();
    Telefono consultarTelefono(int id);

    List<Telefono> consultarTelefonosDePersona(int personaId);
    List<Direccion> consultarDireccionesDePersona(int personaId);
    List<Persona> consultarPersonaEnDireccion(int direccionId);

    boolean agregarPersona(Persona persona);
    boolean agregarTelefono(Telefono telefono);
    boolean agregarDireccion(Direccion direccion);

    boolean modificarPersona(Persona persona);
    boolean modificarDireccion(Direccion direccion);
    boolean modificarTelefono(Telefono telefono);

    boolean asignarDireccionAPersona(int personaId, int direccionId);
    boolean asignarTelefonoAPersona(int personaId, int telefonoId);

    boolean desasignarDireccionDePersona(int personaId, int direccionId);
    boolean desasignarTelefonoDePersona(int personaId, int direccionId);

    boolean eliminarPersona(int id);
    boolean eliminarDireccion(int id);
    boolean eliminarTelefono(int id);
}
