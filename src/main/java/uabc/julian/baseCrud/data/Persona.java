package uabc.julian.baseCrud.data;

import java.util.ArrayList;

import uabc.julian.baseCrud.view.Visualizable;

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
        this.direcciones = direcciones;
        this.telefonos = telefonos;
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
}
