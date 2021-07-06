package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipulaConsumo implements Serializable {
    private ArrayList<Consumo> listaConsumo = new ArrayList<>();

    /**
     * Método para adicionar um consumo a uma ArrayList de Consumos
     *
     * @param c um objeto de Consumo é passado como parâmetro
     */
    public void addConsumo(Consumo c) {
        try {
            listaConsumo.add(c);
        } catch (Exception e) {
            System.out.println("Não foi possível adicionar o consumo.");
        }
    }

    /**
     * Recebe o valor total de consumo de um cliente
     *
     * @param c é passado um objeto de Cliente
     * @return o valor do consumo total do cliente
     */
    public float getValorTotalConsumo(Cliente c) {
        try {
            float consumoTotal = 0;

            for (Consumo consumo : listaConsumo) {
                if (consumo.getRgDoCliente() == c.getRg()) {
                    consumoTotal += consumo.getValorDoConsumo();
                }
            }
            return consumoTotal;
        } catch (Exception e) {
            System.out.println("Não foi possível consultar o valor total do consumo.");
            return 0;
        }
    }

    /**
     * Método que adiciona os consumos de um cliente a uma ArrayList
     *
     * @param c é passado um objeto de Cliente
     * @return a array de consumos do cliente
     */
    public ArrayList<Consumo> getConsumosDoCliente(Cliente c) {
        try {
            ArrayList<Consumo> consumosDoCliente = new ArrayList<>();
            for (Consumo consumo : listaConsumo) {
                if (consumo.getRgDoCliente() == c.getRg()) {
                    consumosDoCliente.add(consumo);
                }
            }
            return consumosDoCliente;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não foi possível obter o consumo dos clientes.");
            return null;
        }
    }

    /**
     * Método que realiza o pagamento dos consumos adicionados na array de consumos de um cliente
     * e depois é chamado um método para remover os créditos do cliente e setar o boolean pago como true
     * indicando que foi efetuado o pagamento
     *
     * @param c é passado como um objeto de cliente
     */
    public void pagarConsumo(Cliente c) throws Exception {
        float precoTotalDoConsumo = 0;

        for (Consumo consumo : getConsumosDoCliente(c)) {
            if (!consumo.isPago()) {
                precoTotalDoConsumo += consumo.getValorDoConsumo();
                consumo.setPago(true);
            }
        }

        if (precoTotalDoConsumo == 0) {
            throw new Exception("O consumo já foi pago.");
        }

        c.subCredito(precoTotalDoConsumo);

        System.out.println("Pagou o consumo do cliente " + c.getNome());
        System.out.println("O crédito de " + c.getNome() + " agora é: " + c.getCredito());
    }

    /**
     * Neste método é feito uma busca na lista consumo e adicionando aos valores de consumo e custo total da festa
     *
     * @return retorna o lucro obtido da festa através da diferença do consumoTotal - custoTotal
     */
    public float getLucroDaFesta(ManipulaCliente manipulaCliente) {
        float consumoTotal = 0;
        float custoTotal = 0;

        for (Consumo consumo : listaConsumo) {
            consumoTotal += consumo.getValorDoConsumo();
            custoTotal += (consumo.getProdutoConsumido().getPrecoDeCusto() * consumo.getQuantidade());
        }
        for (Cliente c : manipulaCliente.getListaClientes()) {
            consumoTotal += c.getValorEntrada();
            System.out.println("VALOR ENTRADA PISTA: " + c.getValorEntrada());
        }

        System.out.println("CONSUMO: " + consumoTotal);
        System.out.println("CUSTO: " + custoTotal);

        return (consumoTotal - custoTotal);
    }

    /**
     * @return retorna o custo da festa
     */
    public float getCustoDaFesta() {
        float custoTotal = 0;
        for (Consumo c : listaConsumo) {
            custoTotal += (c.getProdutoConsumido().getPrecoDeCusto() * c.getQuantidade());
        }
        return custoTotal;
    }

    /**
     * Recebe o nome dos produtos que foram consumidos por um cliente
     *
     * @param c é passado como objeto de Cliente
     * @return retorna o nome dos produtos
     */
    public List<String> getNomesDosProdutoConsumidos(Cliente c) {
        try {
            List<String> nomesDosProdutos = new ArrayList<>();
            for (Consumo consumo : listaConsumo) {
                if (consumo.getRgDoCliente() == c.getRg()) {
                    nomesDosProdutos.add(consumo.getProdutoConsumido().getNome());
                }
            }

            return nomesDosProdutos;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não foi possível obter o nome dos produtos consumidos.");
            return null;
        }
    }

    /**
     * Remove um consumo
     *
     * @param numeroConsumo
     */
    void remove(int numeroConsumo) {
        try {
            listaConsumo.removeIf(c -> c.getCodigoDoConsumo() == numeroConsumo);
        } catch (Exception e) {
            System.out.println("Não foi possível localizar o número do consumo informado");
        }
    }

    /**
     * Método responsável por realizar a persistência de dados de consumo (consumos.bin)
     *
     * @throws IOException
     */
    public void gravarNoArquivo() throws IOException {
        ObjectOutputStream output;

        output = new ObjectOutputStream(new FileOutputStream("consumos.bin"));
        output.writeObject(new ArrayList<Consumo>(listaConsumo));
        output.close();
        System.out.println("gravou os consumos");
    }

    /**
     * Método para realizar a leitura do arquivo 'consumos.bin'
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void lerArquivo() throws IOException, ClassNotFoundException {
        ObjectInputStream ostream = new ObjectInputStream(new FileInputStream("consumos.bin"));
        listaConsumo = (ArrayList<Consumo>) ostream.readObject();
    }

    public void resetConsumos() {
        listaConsumo.clear();
    }

    public ArrayList<Consumo> getListaConsumo() {
        return listaConsumo;
    }
}