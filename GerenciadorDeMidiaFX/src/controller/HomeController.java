package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Filme;
import model.Foto;
import model.ManipulaMidias;
import model.Musica;

import java.io.*;
import java.util.NoSuchElementException;

public class HomeController {

    private ManipulaMidias listaMidias;

    @FXML
    private ToggleButton botaoFotos;
    @FXML
    private ToggleButton botaoMusicas;
    @FXML
    private ToggleButton botaoFilmes;
    @FXML
    private TableView tabelaPrincipal;
    @FXML
    private Button botaoRemover;
    @FXML
    private Button botaoEditar;
    @FXML
    private Button botaoPesquisar;
    @FXML
    private TextField textoPesquisa;

    public void setListaMidias(ManipulaMidias lm) {
        this.listaMidias = lm;
    }

    @FXML
    private void botaoAdicionarClick() throws IOException {
        if (botaoFotos.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gerenciador/AdicionarFoto.fxml"));
            Parent root = loader.load();
            AdicionarFotoController controllerF = loader.getController(); //pegar controller de root
            controllerF.setLista(listaMidias);

            Stage stage = new Stage();
            stage.setTitle("Adicionar foto");
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }
        if (botaoMusicas.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gerenciador/AdicionarMusica.fxml"));
            Parent root = loader.load();
            AdicionarMusicaController controllerM = loader.getController(); //pegar controller de root
            controllerM.setLista(listaMidias);

            Stage stage = new Stage();
            stage.setTitle("Adicionar música");
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }
        if (botaoFilmes.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gerenciador/AdicionarFilme.fxml"));
            Parent root = loader.load();
            AdicionarFilmeController controllerFil = loader.getController();
            controllerFil.setLista(listaMidias);

            Stage stage = new Stage();
            stage.setTitle("Adicionar filme");
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }
    }

    @FXML
    private void botaoRemoverClick() {
        if (botaoFotos.isSelected()) {
            Alert alertaConfirmacao = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo remover esse item?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alertaConfirmacao.showAndWait();
            if (alertaConfirmacao.getResult() == ButtonType.YES) {
                listaMidias.remove((Foto) tabelaPrincipal.getSelectionModel().getSelectedItem());
                tabelaPrincipal.refresh();
            }
        }
        if (botaoMusicas.isSelected()) {
            Alert alertaConfirmacao = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo remover esse item?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alertaConfirmacao.showAndWait();
            if (alertaConfirmacao.getResult() == ButtonType.YES) {
                listaMidias.remove((Musica) tabelaPrincipal.getSelectionModel().getSelectedItem());
            }
        }
        if (botaoFilmes.isSelected()) {
            Alert alertaConfirmacao = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo remover esse item?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alertaConfirmacao.showAndWait();
            if (alertaConfirmacao.getResult() == ButtonType.YES) {
                listaMidias.remove((Filme) tabelaPrincipal.getSelectionModel().getSelectedItem());
            }
        }
    }

    @FXML
    private void botaoPesquisarClick() {
        try {
            if (botaoFilmes.isSelected()) {
                tabelaPrincipal.getItems().clear();
                tabelaPrincipal.getItems().addAll(listaMidias.consultarGeneroF(textoPesquisa.getText()));
            }
            if (botaoMusicas.isSelected()) {
                tabelaPrincipal.getItems().clear();
                tabelaPrincipal.getItems().addAll(listaMidias.consultarGeneroM(textoPesquisa.getText()));
            }
        } catch (NoSuchElementException e) {
            Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        }
    }

