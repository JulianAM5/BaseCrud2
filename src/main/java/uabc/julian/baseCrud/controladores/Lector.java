package uabc.julian.baseCrud.controladores;

import java.util.List;

import uabc.julian.baseCrud.data.Direccion;
import uabc.julian.baseCrud.data.Persona;
import uabc.julian.baseCrud.data.Telefono;

/**
 * Lector
 */
public interface Lector {
    List<Persona> leerPersonas();
    List<Direccion> leerDirecciones();
    List<Telefono> leerTelefonos();

    Persona leerPersona(int id);
    Direccion leerDireccion(int id);
    Telefono leerTelefono(int id);
}
