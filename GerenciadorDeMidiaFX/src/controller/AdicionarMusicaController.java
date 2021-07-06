package controller;

import interfaces.IController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ManipulaMidias;
import model.Musica;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class AdicionarMusicaController implements IController {

    private ManipulaMidias listaMidias;
    private String caminho;
    private Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);

    @FXML
    private Spinner<Integer> textoMin;
    @FXML
    private Spinner<Integer> textoSec;
    @FXML
    private TextField textoTitulo;
    @FXML
    private TextField textoDescricao;
    @FXML
    private TextField textoIdioma;
    @FXML
    private TextField textoAutores;
    @FXML
    private TextField textoInterpretes;
    @FXML
    private TextField textoAno;
    @FXML
    private Button botaoCancelar;
    @FXML
    private Button botaoAdicionar;
    @FXML
    private ChoiceBox<String> choiceGenero;
    @FXML
    private TextField textoCaminhoPrompt;

    /**
     * Método de definição que é passa o ManipulaMídias para o controlador
     * @param m recebe uma instância da classe Manipuladora
     */
    public void setLista(ManipulaMidias m) {
        listaMidias = m;
    }

    /**
     * Método responsável por fechar a página de adição caso seja clicado no botão
     */
    @FXML
    public void cancelarClick() {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    /**
     * Método responsável por abrir a página de adição caso seja clicado no botão
     * O método também possui vários sets do atributo da música passando como parâmetro os fields da página
     */
    @FXML
    private void adicionarClick() {
        Stage stage = (Stage) botaoAdicionar.getScene().getWindow(); //pega o stage atual

        Musica minhaMusica = new Musica();
        try {
            minhaMusica.setCaminhoDoArquivo(caminho);
            minhaMusica.setGenero(choiceGenero.getValue());
            minhaMusica.setAno(textoAno.getText());
            minhaMusica.setDuracao(getDuracaoString(textoMin.getValue(), textoSec.getValue()));
            minhaMusica.setTitulo(textoTitulo.getText());
            minhaMusica.setDescricao(textoDescricao.getText());
            minhaMusica.setIdioma(textoIdioma.getText());
            minhaMusica.setAutores(textoIdioma.getText());
            minhaMusica.setInterpretes(textoIdioma.getText());
            minhaMusica.setAutores(textoAutores.getText());
            minhaMusica.setInterpretes(textoInterpretes.getText());
            listaMidias.adiciona(minhaMusica);
            stage.close(); //fecha o stage
        } catch (InputMismatchException | IllegalArgumentException | NullPointerException e) {
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        }
    }

    /**
     * Método que possui um fileChooser para que no field do caminho do arquivo seja escolhido o local da música
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
     * Método de acesso ao atributo duração
     * @param min define o parâmetro de minutos do método
     * @param sec define o parâmetro de seguntos do métod
     * @return
     */
    private String getDuracaoString(int min, int sec) {
        String duracaoMin = String.valueOf(min);
        String duracaoSec = String.valueOf(sec);
        return duracaoMin + " min " + duracaoSec + " s";
    }

    @FXML
    /**
     * Método que inicializa os gêneros de música existentes na interface
     */
    private void initialize() {
        choiceGenero.getItems().addAll("Rock", "Pop", "Samba", "Sertanejo", "Soul", "R&B", "Axé", "Funk", "Gospel", "MPB", "Reggae", "Pagode", "Forró", "Eletrônica");
        choiceGenero.setValue("Rock");

        textoMin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        textoSec.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
    }
}
