package model;

import java.util.ArrayList;

public class Musica extends Midia{
    private String genero;
    private String idioma;
    private ArrayList<Pessoa> autores;
    private ArrayList<Pessoa> interpretes;
    private String duracao;
    private int ano;

    public Musica(String titulo, String descricao, String genero, String idioma, ArrayList<Pessoa> autores, ArrayList<Pessoa> interpretes, String duracao, int ano, String caminhoDoArquivo){
        super(titulo, descricao, caminhoDoArquivo);
        this.genero = genero;
        this.idioma = idioma;
        this.autores = autores;
        this.interpretes = interpretes;
        this.duracao = duracao;
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public ArrayList<Pessoa> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Pessoa> autores) {
        this.autores = autores;
    }

    public ArrayList<Pessoa> getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(ArrayList<Pessoa> interpretes) {
        this.interpretes = interpretes;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
