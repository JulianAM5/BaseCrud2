package uabc.julian.baseCrud.data;

import java.util.ArrayList;

/**
 * Persona
 */
public class Persona {

    private int id;
    private String nombre;
    private ArrayList<Direccion> direcciones;
    private ArrayList<Telefono> telefonos;

    public Persona(int id, String nombre, ArrayList<Direccion> direcciones, ArrayList<Telefono> telefonos) {
        this.id = id;
        this.nombre = nombre;

        if (direcciones == null) {
            direcciones = new ArrayList();
        } else {
            this.direcciones = direcciones;
        }

        if (telefonos == null) {
            telefonos = new ArrayList();
        } else {
            this.telefonos = telefonos;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
