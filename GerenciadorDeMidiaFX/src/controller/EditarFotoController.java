package controller;

import interfaces.IController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Foto;
import model.ManipulaMidias;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditarFotoController implements IController {

    private ManipulaMidias listaMidias;
    private Foto fotoAntiga;
    private Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
    private String caminho;

    @FXML
    private TextField textoTitulo;
    @FXML
    private TextField textoDescricao;
    @FXML
    private DatePicker data;
    @FXML
    private TextField textoFotografo;
    @FXML
    private TextField textoPessoas;
    @FXML
    private TextField textoLocal;
    @FXML
    private TextField textoCaminhoPrompt;

    /**
     * Método para redefinir os campos de titulo, descrição, fotografo, pessoas, local, caminho e data
     * @param titulo titulo da Foto
     * @param descricao descrição da uma Foto
     * @param fotografo nome do fotógrafo que tirou a foto
     * @param pessoas nome das pessoas que participam da foto
     * @param local nome do local onde foi tirada a foto
     * @param caminho nome do caminho onde está o arquivo de foto
     * @param d recebe a data
     */
    public void setTextFields(String titulo, String descricao, String fotografo, String pessoas, String local, String caminho, String d) {
        textoTitulo.setText(titulo);
        textoDescricao.setText(descricao);
        textoFotografo.setText(fotografo);
        textoPessoas.setText(pessoas);
        textoLocal.setText(local);
        textoCaminhoPrompt.setText(caminho);
        data.setValue(getLocalDate(d));
    }

//    public void setData(DatePicker d) {
//        data.setValue(d.getValue());
//    }

    /**
     * Método que recebe a foto antiga e substitui por uma nova
     * @param f representa a nova Foto
     */
    public void setFotoAntiga(Foto f) {
        fotoAntiga = f;
    }

    /**
     *Método de definição que é passa o ManipulaMídias para o controlador
     * @param m recebe uma instância da classe Manipuladora
     */
    public void setLista(ManipulaMidias m) {
        listaMidias = m;
    }

    @FXML
    /**
     * Método para fechar a janela de edição de uma Foto
     */
    public void cancelarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow();
        stage.close();
    }

    @FXML
    /**
     * Método para realizar o click no botão de edição e abrir a janela permitindo mudanças nos campos de texto
     */
    private void editarClick() {
        Stage stage = (Stage) textoTitulo.getScene().getWindow(); //pega o stage atual

        try {
            Foto fotoNova = new Foto();
            fotoNova.setData(getData(data));
            fotoNova.setCaminhoDoArquivo(textoCaminhoPrompt.getText());
            fotoNova.setTitulo(textoTitulo.getText());
            fotoNova.setDescricao(textoDescricao.getText());
            fotoNova.setFotografo(textoFotografo.getText());
            fotoNova.setPessoas(textoPessoas.getText());
            fotoNova.setLocal(textoLocal.getText());
            listaMidias.alterar(fotoAntiga, fotoNova);
            stage.close();
        } catch (IllegalArgumentException | NullPointerException e) {
            dialogoAviso.setContentText(e.getMessage());
            dialogoAviso.showAndWait();
        }
    }

    /**
     *
     * Método que irá receber uma data por meio de um DataPicker e converte-lá para String
     * @param data recebida pelo DatePicker
     * @return retorna uma data em String no formato 'dd-MM-yyyy'
     */
    private String getData(DatePicker data) {
        String d;
        try {
            d = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (NullPointerException e) {
            throw new NullPointerException("A data não pode estar vazia.");
        }
        return d;
    }

    /**
     * Método que recebe uma data em String e depois converte-lá para DatePicker
     * @param d recebido em String
     * @return uma data no formato de DatePicker
     */
    private LocalDate getLocalDate(String d) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(d, formatter);
    }

    @FXML
    /**
     * Método que possui um fileChooser para que no field do caminho do arquivo seja escolhido o local da foto
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
}