    @FXML
    private void botaoEditarClick() throws IOException {
        if (botaoFotos.isSelected()) {
            FXMLLoader loaderFotos = new FXMLLoader(getClass().getResource("/gerenciador/EditarFoto.fxml"));
            Parent root = loaderFotos.load();
            EditarFotoController controllerFoto = loaderFotos.getController();
            Foto itemSelecionado = (Foto) tabelaPrincipal.getSelectionModel().getSelectedItem();

            controllerFoto.setTextFields(
                    itemSelecionado.getTitulo(),
                    itemSelecionado.getDescricao(),
                    itemSelecionado.getFotografo(),
                    itemSelecionado.getPessoasNaFoto(),
                    itemSelecionado.getLocal(),
                    itemSelecionado.getCaminhoDoArquivo(),
                    itemSelecionado.getData()
            );
            controllerFoto.setFotoAntiga(itemSelecionado);
            controllerFoto.setLista(listaMidias);

            Stage stage = new Stage();
            stage.setTitle("Editar foto");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }
        if (botaoMusicas.isSelected()) {
            FXMLLoader loaderMusica = new FXMLLoader(getClass().getResource("/gerenciador/EditarMusica.fxml"));
            Parent root = loaderMusica.load();
            EditarMusicaController controllerMusica = loaderMusica.getController();
            Musica itemSelecionado = (Musica) tabelaPrincipal.getSelectionModel().getSelectedItem();

            controllerMusica.setTextFields(
                    itemSelecionado.getTitulo(),
                    itemSelecionado.getDescricao(),
                    itemSelecionado.getGenero(),
                    itemSelecionado.getIdioma(),
                    itemSelecionado.getAutores(),
                    itemSelecionado.getInterpretes(),
                    itemSelecionado.getDuracao(),
                    itemSelecionado.getAno(),
                    itemSelecionado.getCaminhoDoArquivo()
            );
            controllerMusica.setMusicaAntiga(itemSelecionado);
            controllerMusica.setLista(listaMidias);

            Stage stageNovo = new Stage();
            stageNovo.setTitle("Editar música");
            stageNovo.setScene(new Scene(root, 500, 500));
            stageNovo.show();
        }
        if (botaoFilmes.isSelected()) {
            FXMLLoader loaderFilmes = new FXMLLoader(getClass().getResource("/gerenciador/EditarFilme.fxml"));
            Parent root = loaderFilmes.load();
            EditarFilmeController controllerFilme = loaderFilmes.getController();
            Filme itemSelecionado = (Filme) tabelaPrincipal.getSelectionModel().getSelectedItem();

            controllerFilme.setTextFields(itemSelecionado.getTitulo(),
                    itemSelecionado.getDescricao(),
                    itemSelecionado.getGenero(),
                    itemSelecionado.getIdioma(),
                    itemSelecionado.getDiretor(),
                    itemSelecionado.getAtoresPrincipais(),
                    itemSelecionado.getDuracao(),
                    itemSelecionado.getAno(),
                    itemSelecionado.getCaminhoDoArquivo()
            );
            controllerFilme.setFilmeAntigo(itemSelecionado);
            controllerFilme.setLista(listaMidias);

            Stage stageNovo = new Stage();
            stageNovo.setTitle("Editar filme");
            stageNovo.setScene(new Scene(root, 500, 500));
            stageNovo.show();
        }
    }

    @FXML
    private void botaoFotosClick() {
        botaoFotos.setSelected(true);
        botaoPesquisar.setDisable(true);
        popularTableView();
    }

    @FXML
    private void botaoMusicasClick() {
        botaoMusicas.setSelected(true);
        botaoPesquisar.setDisable(false);
        popularTableView();
    }

    @FXML
    private void botaoFilmesClick() {
        botaoFilmes.setSelected(true);
        botaoPesquisar.setDisable(false);
        popularTableView();
    }

    public void popularTableView() {

        //limpar a tabela antes de popular(caso ela já esteja populada)
        tabelaPrincipal.getItems().clear();
        tabelaPrincipal.getColumns().clear();

        //setar colunas
        if (botaoFotos.isSelected()) {
            popularFotos(listaMidias);
        }
        if (botaoMusicas.isSelected()) {
            popularMusicas();
        }
        if (botaoFilmes.isSelected()) {
            popularFilmes();
        }
    }

