package model;

public class Filme extends Midia{
    private String genero;
    private String idioma;
    private String diretor;
    private String atoresPrincipais;
    private String duracao;
    private int ano;

    public Filme(String titulo, String descricao, String caminhoDoArquivo, String genero, String idioma, String diretor, String atoresPrincipais, String duracao, int ano) {
        super(titulo, descricao, caminhoDoArquivo);
        this.genero = genero;
        this.idioma = idioma;
        this.diretor = diretor;
        this.atoresPrincipais = atoresPrincipais;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtoresPrincipais() {
        return atoresPrincipais;
    }

    public void setAtoresPrincipais(String atoresPrincipais) {
        this.atoresPrincipais = atoresPrincipais;
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
