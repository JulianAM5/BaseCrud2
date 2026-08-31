package uabc.julian.baseCrud.data;

/**
 * Direccion
 */
public class Direccion {

    private int id;
    private String direccion;

    public Direccion(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getId() {
        return id;
    }
}