    public void popularFotos(ManipulaMidias m) {
        TableColumn<Foto, String> colTituloF = new TableColumn<>("Título");
        TableColumn<Foto, String> colDescricaoF = new TableColumn<>("Descrição");
        TableColumn<Foto, String> colFotografo = new TableColumn<>("Fotógrafo");
        TableColumn<Foto, String> colPessoasNaFoto = new TableColumn<>("Pessoas");
        TableColumn<Foto, String> colLocalF = new TableColumn<>("Local");
        TableColumn<Foto, String> colDataF = new TableColumn<>("Data");
        TableColumn<Foto, String> colCaminhoF = new TableColumn<>("Caminho");

        //limpar tabela
        tabelaPrincipal.getItems().clear();
        tabelaPrincipal.getColumns().clear();

        //popular células da tabela
        colTituloF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));
        colDescricaoF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));
        colFotografo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFotografo()));
        colPessoasNaFoto.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPessoasNaFoto()));
        colLocalF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLocal()));
        colDataF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getData()));
        colCaminhoF.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCaminhoDoArquivo()));

        //adicionar colunas à tabela
        tabelaPrincipal.getColumns().addAll(colTituloF, colDescricaoF, colFotografo, colPessoasNaFoto, colLocalF, colDataF, colCaminhoF);

        //adicionar itens às células
        tabelaPrincipal.getItems().addAll(m.getFotos());
    }

    public void popularMusicas() {
        TableColumn<Musica, String> colTituloM = new TableColumn<>("Título");
        TableColumn<Musica, String> colDescricaoM = new TableColumn<>("Descrição");
        TableColumn<Musica, String> colGeneroM = new TableColumn<>("Gênero");
        TableColumn<Musica, String> colIdiomaM = new TableColumn<>("Idioma");
        TableColumn<Musica, String> colAutoresM = new TableColumn<>("Autores");
        TableColumn<Musica, String> colInterpretesM = new TableColumn<>("Intérpretes");
        TableColumn<Musica, String> colDuracaoM = new TableColumn<>("Duração");
        TableColumn<Musica, Integer> colAnoM = new TableColumn<>("Ano");
        TableColumn<Musica, String> colCaminhoM = new TableColumn<>("Caminho");

        //limpar tabela
        tabelaPrincipal.getItems().clear();
        tabelaPrincipal.getColumns().clear();

        //popular células da tabela
        colTituloM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));
        colDescricaoM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));
        colGeneroM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGenero()));
        colIdiomaM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdioma()));
        colAutoresM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAutores()));
        colInterpretesM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getInterpretes()));
        colDuracaoM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDuracao()));
        colAnoM.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getAno()).asObject());
        colCaminhoM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCaminhoDoArquivo()));

        tabelaPrincipal.getColumns().addAll(colTituloM, colDescricaoM, colGeneroM, colIdiomaM, colAutoresM, colInterpretesM, colDuracaoM, colAnoM, colCaminhoM);
        tabelaPrincipal.getItems().addAll(listaMidias.getMusicas());
    }

    public void popularFilmes() {
        TableColumn<Filme, String> colTituloFil = new TableColumn<>("Título");
        TableColumn<Filme, String> colDescricaoFil = new TableColumn<>("Descrição");
        TableColumn<Filme, String> colGeneroFil = new TableColumn<>("Gênero");
        TableColumn<Filme, String> colIdiomaFil = new TableColumn<>("Idioma");
        TableColumn<Filme, String> colDiretorFil = new TableColumn<>("Diretor");
        TableColumn<Filme, String> colAtoresPrincipais = new TableColumn<>("Atores principais");
        TableColumn<Filme, String> colDuracaoFil = new TableColumn<>("Duração");
        TableColumn<Filme, Integer> colAnoFil = new TableColumn<>("Ano");
        TableColumn<Filme, String> colCaminhoFil = new TableColumn<>("Caminho");

        tabelaPrincipal.getItems().clear();
        tabelaPrincipal.getColumns().clear();

        //popular células da tabela
        colTituloFil.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));
        colDescricaoFil.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));
        colGeneroFil.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGenero()));
        colIdiomaFil.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdioma()));
        colDiretorFil.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDiretor()));
        colAtoresPrincipais.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAtoresPrincipais()));
        colDuracaoFil.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDuracao()));
        colAnoFil.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getAno()).asObject());
        colCaminhoFil.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCaminhoDoArquivo()));

        tabelaPrincipal.getColumns().addAll(colTituloFil, colDescricaoFil, colGeneroFil, colIdiomaFil, colDiretorFil, colAtoresPrincipais, colDuracaoFil, colAnoFil, colCaminhoFil);
        tabelaPrincipal.getItems().addAll(listaMidias.getFilmes());
    }

    @FXML
    private void initialize() {
        botaoRemover.disableProperty().bind(Bindings.isEmpty(tabelaPrincipal.getSelectionModel().getSelectedItems())); //desabilita o botão remover se nada estiver selecionado
        botaoEditar.disableProperty().bind(Bindings.isEmpty(tabelaPrincipal.getSelectionModel().getSelectedItems())); //desabilita o botão remover se nada estiver selecionado
        botaoPesquisar.setDisable(true);
    }
}