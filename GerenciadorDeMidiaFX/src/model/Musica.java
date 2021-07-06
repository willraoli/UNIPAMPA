package model;

public class Musica extends Midia {
    private String genero;
    private String idioma;
    private String autores;
    private String interpretes;
    private String duracao;
    private int ano;

    public Musica() {}

    /**
     * Retorna o gênero da música
     * @return uma string contendo o gênero do objeto Musica
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Muda o gênero do objeto Musica
     * @param genero
     */
    public void setGenero(String genero){
        if(genero.chars().anyMatch(Character::isDigit) || genero.isBlank()){
            throw new IllegalArgumentException("Gênero(s) não definido(s)");
        }else {
            this.genero = genero;
        }
    }

    /**
     * Retorna o idioma da música
     * @return uma string contendo o idioma do objeto Musica
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Muda o idioma do objeto Musica
     * @param idioma
     */
    public void setIdioma(String idioma){
        if(idioma.chars().anyMatch(Character::isDigit) || idioma.isBlank()){
            throw new IllegalArgumentException("Idioma(s) não definido(s)");
        }else {
            this.idioma = idioma;
        }
    }

    /**
     * Retorna os autores da música
     * @return uma string contendo os autores do objeto Musica
     */
    public String getAutores() {
        return autores;
    }

    /**
     * Muda os autores da música
     * @param autores
     */
    public void setAutores(String autores){
        if(autores.chars().anyMatch(Character::isDigit) || autores.isBlank()){
            throw new IllegalArgumentException("Autor(es) não definido(s)");
        }
        this.autores = autores;
    }

    /**
     * Retorna os intérpretes da música
     * @return uma string contendo os interpretes
     */
    public String getInterpretes() {
        return interpretes;
    }

    /**
     * Muda os intérpretes da música
     * @param interpretes
     */
    public void setInterpretes(String interpretes){
        this.interpretes = interpretes;
    }

    /**
     * Retorna a duração da música
     * @return uma string contendo a duração do objeto Musica
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * Muda a duração da música
     * @param duracao
     */
    public void setDuracao(String duracao){
        if(!duracao.equals("")){
            this.duracao = duracao;
        }else {
            throw new IllegalArgumentException("Duração não definida");
        }
    }

    /**
     * Retorna o ano da música
     * @return um int contendo o ano do objeto Musica
     */
    public int getAno() {
        return ano;
    }

    public void setAno(String ano) throws NumberFormatException{
        if (ano.isBlank() || ano.chars().anyMatch( Character::isLetter)) {
            throw new IllegalArgumentException("Ano inválido.");
        }
        this.ano = Integer.parseInt(ano);
    }
}
