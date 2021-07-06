package controller;

import interfaces.IController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ManipulaMidias;
import model.Musica;

import java.io.File;
import java.util.InputMismatchException;

public class EditarMusicaController implements IController {
    private Musica musicaAntiga;
    private ManipulaMidias listaMidias;
    private String caminho;
    private Musica musicaNova;
    private Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);


    @FXML
    private TextField textoTitulo;
    @FXML
    private TextField textoDescricao;
    @FXML
    private TextField textoIdioma;
    @FXML
    private TextField textoAutores;
    @FXML
    private Spinner<Integer> textoMin;
    @FXML
    private Spinner<Integer> textoSec;
    @FXML
    private TextField textoAno;
    @FXML
    private TextField textoInterpretes;
    @FXML
    private ChoiceBox<String> choiceGenero;
    @FXML
    private TextField textoCaminhoPrompt;

    /**
     * Método que redefine o titulo, descrição, gênero, autores, interpretes, duração, ano e caminho
     * @param titulo titulo da música
     * @param descricao descrição da música
     * @param genero gênero de música
     * @param idioma idioma que utilizado na música
     * @param autores nome dos autores da música
     * @param interpretes nome dos interpretes que participam da música
     * @param duracao duração da música
     * @param ano ano de lançamento da música
     * @param caminho nome do caminho/local onde a música se encontra
     */
    public void setTextFields(String titulo, String descricao, String genero, String idioma, String autores, String interpretes, String duracao, int ano, String caminho) {
        textoTitulo.setText(titulo);
        textoDescricao.setText(descricao);
        choiceGenero.setValue(genero);
        textoIdioma.setText(idioma);
        textoAutores.setText(autores);
        textoInterpretes.setText(interpretes);
        textoCaminhoPrompt.setText(caminho);
        textoAno.setText(String.valueOf(ano));
        textoMin.getValueFactory().setValue(getDuracaoSplit(duracao, 0));
        textoSec.getValueFactory().setValue(getDuracaoSplit(duracao, 2));
    }

    private int getDuracaoSplit(String d, int index) {
        String[] vetor = d.split(" ");
        String res = vetor[index];
        return Integer.parseInt(res);
    }

    /**
     * Método para definir o filme antigo que será editado para depois alterar pelo novo
     * @param m retorna a música antiga
     */
    public void setMusicaAntiga(Musica m) {
        musicaAntiga = m;
    }

    /**
     * Método de definição que é passa o ManipulaMídias para o controlador
     * @param midias recebe uma instância da classe Manipuladora
     */
    public void setLista(ManipulaMidias midias) {
        listaMidias = midias;
    }

    @FXML
    /**
     * Método responsável por fechar a página de edição de filme caso seja clicado no botão
     */
    public void cancelarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow();
        stage.close();
    }

    @FXML
    /**
     * Método responsável por abrir uma nova janela informando os dados antigos que serão feitos mudanças
     */
    private void editarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow(); //pega o stage atual
        try {
            musicaNova = new Musica();
            musicaNova.setCaminhoDoArquivo(textoCaminhoPrompt.getText());
            musicaNova.setDuracao(getDuracaoString(textoMin.getValue(), textoSec.getValue()));
            musicaNova.setAno(textoAno.getText());
            musicaNova.setTitulo(textoTitulo.getText());
            musicaNova.setDescricao(textoDescricao.getText());
            musicaNova.setGenero(choiceGenero.getValue());
            musicaNova.setIdioma(textoIdioma.getText());
            musicaNova.setAutores(textoAutores.getText());
            musicaNova.setInterpretes(textoInterpretes.getText());
            listaMidias.alterar(musicaAntiga, musicaNova);
            stage.close();
        } catch (InputMismatchException | IllegalArgumentException | NullPointerException e) {
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        }
    }

    @FXML
    /**
     * Método que possui um fileChooser para que no field do caminho do arquivo seja escolhido o local da música
     */
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
     * Método que recebe a duração da música passando os minutos e os segundos
     * @param min inteiro com o número de minutos de duração da música
     * @param sec inteiro com o número de segundos de duração da música
     * @return a em um dado só a duração contendo os minutos e segundos
     */
    private String getDuracaoString(int min, int sec) {
        String duracao = null;
        String duracaoMin = String.valueOf(min);
        String duracaoSec = String.valueOf(sec);
        duracao = duracaoMin + " min " + duracaoSec + " s";
        return duracao;
    }

    @FXML
    /**
     *Método que inicializa os possiveis gêneros de música para escolher
     */
    private void initialize() {
        choiceGenero.getItems().addAll("Rock", "Pop", "Samba", "Sertanejo", "Soul", "R&B", "Axé", "Funk", "Gospel", "MPB", "Reggae", "Pagode", "Forró", "Eletrônica");
        textoMin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        textoSec.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
    }
}
