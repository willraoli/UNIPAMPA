package controller;

import interfaces.IController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Filme;
import model.ManipulaMidias;

import java.io.File;
import java.util.InputMismatchException;

public class AdicionarFilmeController implements IController {

    private ManipulaMidias listaMidias;
    private Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
    private String caminho;

    @FXML private Button botaoCancelar;
    @FXML private Button botaoAdicionar;
    @FXML private TextField textoTitulo;
    @FXML private TextField textoDescricao;
    @FXML private ChoiceBox<String> choiceGenero;
    @FXML private TextField textoIdioma;
    @FXML private TextField textoDiretor;
    @FXML private TextField textoAtoresPrincipais;
    @FXML private TextField textoAno;
    @FXML private TextField textoCaminhoPrompt;
    @FXML private Spinner<Integer> textoHora;
    @FXML private Spinner<Integer> textoMin;

    /**
     * Método responsável por fechar a página de adição de um file caso seja clicado no botão
     */
    @FXML
    public void cancelarClick() {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    /**
     * Método responsável por abrir a página de adição de um filme caso seja clicado no botão
     * O método também possui vários sets do atributo do filme passando como parâmetro os fields da página
     */
    @FXML
    private void adicionarClick(){
        Stage stage = (Stage) botaoAdicionar.getScene().getWindow(); //pega o stage atual

        Filme meuFilme = new Filme();

        try {
            meuFilme.setTitulo(textoTitulo.getText());
            meuFilme.setDescricao(textoDescricao.getText());
            meuFilme.setGenero(choiceGenero.getValue());
            meuFilme.setIdioma(textoIdioma.getText());
            meuFilme.setCaminhoDoArquivo(textoCaminhoPrompt.getText());
            meuFilme.setDiretor(textoDiretor.getText());
            meuFilme.setAtoresPrincipais(textoAtoresPrincipais.getText());
            meuFilme.setDuracao(getDuracaoString(textoHora.getValue(), textoMin.getValue()));
            meuFilme.setAno(textoAno.getText());
            listaMidias.adiciona(meuFilme);
            stage.close();
        } catch (IllegalArgumentException e){
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        } catch (InputMismatchException i) {
            dialogoAviso.setContentText("Insira números inteiros no campo ano.");
            dialogoAviso.showAndWait();
        } catch (NullPointerException e) {
            dialogoAviso.setContentText("O caminho do arquivo não foi preenchido.");
            dialogoAviso.showAndWait();
        }
    }

    private String getDuracaoString(int hora, int min) {
        String duracao = null;
        String duracaoMin = String.valueOf(hora);
        String duracaoSec = String.valueOf(min);
        duracao = duracaoMin + " h " + duracaoSec + " min";
        return duracao;
    }

    /**
     * Método que possui um fileChooser para que no field do caminho do arquivo seja escolhido o local do filme
     */
    @FXML
    public void escolherLocal() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            caminho = file.getPath();
            textoCaminhoPrompt.setText(caminho);
        } catch (NullPointerException ignored) { }
    }

    /**
     * Método de definição que é passa o ManipulaMídias para o controlador
     * @param m recebe uma instância da classe Manipuladora
     */
    public void setLista(ManipulaMidias m){
        listaMidias = m;
    }

    /**
     * Método que define os tipos de gêneros que podem ser escolhidos no campo de definição do gênero
     */
    @FXML
    private void initialize() {
        choiceGenero.setValue("Ação");
        choiceGenero.getItems().addAll("Ação", "Terror", "Comédia", "Suspense", "Romance", "Mistério", "Aventura", "Documentário", "Ficção Científica", "Musical");
        textoMin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        textoHora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));
    }
}
