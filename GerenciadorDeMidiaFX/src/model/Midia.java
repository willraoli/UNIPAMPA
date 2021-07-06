package model;

import java.io.Serializable;

public abstract class Midia implements Serializable {
	
    private String caminhoDoArquivo;
    private String titulo;
    private String descricao;
   

    public Midia(String titulo, String descricao, String caminhoDoArquivo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.caminhoDoArquivo = caminhoDoArquivo;
        
    }

    public Midia() {

    }

    public String getCaminhoDoArquivo() {
        return caminhoDoArquivo;
    }

    public void setCaminhoDoArquivo(String caminhoDoArquivo) {
        if (caminhoDoArquivo == null) {
            throw new NullPointerException("Caminho do arquivo está vazio.");
        }
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode estar vazio.");
        }
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
