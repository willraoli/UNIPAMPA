package interfaces;

import model.ManipulaMidias;

public interface IController {
    /**
     * Fecha o stage atual ao clicar no botão
     */
    void cancelarClick();

    /**
     * Abre um FileChooser para escolher a mídia
     */
    void escolherLocal();

    /**
     * Passa o ManipulaMidias m para o controlador
     * @param m
     */
    void setLista(ManipulaMidias m);
}
