package uabc.julian.baseCrud.data;

import java.util.List;

/**
 * Persona
 */
public class Persona {

    private int id;
    private String nombre;
    private List<Direccion> direcciones;
    private List<Telefono> telefonos;

    public Persona(int id, String nombre, List<Direccion> direcciones, List<Telefono> telefonos) {
        this.id = id;
        this.nombre = nombre;
        this.direcciones = direcciones;
        this.telefonos = telefonos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
