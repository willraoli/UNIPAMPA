/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

public class ProdUnidade extends Produto {

    private int quantidade;
    
    /**
     * Cria um construtor de produto por unidade
     * @param nome recebe o nome produto
     * @param descricao recebe a descrição do produto
     * @param valor recebe o preço do produto
     * @param quantidade recebe a quantidade do produto
     */
    public ProdUnidade(String nome, String descricao, double valor, int quantidade) {
        super(nome, descricao, valor);
        this.quantidade = quantidade;
    }

    
    /**
     * Método subtrai a quantidade de um produto
     * @param quantidade recebe a quantidade a ser subtraída de um produto.
     * @return retorna um valor booleano true caso após a verificação seja possível subtrair a quantidade de produto desejada e irá
     *  retornar false caso não seja possível subtrair a quantidade de produto desejada.
     */
    public boolean subQuantidade(double quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }
    
  /**Método adiciona uma quantidade no produto
   * @param quantidade recebe a quantidade a ser adicionada no produto.
   * @return irá retornar um booleano true caso seja possível adicionar a quantidade desejada. 
   */
    public boolean addQuantidade(double quantidade) {
        this.quantidade += quantidade;
        return true;

    }
    /**
     * O método cria uma toString com informações do produto
     * @return uma string com os atributos do método toString() da superclasse, juntamente com a informação de quandidade do produto. 
     */
    public String toString(){
        return super.toString() + "\nQuantidade: " + quantidade + " unidades.\n";
    }
    /**Método de acesso ao atributo quantidade
     * @return o valor da quantidade do produto
     */
    public double getQuantidade() {
        return quantidade;
    }


    /**
     * O método define um valor de quantidade para o produto
     * @param q recebe um valor de quantidade para definir uma quantidade para o produto
     */
    @Override
    public void setQuantidade(double q) {
        int quantidadeInt;
        quantidadeInt = (int) q;
        this.quantidade = quantidadeInt;
    }

    
   

}
