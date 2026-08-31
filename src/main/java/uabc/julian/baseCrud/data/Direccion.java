package uabc.julian.baseCrud.data;

import uabc.julian.baseCrud.view.Visualizable;

/**
 * Direccion
 */
public class Direccion implements Visualizable {

    private int id;
    private String direccion;

    public Direccion(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

	@Override
	public String getTextoVisualizable() {
        return direccion;
	}
}
