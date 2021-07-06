package controller;


import interfaces.IController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Foto;
import model.ManipulaMidias;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class AdicionarFotoController implements IController {
    private ManipulaMidias listaMidiasF;
    private TableView tabela;
    private String caminho;
    private Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);

    @FXML
    private TextField textoTitulo;

    @FXML
    private TextField textoDescricao;

    @FXML
    private TextField textoFotografo;

    @FXML
    private TextField textoPessoas;

    @FXML
    private TextField textoLocal;

    @FXML
    private DatePicker data;

    @FXML
    private TextField textoCaminhoPrompt;

    /**
     * Método responsável por abrir a página de adição caso seja clicado no botão
     * O método também possui vários sets do atributo do filme passando como parâmetro os fields da página
     */
    @FXML
    private void adicionarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow(); //pega o stage atual
        Foto minhaFoto = new Foto();
        try {
            minhaFoto.setData(getDataString(data));
            minhaFoto.setTitulo(textoTitulo.getText());
            minhaFoto.setDescricao(textoDescricao.getText());
            minhaFoto.setFotografo(textoFotografo.getText());
            minhaFoto.setPessoas(textoPessoas.getText());
            minhaFoto.setLocal(textoLocal.getText());
            minhaFoto.setCaminhoDoArquivo(caminho);
            listaMidiasF.adiciona(minhaFoto);
            stage.close();
        } catch (IllegalArgumentException | NullPointerException e) {
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        }
    }

    /**
     *Método que possui um fileChooser para que no field do caminho do arquivo seja escolhido o local da foto
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
     * Método que irá receber uma data por meio de um DataPicker e converte-lá para String
     * @param data recebida pelo DatePicker
     * @return retorna uma data em String no formato 'dd-MM-yyyy'
     */
    private String getDataString(DatePicker data) {
        String d = null;
        try {
            d = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (NullPointerException e) {
            throw new NullPointerException("A data não pode estar vazia.");
        }
        return d;
    }

    /**
     *Método responsável por fechar a página de adição caso seja clicado no botão
     */
    @FXML
    public void cancelarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow();
        stage.close();
    }
    /**
     * Método de definição que é passa o ManipulaMídias para o controlador
     * @param m recebe uma instância da classe Manipuladora
     */
    @Override
    public void setLista(ManipulaMidias m) {
        listaMidiasF = m;
    }
}