package uabc.julian.baseCrud.data;

/**
 * Telefono
 */
public class Telefono {

    private int personaId;
    private String numeroTelefonico;

    public Telefono(int personaId, String numeroTelefonico) {
        this.personaId = personaId;
        this.numeroTelefonico = numeroTelefonico;
    }

    public int getPersonaId() {
        return personaId;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }
}
