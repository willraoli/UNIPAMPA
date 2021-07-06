package model;

import java.util.UUID;

public class Pessoa {
    String nome;
    UUID uniqueId;

    public Pessoa(String nome){
        this.nome = nome;
        uniqueId = UUID.randomUUID();
    }

    public UUID getUniqueId() {
        return uniqueId;
    }
}