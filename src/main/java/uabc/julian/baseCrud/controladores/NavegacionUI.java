package uabc.julian.baseCrud.controladores;

import javafx.scene.layout.Pane;

/**
 * NavegacionUI
 */
public interface NavegacionUI {
    void abrirPanel(Pane pane);
    void cerrarPanel(Pane pane);

    Pane getRoot();
    void setRoot(Pane root);
}
