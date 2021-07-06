/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;


public class Item {
    private Produto p;
    private double quantidade;

    public Item(Produto p, double quantidade){
        this.p = p;
        this.quantidade = quantidade;
    }

    public Item(Produto p){
        this.p = p;
    }

    public double getValorTotal(){
        return p.getValor() * quantidade;
    }
    public String toString(){
        return "\n\tNome: " + p.getNome() + "\n\tQuantidade: " + quantidade + "\n\tPreço: " + p.getValor() + "\n\tR$: " + String.format("%.2f", getValorTotal()) + "\n";
    }

    public Produto getP() {
        return p;
    }


    public void setP(Produto p) {
        this.p = p;
    }


    public double getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
