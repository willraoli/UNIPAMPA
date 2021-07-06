package controller;

import interfaces.IController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Filme;
import model.ManipulaMidias;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class EditarFilmeController implements IController {

    private ManipulaMidias listaMidias;
    private Filme filmeAntigo;
    private String caminho;
    private Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);

    @FXML
    private TextField textoTitulo;
    @FXML
    private TextField textoDescricao;
    @FXML
    private ChoiceBox<String> choiceGenero;
    @FXML
    private TextField textoIdioma;
    @FXML
    private TextField textoDiretor;
    @FXML
    private TextField textoAtoresPrincipais;
    @FXML
    private Spinner<Integer> textoHora;
    @FXML
    private Spinner<Integer> textoMin;
    @FXML
    private TextField textoAno;
    @FXML
    private TextField textoCaminhoPrompt;


    /**
     * Método responsável por fechar a página de edição de filme caso seja clicado no botão
     */
    @FXML
    public void cancelarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow();
        stage.close();
    }
    /**
     * Método responsável por abrir a página de edição de filme caso seja clicado no botão
     * O método também possui vários sets do atributo do filme passando como parâmetro os fields da página
     */
    @FXML
    private void editarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow(); //pega o stage atual


        Filme filmeNovo = new Filme();
        try {
            filmeNovo.setCaminhoDoArquivo(textoCaminhoPrompt.getText());
            filmeNovo.setAno(textoAno.getText());
            filmeNovo.setDuracao(getDuracaoString(textoHora.getValue(), textoMin.getValue()));
            filmeNovo.setTitulo(textoTitulo.getText());
            filmeNovo.setDescricao(textoDescricao.getText());
            filmeNovo.setGenero(choiceGenero.getValue());
            filmeNovo.setIdioma(textoIdioma.getText());
            filmeNovo.setDiretor(textoDiretor.getText());
            filmeNovo.setAtoresPrincipais(textoAtoresPrincipais.getText());
            listaMidias.alterar(filmeAntigo, filmeNovo);
            stage.close();
        } catch (IllegalArgumentException | InputMismatchException | NullPointerException e){
            dialogoAviso.setContentText(e.getMessage());
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
     *
     * @param titulo corresponde ao título do filme
     * @param descricao corresponde a descrição do filme
     * @param genero corresponde ao genero do filme
     * @param idioma corresponde ao idioma do filme
     * @param diretor corresponde ao nome do diretor do filme
     * @param atores corresponde ao nome dos atores do filme
     * @param duracao corresponde a duração do filme
     * @param ano corresponde a duração do filme
     * @param caminho corresponde ao caminho do arquivo do filme
     */
    public void setTextFields(String titulo, String descricao, String genero, String idioma, String diretor, String atores, String duracao, int ano, String caminho) {
        textoTitulo.setText(titulo);
        textoDescricao.setText(descricao);
        choiceGenero.setValue(genero);
        textoIdioma.setText(idioma);
        textoDiretor.setText(diretor);
        textoAtoresPrincipais.setText(atores);
        textoAno.setText(String.valueOf(ano));
        textoCaminhoPrompt.setText(caminho);
        textoHora.getValueFactory().setValue(getDuracaoSplit(duracao, 0));
        textoMin.getValueFactory().setValue(getDuracaoSplit(duracao, 2));
    }

    private int getDuracaoSplit(String d, int index) {
        String[] vetor = d.split(" ");
        String res = vetor[index];
        return Integer.parseInt(res);
    }

    /**
     * Método para definir o filme antigo que será editado para depois alterar pelo novo
     * @param m retorna o filme antigo
     */
    public void setFilmeAntigo(Filme m) {
        filmeAntigo = m;
    }

    /**
     * Método de definição que é passa o ManipulaMídias para o controlador
     * @param m recebe uma instância da classe Manipuladora
     */
    public void setLista(ManipulaMidias m) {
        this.listaMidias = m;
    }

    /**
     * Parâmetro responsável por abrir o explorador de arquivos para escolher o local do filme
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
     * Método que define os tipos de gêneros que podem ser escolhidos no campo de definição do gênero
     */
    @FXML
    private void initialize() {
        choiceGenero.getItems().addAll("Ação", "Terror", "Comédia", "Suspense", "Romance", "Mistério", "Aventura", "Documentário", "Ficção Científica", "Musical");
        textoMin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        textoHora.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));
    }
}