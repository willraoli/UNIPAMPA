package model;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class ClienteVIP extends Cliente implements Serializable {

    public ClienteVIP(long rg, String nome, float credito, String categoria){
        super(rg, nome, credito, categoria);
    }

    public ClienteVIP() {}

    @Override
    public float getValorEntrada(){
        return super.getEntrada() * 2f;
    }


    public String toString(){
        return "Categoria: VIP";
    }
}
