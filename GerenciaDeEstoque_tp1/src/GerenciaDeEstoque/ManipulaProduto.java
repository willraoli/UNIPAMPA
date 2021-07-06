/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;

//classe A
public class ManipulaProduto implements IProdutos {

    private ArrayList<Produto> listaProd = new ArrayList<>();

    /**
     * adiciona um produto p à listaProd
     * @param p Produto
     * @return true se conseguiu adicionar o produto
     */
    @Override
    public boolean addProduto(Produto p) {
        return listaProd.add(p);
    }

    /**
     * remove um produto de código x da listaProd
     * @param codigo Código do produto a ser removido.
     * @return true se conseguiu remover o produto
     */
    @Override
    public boolean removeProduto(int codigo) {
        Produto removProduto = null;
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                removProduto = prod;
            }
        }
        return listaProd.remove(removProduto);
    }

    /**
     * Recebe o produto de código x
     * @param codigo Código do produto a ser capturado.
     * @return Produto prod se o produto existe ou null caso não exista
     */
    @Override
    public Produto getProduto(int codigo) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                return prod;
            }
        }
        return null;
    }

    /**
     * Atualiza a quantidade do produto
     * @param codigo Código do produto a ser alterado.
     * @param nova Nova quantidade do produto.
     * @return true se conseguiu atualizar a quantidade, falso caso não conseguiu
     */
    @Override
    public boolean updateQuantidade(int codigo, double nova) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.setQuantidade(nova);
                return true;
            }
        }
        return false;
    }

    /**
     * Atualiza o preço do produto
     * @param codigo Código do produto a ser alterado.
     * @param novo Novo preço do produto.
     * @return true se conseguiu atualizar, false caso não conseguiu
     */
    @Override
    public boolean updatePreco(int codigo, double novo) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.setValor(novo);
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona uma certa quantidade ao produto
     * @param codigo Código do produto a ser alterado.
     * @param quantidade Quantidade a ser acrescentada.
     * @return true se conseguiu adicionar, false caso não conseguiu
     */
    @Override
    public boolean addQuantidade(int codigo, double quantidade) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.addQuantidade(quantidade);
                return true;
            }
        }
        return false;
    }

    /**
     * Subtrai uma certa quantidade ao produto
     * @param codigo Código do produto a ser alterado.
     * @param quantidade Quantidade a ser subtraída.
     * @return true se conseguiu subtrair, false caso não conseguiu
     */
    @Override
    public boolean subQuantidade(int codigo, double quantidade) {
        for (Produto prod : listaProd) {
            if (prod.getCodigo() == codigo) {
                prod.subQuantidade(quantidade);
                return true;
            }
        }
        return false;
    }

    /**
     * Recebe a lista de produtos em uma String
     * @return retorna uma String com a lista de produtos ou "" caso esteja vazia
     */
    public String listaProdString() {
        String s = "\n";
        for (Produto p : listaProd){
            s += p.toString() + "\n";
        }
        return s;
    }

}
