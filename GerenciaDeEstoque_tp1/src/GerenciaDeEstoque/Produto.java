/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

public abstract class Produto {

    protected final int codigo;
    protected String nome;
    protected String descricao;
    protected double valor;
    protected static int nCodigo = 0;

    /**
     * Uma sobrecarga do construtor Produto
     *
     * @param nome      refere-se ao nome do produto
     * @param descricao refere-se à descrição do produto
     * @param valor     refere-se ao preço do produto
     */
    public Produto(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        codigo = 1 + nCodigo;
        Produto.nCodigo++;
    }

    /**
     * Método abstrato que será implementado nas classes derivadas
     * @param q recebe e define a quantidade de um produto
     */
    public abstract void setQuantidade(double q);

    /**
     * Método abstrato de acesso ao atributo quantidade que será implementado nas classes derivadas
     * @return o valor de quantidade
     */
    public abstract double getQuantidade();

    /**
     * Subtrai uma quantidade do produto
     * @param quantidade recebe uma quantidade a ser subtraída de um produto
     * @return quantidade do produto menos a quantidade a ser subtraída
     */
    public abstract boolean subQuantidade(double quantidade);

    /**
     * Adicina uma quantidade no produto
     * @param quantidade recebe uma quantidade a ser adicionada na quantidade total do produto
     * @return o resultado da quantidade a ser adicionada mais a quantidade total
     */
    public abstract boolean addQuantidade(double quantidade);

    /**
     * Recebe as informações do construtor
     * @return retorna uma string com código, nome, descrição e preço
     */
    public String toString() {
        return "Código: " + codigo + "\nNome: " + nome + "\nDescrição: " + descricao + "\nPreço: R$ " + String.format("%.2f", valor) + ".";
    }

    /**
     * Método de acesso ao atributo código do produto
     * @return o valor de código
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método de acesso ao atributo nome do produto
     * @return a string nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para definir um nome para o produto
     * @param nome recebe o nome de um produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para definir uma descrição para o produto
     * @param descricao recebe a descrição de um produto
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método de acesso ao atributo valor do produto
     * @return retorn o preço de um produto
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método de acesso para definir valor que corresponde ao preço de um produto
     * @param valor corresponde ao preço de um produto
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método de acesso para o atributo descriçao do produto
     * @return o valor do atributo descrição do produto
     */
    public String getDescricao() {
        return descricao;
    }

}
