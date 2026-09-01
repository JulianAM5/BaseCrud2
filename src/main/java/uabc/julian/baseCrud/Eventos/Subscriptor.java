package uabc.julian.baseCrud.Eventos;

import java.util.ArrayList;

/**
 * Subscriptor
 */
public interface Subscriptor {
    public ArrayList<Listener> listeners = new ArrayList<Listener>();

    void invocarListeners();
}
