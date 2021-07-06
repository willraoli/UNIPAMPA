package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class ManipulaCliente implements Serializable {
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    /**
     * Método para adicionar um cliente à ArrayList listaClientes
     *
     * @param cli refere-se ao cliente a ser adicionada
     */
    public void addCliente(Cliente cli) {
        try {
            listaClientes.add(cli);
        } catch (Exception e) {
            System.out.println("Não foi possível adicionar um Cliente");
        }

    }

    /**
     * @return Retorna a lista dos clientes da ArrayList
     */
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Método para fornecer um cliente da listaClientes
     *
     * @param rg é o rg que será buscado como parâmetro
     * @return retorna um cliente
     */
    public Cliente getClienteByRg(int rg) {

        for (Cliente c : listaClientes) {
            if (c.getRg() == rg) {
                return c;
            }
        }
        return null;
    }

    /**
     * Método para remover um cliente da lista clientes
     *
     * @param rg é passado como parâmetro para localizar o cliente
     */
    public void removeCli(long rg) {
        try {
            Cliente removeCli = null;
            for (Cliente cli : listaClientes) {
                if (cli.getRg() == rg) {
                    removeCli = cli;
                }
            }
            listaClientes.remove(removeCli);
        } catch (Exception e) {
            System.out.println("Não foi possível remover o cliente");
        }

    }

    /**
     * Método para adicionar créditos para um Cliente
     *
     * @param rg           é passado como parâmetro para localizar o cliente
     * @param valorCredito é valor de créditos que irão ser adicionados a um cliente
     */
    public void addCreditos(long rg, float valorCredito) {
        for (Cliente cli : listaClientes) {
            if (cli.getRg() == rg) {
                if (valorCredito <= 0) {
                    throw new IllegalArgumentException("O crédito adicionado não pode ser menor ou igual a 0");
                }
                cli.setCredito(cli.getCredito() + valorCredito);
            }
        }
    }

    /**
     * Método para passar as informações do Produto
     *
     * @return uma string com informações
     */
    public String listaProdString() {
        String espace = "\n";
        for (Cliente cli : listaClientes) {
            espace += cli.toString() + "\n";
        }
        return espace;
    }

    /**
     * Método para gravar as informações dos Clientes no arquivo 'clienteDatabase.bin'
     *
     * @throws IOException foi utilizado, pois pode não haver arquivo no 'clienteDatabase.bin'
     */
    public void gravarClienteArquivo() throws IOException {
        ObjectOutputStream output;

        output = new ObjectOutputStream(new FileOutputStream("clienteDatabase.bin"));
        output.writeObject(new ArrayList<Cliente>(listaClientes));
        output.close();

        System.out.println("gravou os clientes");

    }

    /**
     * Método para realizar a leitura do arquivo 'clienteDatabase.bin'
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void lerClientes() throws IOException, ClassNotFoundException {
        ObjectInputStream ostream = new ObjectInputStream(new FileInputStream("clienteDatabase.bin"));
        listaClientes = (ArrayList<Cliente>) ostream.readObject();

    }

    public void resetCliente() {
        listaClientes.clear();
    }
}
