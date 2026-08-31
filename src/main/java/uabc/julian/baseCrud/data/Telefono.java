package uabc.julian.baseCrud.data;

import uabc.julian.baseCrud.view.Visualizable;

/**
 * Telefono
 */
public class Telefono implements Visualizable {

    private int id;
    private int personaId;
    private String numeroTelefonico;

    public Telefono(int id, int personaId, String numeroTelefonico) {
        this.id = id;
        this.personaId = personaId;
        this.numeroTelefonico = numeroTelefonico;
    }

    public int getId() {
        return id;
    }

    public int getPersonaId() {
        return personaId;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

	@Override
	public String getTextoVisualizable() {
        return numeroTelefonico;
	}
}
