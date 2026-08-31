package uabc.julian.baseCrud.controladores;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Escritor
 */
public interface Escritor {
    boolean agregarPersona(Persona persona);
    boolean agregarDireccion(Direccion direccion);
    boolean agregarTelefono(Telefono telefono);

    boolean modificarPersona(Persona persona);
    boolean modificarDireccion(Direccion direccion);
    boolean modificarTelefono(Telefono telefono);

    boolean eliminarPersona(int id);
    boolean eliminarDireccion(int id);
    boolean eliminarTelefono(int id);

    boolean asignarDireccionAPersona(int personaId, int direccionId);
    boolean desasignarDireccionAPersona(int personaId, int direccionId);
    boolean asignarTelefonoAPersona(int personaId, int telefonoId);
    boolean desasignarTelefonoAPersona(int personaId, int telefonoId);
}
