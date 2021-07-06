package model;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class ClientePista extends Cliente implements Serializable {

    public ClientePista(long rg, String nome, float credito, String categoria){
        super(rg, nome, credito, categoria);
    }

    public ClientePista() {}

    @Override
    public float getValorEntrada(){
        return super.getEntrada();
    }

    public String toString(){
        return "Categoria: Pista";
    }
}