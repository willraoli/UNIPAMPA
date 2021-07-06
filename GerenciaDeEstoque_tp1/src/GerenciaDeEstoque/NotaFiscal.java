/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;

public class NotaFiscal {
    private final int codigo;
    private String data;
    private ArrayList<Item> relacaoItens = new ArrayList<>();
    private static int nrCodigo = 0;

    /**
     * Gera um construtor para NotaFiscal
     *
     * @param data corresponde à data
     */
    public NotaFiscal(String data) {
        codigo = 1 + nrCodigo;
        NotaFiscal.nrCodigo++;
        this.data = data;
    }

    /**
     * Retorna o Item de acordo com o código inserido
     * @param codigo Código do produto
     * @return Item i se positivo ou null caso o item não exista
     */
    public Item getItem(int codigo) {
        for (Item i : relacaoItens) {
            if (i.getP().getCodigo() == codigo) {
                return i;
            }
        }
        return null;
    }

    /**
     * Adiciona um item i à ArrayList relacaoItens
     * @param i Item a ser adicionado
     * @return true se a operação teve êxito
     */
    public boolean addItem(Item i) {
        if (i.getP().subQuantidade(i.getQuantidade())) {
            relacaoItens.add(i);
            return true;
        }
        return false;
    }

    /**
     * Remove um item i da ArrayList relacaoItens
     * @param i item a ser removido
     * @return true caso conseguiu remover, false caso não conseguiu
     */
    public boolean removeItem(Item i) {
        if (i.getP().addQuantidade(i.getQuantidade())) {
            return relacaoItens.remove(i);
        }
        return false;
    }

    /**
     * Remove todos os itens de relacaoItens
     * @return true caso relacaoItens tenha tamanho <= 0, falso caso tenha tamanho > 0
     */
    public boolean removeTodosItens() {
        Item listaParaRemover = null;
        for (Item i : relacaoItens) {
            listaParaRemover = i;
        }
        return removeItem(listaParaRemover);
    }


    /**
     * @return Retorna uma string contendo código, data, itens e valor total da nota fiscal
     */
    public String toString() {
        String itens = "Código: " + codigo + "\nData: " + data + "\n";

        for (Item i : relacaoItens) {
            itens += i.toString() + "\n";
        }
        itens += "Total da nota: R$ " + String.format("%.2f", getValorTotal());
        return itens;
    }

    /**
     * Recebe o código do objeto
     * @return valor do tipo int referente ao código
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Atualiza o valor de data do objeto
     * @param data referente à nova data a ser dada
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Recebe o valor total da relação de itens
     * @return o valor total da relação de itens ou 0 caso não haja valor
     */
    public double getValorTotal() {
        double valorTotal = 0;
        for (Item i : relacaoItens) {
            valorTotal += i.getValorTotal();
        }
        return valorTotal;
    }

    /**
     * Recebe a ArrayList relacaoItens
     * @return retorna a ArrayList relacaoItens referente ao objeto
     */
    public ArrayList<Item> getRelacaoItens() {
        return relacaoItens;
    }

    /**
     * Recebe a data do objeto
     * @return data referente ao objeto
     */
    public String getData() {
        return data;
    }

}
