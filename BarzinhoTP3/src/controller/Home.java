package controller;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class Home {

    //alerta
    private final Alert dialogoAviso = new Alert(Alert.AlertType.INFORMATION);

    //inicializa listas
    private ManipulaCliente listaClientes;
    private ManipulaConsumo listaConsumos;
    private ManipulaProduto listaProdutos;

    //reset
    @FXML private void resetAll() {
        listaClientes.resetCliente();
        listaProdutos.resetProdutos();
        listaConsumos.resetConsumos();
    }

    //set listas
    public void setListaClientes(ManipulaCliente m) {
        this.listaClientes = m;
    }
    public void setListaProdutos(ManipulaProduto m) {
        this.listaProdutos = m;
    }
    public void setListaConsumos(ManipulaConsumo m) {
        this.listaConsumos = m;
    }
    public void popularTabela() {
        tabelaClientes.getItems().addAll(listaClientes.getListaClientes());
        tabelaProdutos.getItems().addAll(listaProdutos.getListaProdutos());
        tabelaConsumo.getItems().addAll(listaConsumos.getListaConsumo());
    }

    //cliente
    @FXML private TableView<Cliente> tabelaClientes;
    @FXML private TextField nomeCliente;
    @FXML private TextField rgCliente;
    @FXML private TextField creditosCliente;
    @FXML private ChoiceBox<String> tipoEntrada;
    @FXML private TextField txtAddCreditos;
    @FXML private Label labelNomeCliente;
    @FXML private Label labelRg;
    @FXML private Label labelCreditos;
    @FXML private Label labelCategoria;

    //produto
    @FXML private TableView<Produto> tabelaProdutos;
    @FXML private TextField nomeProduto;
    @FXML private TextField descProduto;
    @FXML private TextField precoCusto;
    @FXML private TextField precoVenda;
    @FXML private TextField qtdProduto;
    @FXML private TextField txtRgCliente;
    @FXML private TextField txtQtdConsumo;
    @FXML private Label labelNomeProduto;
    @FXML private Label labelDescricaoProduto;
    @FXML private Label labelPrecoCusto;
    @FXML private Label labelPrecoVenda;
    @FXML private Label labelQtdProduto;

    //consumo
    @FXML private TableView<Consumo> tabelaConsumo;
    @FXML private Label labelCustoFesta;
    @FXML private Label labelLucroFesta;

    //colunas da tabelaConsumo
    private final TableColumn<Consumo, Integer> colCodigoProdConsumo = new TableColumn<>("Código do produto");
    private final TableColumn<Consumo, Integer> colCodigoConsumo = new TableColumn<>("Código do consumo");
    private final TableColumn<Consumo, String> colProdutoConsumo = new TableColumn<>("Produto");
    private final TableColumn<Consumo, Long> colRgConsumo = new TableColumn<>("RG");
    private final TableColumn<Consumo, Integer> colQtdConsumo = new TableColumn<>("Quantidade");

    //colunas da tabelaClientes
    private final TableColumn<Cliente, String> colNome = new TableColumn<>("Nome");
    private final TableColumn<Cliente, Long> colRg = new TableColumn<>("RG");
    private final TableColumn<Cliente, Float> colCredito = new TableColumn<>("Crédito (R$)");
    private final TableColumn<Cliente, String> colCategoria = new TableColumn<>("Categoria");

    //colunas da tabelaProdutos
    private final TableColumn<Produto, Integer> colCodigo = new TableColumn<>("Código");
    private final TableColumn<Produto, String> colNomeP = new TableColumn<>("Nome");
    private final TableColumn<Produto, String> colDescricao = new TableColumn<>("Descrição");
    private final TableColumn<Produto, Integer> colQuantidade = new TableColumn<>("Quantidade");
    private final TableColumn<Produto, Float> colPrecoCusto = new TableColumn<>("Preço de custo");
    private final TableColumn<Produto, Float> colPrecoVenda = new TableColumn<>("Preço de venda");

    @FXML
    private void atualizarListaClientes() {
        tabelaClientes.getItems().clear();
        tabelaClientes.getItems().addAll(listaClientes.getListaClientes());
    }

    @FXML
    private void atualizarListaProdutos() {
        tabelaProdutos.getItems().clear();
        tabelaProdutos.getItems().addAll(listaProdutos.getListaProdutos());
    }

    @FXML
    private void addClienteClick() {
        try {
            Cliente novoCliente = null;
            if (tipoEntrada.getValue().equals("Camarote")) novoCliente = new ClienteCamarote();
            if (tipoEntrada.getValue().equals("Pista")) novoCliente = new ClientePista();
            if (tipoEntrada.getValue().equals("VIP")) novoCliente = new ClienteVIP();

            if (novoCliente != null) {
                novoCliente.setNome(nomeCliente.getText());
                novoCliente.setRg(Long.parseLong(rgCliente.getText()), listaClientes);
                novoCliente.setCredito(Float.parseFloat(creditosCliente.getText()));
                novoCliente.setCategoria(tipoEntrada.getValue());
                listaClientes.addCliente(novoCliente);
            }
        } catch (NumberFormatException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Insira dados válidos.");
            System.out.println(e.getMessage());
            dialogoAviso.showAndWait();
        } catch (IllegalArgumentException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        }
        atualizarListaClientes();
    }

    @FXML
    private void addCreditosClick() {
        try {
        Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();
            listaClientes.addCreditos(clienteSelecionado.getRg(), Float.parseFloat(txtAddCreditos.getText()));
            atualizarListaClientes();
        } catch (NumberFormatException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Insira um valor válido.");
            dialogoAviso.showAndWait();
        } catch (IllegalArgumentException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        } catch (NullPointerException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Você deve selecionar um cliente na lista.");
            dialogoAviso.showAndWait();
        }
    }

    @FXML
    private void addProdutoClick() {
        try {
            Produto novoProduto = new Produto();
            novoProduto.setCodigo(listaProdutos.getListaProdutos().size() + 1);
            novoProduto.setNome(nomeProduto.getText());
            novoProduto.setDescricao(descProduto.getText());
            novoProduto.setQuantidade(Integer.parseInt(qtdProduto.getText()));
            novoProduto.setPrecoDeCusto(Float.parseFloat(precoCusto.getText()));
            novoProduto.setPrecoDeVenda(Float.parseFloat(precoVenda.getText()));
            listaProdutos.addProduto(novoProduto);
        } catch (NumberFormatException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Insira valores válidos.");
            dialogoAviso.showAndWait();
        } catch (Exception e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        }
        atualizarListaProdutos();
    }

    @FXML
    private void addConsumoClick() {
        try {
            //parsing para facilitar a leitura
            int parsedRg = Integer.parseInt(txtRgCliente.getText());
            int parsedQtd = Integer.parseInt(txtQtdConsumo.getText());

            Produto produtoSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();
            Cliente cliente = listaClientes.getClienteByRg(parsedRg);
            float consumoAtual = listaConsumos.getValorTotalConsumo(cliente);

            Consumo novoConsumo = new Consumo();
            novoConsumo.setProduto(produtoSelecionado);
            novoConsumo.setRgDoCliente(parsedRg);
            novoConsumo.setCodigoDoConsumo(listaConsumos.getListaConsumo().size() + 1);
            novoConsumo.setCodigoDoProduto(produtoSelecionado.getCodigo());
            novoConsumo.setQuantidade(parsedQtd);

            if (consumoAtual + produtoSelecionado.getPrecoDeVenda() <= cliente.getCredito() || cliente.getCategoria().equals("VIP")) {
                produtoSelecionado.subQuantidade(Integer.parseInt(txtQtdConsumo.getText()));
                listaConsumos.addConsumo(novoConsumo);
                dialogoAviso.setTitle("Informação");
                dialogoAviso.setContentText("O consumo foi adicionado.");
            } else {
                dialogoAviso.setContentText("Erro.");
            }
        } catch (NumberFormatException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Não foi possível adicionar o consumo. Verifique o RG do cliente e a quantidade a ser consumida.");
        } catch (NullPointerException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Não foi possível validar o consumo. Verifique o RG do cliente e o produto selecionado.");
        } catch (IllegalArgumentException e) {
                dialogoAviso.setTitle("Erro");
                dialogoAviso.setContentText(e.getMessage());
        } catch (Exception e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Insira valores válidos.");
            e.printStackTrace();
        }
        dialogoAviso.showAndWait();
    }

    @FXML
    private void pagarConsumoClick() {
        Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();
        try {
            listaConsumos.pagarConsumo(clienteSelecionado);
            dialogoAviso.setTitle("Pagar consumo");
            dialogoAviso.setContentText("O consumo foi pago com sucesso");
        } catch (Exception e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText(e.getMessage());
        }
        dialogoAviso.showAndWait();
    }

    @FXML
    private void atualizarLucroClick() {
        String lucroDaFesta = String.valueOf(listaConsumos.getLucroDaFesta(listaClientes));
        String custoDaFesta = String.valueOf(listaConsumos.getCustoDaFesta());

        labelLucroFesta.setText(lucroDaFesta);
        labelCustoFesta.setText(custoDaFesta);

        //FIXME: lugar errado só pra ver
        tabelaConsumo.getItems().clear();
        tabelaConsumo.getItems().addAll(listaConsumos.getListaConsumo());
    }

    @FXML
    private void showClientInfo() {
        try {
            Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();

            labelNomeCliente.setText(clienteSelecionado.getNome());
            labelRg.setText(String.valueOf(clienteSelecionado.getRg()));
            labelCreditos.setText(String.valueOf(clienteSelecionado.getCredito()));
            labelCategoria.setText(clienteSelecionado.getCategoria());

        } catch (Exception ignore) {
            System.err.println("Não selecionou nenhum cliente");
        }
    }

    @FXML
    private void showProductInfo() {
        try {
            Produto produtoSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem();

            labelNomeProduto.setText(produtoSelecionado.getNome());
            labelDescricaoProduto.setText(produtoSelecionado.getDescricao());
            labelPrecoVenda.setText(String.valueOf(produtoSelecionado.getPrecoDeVenda()));
            labelPrecoCusto.setText(String.valueOf(produtoSelecionado.getPrecoDeCusto()));
            labelQtdProduto.setText(String.valueOf(produtoSelecionado.getQuantidade()));

        } catch (Exception ignore) {
            System.err.println("Não selecionou nenhum produto");
        }
    }

    @FXML
    private void consultarConsumoClick() {
        try {
            Cliente clienteSelecionado = tabelaClientes.getSelectionModel().getSelectedItem();

            dialogoAviso.setContentText(getConsumoToString(clienteSelecionado));
            dialogoAviso.setTitle("Consumo");
            dialogoAviso.showAndWait();
        } catch (NullPointerException e) {
            dialogoAviso.setTitle("Erro");
            dialogoAviso.setContentText("Você deve selecionar um cliente.");
            dialogoAviso.showAndWait();
        }
    }

    private String getConsumoToString(Cliente c) {
        return "Cliente: " + c.getNome() + " [" + c.getCategoria().toUpperCase() + "]" +
                "\nProdutos: " + listaConsumos.getNomesDosProdutoConsumidos(c) +
                "\nValor total do consumo: " + listaConsumos.getValorTotalConsumo(c) + " reais.";
    }

    @FXML
    private void initialize() {
        //add colunas nas tabelas
        tabelaClientes.getColumns().addAll(colNome, colRg, colCredito, colCategoria);
        tabelaProdutos.getColumns().addAll(colCodigo, colNomeP, colDescricao, colQuantidade, colPrecoCusto, colPrecoVenda);
        tabelaConsumo.getColumns().addAll(colCodigoConsumo, colCodigoProdConsumo, colProdutoConsumo, colRgConsumo, colQtdConsumo);

        //colunas Cliente
        colNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        colRg.setCellValueFactory(data -> new SimpleLongProperty(data.getValue().getRg()).asObject());
        colCredito.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCredito()).asObject());
        colCategoria.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategoria()));

        //colunas Produto
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        colNomeP.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        colDescricao.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));
        colQuantidade.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantidade()).asObject());
        colPrecoCusto.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getPrecoDeCusto()).asObject());
        colPrecoVenda.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getPrecoDeVenda()).asObject());

        //colunas Consumo
        colCodigoProdConsumo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigoDoProduto()).asObject());
        colCodigoConsumo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigoDoConsumo()).asObject());
        colProdutoConsumo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProdutoConsumido().getNome()));
        colRgConsumo.setCellValueFactory(data -> new SimpleLongProperty(data.getValue().getRgDoCliente()).asObject());
        colQtdConsumo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantidade()).asObject());

        //adiciona valores ao tipo de entrada do cliente
        tipoEntrada.getItems().addAll("Pista", "Camarote", "VIP");
        tipoEntrada.getSelectionModel().selectFirst();
    }
}
