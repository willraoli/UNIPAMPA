package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class ManipulaProduto implements Serializable{
    ArrayList<Produto> listaProdutos = new ArrayList<>();

    /**
     * Método para retornar uma lista de produtos
     * @return a lista de produtos
     */
    public ArrayList<Produto> getListaProdutos(){
        return listaProdutos;
    }

    /**
     * Método para adicionar um produto a lista de produtos
     * @param p é o objeto Produto
     */
    public void addProduto(Produto p){
        try{
            listaProdutos.add(p);
        }catch(Exception e){
            System.out.println("Não foi possível adicionar este produto.");
        }

    }

    public Produto getProduto(int codigo) {

            for (Produto p : listaProdutos) {
                if (p.getCodigo() == codigo) {
                    return p;
                }
            }

            return null;

    }

    /**
     * Método para remover um produto da lista de produtos
     * @param id é passado o id do produto como parâmetro para busca do produto
     */
    public void removeProduto(int id){
        try{
            Produto removeProd = null;
            for(Produto p: listaProdutos){
                if(p.getCodigo() == id){
                    removeProd = p;
                }
                listaProdutos.remove(removeProd);
            }
        }catch(Exception e){
            System.out.println("Não foi possível remover o produto.");
        }

    }

    /**
     * Método para realizar a gravação das informações dos Produto no arquivo 'produtosDatabase.bin'
     * @throws IOException
     */
    public void gravarProdutoArquivo() throws IOException {
        ObjectOutputStream output;

        output = new ObjectOutputStream(new FileOutputStream("produtosDatabase.bin"));
        output.writeObject(new ArrayList<Produto> (listaProdutos));
        output.close();
        System.out.println("Gravou os produtos");
}

    /**
     *Método para realizar a leitura do arquivo 'produtosDatabase.bin'
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void lerProdutos() throws IOException, ClassNotFoundException {
        ObjectInputStream ostream = new ObjectInputStream(new FileInputStream ("produtosDatabase.bin"));
        listaProdutos = (ArrayList<Produto>) ostream.readObject();
}

public void resetProdutos(){
        listaProdutos.clear();
}
}
