package uabc.julian.baseCrud.data;

import java.util.List;

import uabc.julian.baseCrud.view.Visualizable;

/**
 * Persona
 */
public class Persona implements Visualizable {

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

    public String getNombre() {
        return nombre;
    }

    @Override
    public int getId() {
        return id;
    }

	@Override
	public String getTextoVisualizable() {
        return nombre;
	}
}
