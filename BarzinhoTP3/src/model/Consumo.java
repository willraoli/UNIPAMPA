package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Consumo implements Serializable {

    private int codigoDoConsumo;
    private long rgDoCliente;
    private int codigoDoProduto;
    private int quantidade;
    private Produto p;
    private boolean pago;

    public Consumo(Produto produto, long rgDoCliente, int codigoDoProduto, int quantidade) {
        this.p = produto;
        this.rgDoCliente = rgDoCliente;
        this.codigoDoProduto = codigoDoProduto;
        this.quantidade = quantidade;
    }

    public Consumo() {}

    public void setCodigoDoConsumo(int codigo){
//        if(codigoDoConsumo < 10){
//            throw new IllegalArgumentException("Código do consumo inválido!");
//        }
        this.codigoDoConsumo = codigo;
    }

    public void setRgDoCliente(long rg) { this.rgDoCliente = rg; }

    public void setCodigoDoProduto(int p) { this.codigoDoProduto = p; }

    public void setProduto(Produto p) { this.p = p; }

    public int getCodigoDoConsumo() {
        return codigoDoConsumo;
    }

    public float getValorDoConsumo() { return this.p.getPrecoDeVenda() * this.quantidade; }

    public Produto getProdutoConsumido() { return this.p; }

    public long getRgDoCliente() {
        return rgDoCliente;
    }

    public int getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade <= 0){
            throw new IllegalArgumentException("Quantidade de consumo inválida");
        }
        this.quantidade = quantidade;
    }

    public void pagarConsumo(ManipulaConsumo c){
        c.remove(codigoDoConsumo);
    }

    public void setPago(boolean pago){
        this.pago = pago;
    }

    public boolean isPago(){
        return pago;
    }
}
