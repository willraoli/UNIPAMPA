package model;


public class Filme extends Midia {
    private String genero;
    private String idioma;
    private String diretor;
    private String atoresPrincipais;
    private String duracao;
    private int ano;


    /**
     * Método de acesso ao atributo genero de filme
     * @return o gênero de filme
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Método para definir o nome do gênero de filme
     * @param genero recebe o nome do tipo de gênero
     */
    public void setGenero(String genero){
        if (genero.isBlank() || genero.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Gênero do filme inválido.");
        }
        this.genero = genero;
    }

    /**
     * Método de acesso ao atributo idioma do filme
     * @return o idioma do filme
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Método para definir o idioma de um filme
     * @param idioma recebe o nome do idioma
     */
    public void setIdioma(String idioma){
        if (idioma.isBlank() || idioma.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Idioma não definido.");
        }
        this.idioma = idioma;
    }

    /**
     * Método de acesso ao atributo diretor de um filme
     * @return o nome do diretor do filme
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * Método para definir o nome do diretor de um filme
     * @param diretor recebe o nome do diretor
     */
    public void setDiretor(String diretor){
        if (diretor.isBlank() || diretor.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Diretor não definido.");
        }
        this.diretor = diretor;
    }

    /**
     * Método de acesso ao atributo dos Atores Principais de um filme
     * @return o nome dos Atores Principais de um filme
     */
    public String getAtoresPrincipais() {
        return atoresPrincipais;
    }

    /**
     * Método para definir o nome dos Atores Principais
     * @param atoresPrincipais recebe o nome dos atores principais
     */
    public void setAtoresPrincipais(String atoresPrincipais){
        if (atoresPrincipais.isBlank() || atoresPrincipais.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Atores principais não definidos.");
        }
        this.atoresPrincipais = atoresPrincipais;
    }

    /**
     * Método de acesso ao atributo duracao do filme
     * @return o valor da duração do filme
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * Método para definir a duração de um filme
     * @param duracao recebe o valor da duração do filme
     */
    public void setDuracao(String duracao){
        if(!duracao.equals("")){
            this.duracao = duracao;
        }else {
            throw new IllegalArgumentException("Duração não definido");
        }
    }

    /**
     * Método de acesso ao atributo do ano que o filme foi lançado
     * @return o ano de lançamento do filme
     */
    public int getAno() {
        return ano;
    }

    /**
     * Método para atribuir o ano que o filme foi lançado
     * @param ano recebe o ano de lançamento do filme
     */
    public void setAno(String ano) {
        if (ano.isBlank() || ano.isEmpty() || ano.chars().anyMatch(Character::isLetter)) {
            throw new IllegalArgumentException("Ano inválido.");
        }
        this.ano = Integer.parseInt(ano);
    }



}
