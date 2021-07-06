/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

public class ProdQuilo extends Produto {

    private double quantidade;

    /**
     * @param nome       refere-se ao nome do Produto
     * @param descricao  refere-se à descrição do produto
     * @param valor      refere-se ao preço do produto
     * @param quantidade refere-se à quantidade do produto
     */
    public ProdQuilo(String nome, String descricao, double valor, double quantidade) {
        super(nome, descricao, valor);
        this.quantidade = quantidade;
    }

    /**
     * Subtrai a quantidade do produto
     * @param quantidade refere-se à quantidade a ser subtraída
     * @return true se conseguiu subtrair, false se não conseguiu
     */
    public boolean subQuantidade(double quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }

    /**
     * Adiciona uma certa quantidade ao produto
     * @param quantidade refere-se à quantidade a ser adicionada
     */
    public boolean addQuantidade(double quantidade) {
        this.quantidade += quantidade;
        return true;

    }

    /**
     * @return uma String contendo o toString() da superclasse + o valor da quantidade em kg
     */
    public String toString() {
        return super.toString() + "\nQuantidade:  " + quantidade + " kg.\n";

    }

    /**
     * Recebe o valor da quantidade do produto
     * @return quantidade referente ao objeto
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * Atualiza o valor da quantidade do produto
     * @param q refere-se à quantidade nova a ser atribuída ao objeto
     */
    @Override
    public void setQuantidade(double q) {
        this.quantidade = q;
    }

}
