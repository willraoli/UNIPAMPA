package model;

import java.io.Serializable;

public class ClienteCamarote extends Cliente implements Serializable {

    public ClienteCamarote(long rg, String nome, float credito, String categoria){
        super(rg, nome, credito, categoria);
    }

    public ClienteCamarote() {}

    @Override
    public float getValorEntrada(){
        return super.getEntrada() * 1.5f;
    }

    public String toString(){
        return "Categoria: Camarote";
    }
}
