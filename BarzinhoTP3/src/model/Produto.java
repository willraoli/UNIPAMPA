package model;

import java.io.Serializable;

public class Produto implements Serializable {
    private int codigo;
    private String descricao;
    private int quantidade;
    private float precoDeCusto;
    private float precoDeVenda;
    private String nome;

    public Produto(String nome, String descricao, int quantidade, float precoDeCusto, float precoDeVenda) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoDeCusto = precoDeCusto;
        this.precoDeVenda = precoDeVenda;
    }

    public Produto() {}

    /**
     * Este método é responsável por verificar se o estoque possuí a quantidade suficiente a ser removida
     * e caso n tiver é lançada uma exceção
     * @param quantidade inteiro que recebe a quantidade a ser removida
     */
    public void subQuantidade(int quantidade){
        if(this.quantidade >= quantidade){
            this.quantidade = this.quantidade - quantidade;
        }else{
            throw new IllegalArgumentException("Quantidade acima do estoque");
        }
    }

    /**
     * Método responsável por adicionar uma quantidade de produto no estoque
     * @param quantidade inteiro que recebe a quantidade a ser adicionada no estoque
     * @return
     */
    public boolean addQuantidade(int quantidade){
        this.quantidade = this.quantidade + quantidade;
        return true;
    }

    public void setCodigo(int codigo) {
        if(codigo <= 0){
            throw new IllegalArgumentException("Código de produto inválido!");
        }
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        if(nome.isBlank()){
            throw new IllegalArgumentException("O nome do produto não pode estar vazio");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade <=0){
            throw new IllegalArgumentException("Quantidade inválida");
        }
        this.quantidade = quantidade;
    }

    public float getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(float precoDeCusto) {
        if(precoDeCusto <= 0){
            throw new IllegalArgumentException("Preço de custo inválido");
        }
        this.precoDeCusto = precoDeCusto;
    }

    public float getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(float precoDeVenda) {
        if(precoDeVenda <= 0 || precoDeVenda < precoDeCusto){
            throw new IllegalArgumentException("Preço de venda inválido");
        }
        this.precoDeVenda = precoDeVenda;
    }
}
