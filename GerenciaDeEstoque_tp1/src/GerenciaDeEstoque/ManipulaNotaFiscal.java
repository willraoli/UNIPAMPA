/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaDeEstoque;

import java.util.ArrayList;

public class ManipulaNotaFiscal implements INotasFiscais {

    ArrayList<NotaFiscal> notaF = new ArrayList<>();

    /**
     * Adiciona uma nota fiscal à ArrayList notaF
     * @param nf Nota fiscal a ser adicionada.
     * @return true se a nota for adicionada, false se não for adicionada
     */
    @Override
    public boolean addNotaFiscal(NotaFiscal nf) {
        return notaF.add(nf);
    }

    /**
     * Remove uma nota fiscal da ArrayList notaF
     * @param codigo Código da nota fiscal a ser removida.
     * @return true se a nota for removida, false se a nota não for removida
     */
    @Override
    public boolean removeNotaFiscal(int codigo) {
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                return notaF.remove(nota);
            }
        }
        return false;
    }

    /**
     * O método deve receber uma data como parâmetro e  irá percorrer a arrayList de notas fiscais verificando se elas possuem a mesma
     * data e checando também o código
     * @param date corresponde a data
     * @return após uma atribuição cumulativa, ele irá retornar o valor de totas as notas
     */
    public double getValorTotalAllNotaFiscal(String date) {
        double valorTotal = 0;
        for (NotaFiscal n : notaF) {
            if (n.getCodigo() != 0 && n.getData().equals(date)) {
                valorTotal += n.getValorTotal();
            }
        }
        return valorTotal;
    }

    public String getAllNotaFiscalToString(){
        String s = "";
        for (NotaFiscal n : notaF) {
            if(n.getCodigo() != 0) {
                s += n.toString() + "\n";
            }
        }
        return s;
    }

    /**
     * Recebe a nota fiscal de acordo com o código inserido
     * @param codigo Código da nota fiscal a ser capturada.
     * @return NotaFiscal notaFISCAL se a nota existe ou null caso não exista
     */
    @Override
    public NotaFiscal getNotaFiscal(int codigo) {
        NotaFiscal notaFISCAL = null;
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                notaFISCAL = nota;
            }
        }
        return notaFISCAL;
    }

    /**
     * Pega o valor total da nota fiscal com o código inserido
     * @param codigo Código da nota fiscal.
     * @return valor total da nota ou 0 caso não haja nota com aquele código
     */
    @Override
    public double getTotal(int codigo) {
        double valorNota = 0;
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                valorNota = nota.getValorTotal();
            }
        }
        return valorNota;
    }

    /**
     * Adiciona um item à nota fiscal de código x
     * @param codigo Código da nota fiscal na qual o item deve ser adicionado.
     * @param item Item a ser adicionado.
     * @return true se conseguiu adicionar, false se não conseguiu adicionar
     */
    @Override
    public boolean addItem(int codigo, Item item) {
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                return nota.addItem(item);
            }
        }
        return false;
    }

    /**
     * Remove um item da nota fiscal de código x
     * @param codigo Código da nota fiscal na qual o item deve ser removido.
     * @param item Item a ser removido.
     * @return true se conseguiu remover, false se não conseguiu remover
     */
    @Override
    public boolean removeItem(int codigo, Item item) {
        for (NotaFiscal nota : notaF) {
            if (nota.getCodigo() == codigo) {
                return nota.removeItem(item);
            }
        }
        return false;
    }


}
