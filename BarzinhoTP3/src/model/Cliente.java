package model;

import java.io.Serializable;

public abstract class Cliente implements Serializable {
    private long rg;
    private String nome;
    private float credito;
    private String categoria;
    private float valorEntrada = 20;

    public Cliente(long rg, String nome, float credito, String categoria) {
        this.rg = rg;
        this.nome = nome;
        this.credito = credito;
        this.categoria = categoria;
    }

    public Cliente() {}

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getCategoria() {
        return categoria;
    }

    public String toString() {
        return "RG: " + rg + "Nome: " + nome + "Credito(s): " + credito;
    }

    public long getRg() {
        return rg;
    }

    public abstract float getValorEntrada();

    public float getEntrada() {
        return valorEntrada;
    }

    public void setRg(long rg, ManipulaCliente listaClientes) {
        if (rg <= 0) {
            throw new NumberFormatException("O Rg não pode estar vazio");
        }
        for (Cliente m : listaClientes.getListaClientes()) {
            if (m.getRg() == rg) {
                throw new IllegalArgumentException("Já existe um cliente cadastrado com esse RG.");
            }
        }
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isBlank()){
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
        this.nome = nome;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        if(credito <= 0){
            throw new IllegalArgumentException("O crédito não pode ser um número negativo ou zero");
        }
        this.credito = credito;
    }

    /**
     * Este método é responsável por subtrair créditos do saldo do cliente. Caso a quantidade for maior que o saldo
     * será lançada uma exceção.
     *
     * @param credito valor de ponto flutuante que recebe a quantidade de crédito a ser removida do saldo
     */
    public void subCredito(float credito) {
        if (credito > this.credito) {
            throw new IllegalArgumentException("Créditos insuficientes");
        } else {
            this.credito = this.credito - credito;
        }
    }


}
