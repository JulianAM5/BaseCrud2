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

    public String getDireccion() {
        return direccion;
    }

    @Override
    public int getId() {
        return id;
    }

	@Override
	public String getTextoVisualizable() {
        return direccion;
	}
}
