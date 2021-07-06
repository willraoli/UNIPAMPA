package gerenciador;

import controller.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ManipulaMidias;

import java.io.IOException;
import java.io.Serializable;

public class Main extends Application implements Serializable {

    private final ManipulaMidias listaMidias = new ManipulaMidias();

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        HomeController controller = loader.getController();

        //faz o controlador reconhecer listaMidias
        controller.setListaMidias(listaMidias);

        primaryStage.setTitle("Gerenciador de Mídia FX");
        primaryStage.setScene(new Scene(root, 910, 400));
        primaryStage.show();

        //ler o database.bin
        try {
            listaMidias.lerArquivo();
        } catch (IOException | ClassNotFoundException e) {
//            Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
//            dialogoAviso.setTitle("Aviso");
//            dialogoAviso.setHeaderText("Erro durante a manipulação do banco de dados");
//            dialogoAviso.setContentText("Banco de dados não encontrado. Um novo banco de dados será criado.");
//            dialogoAviso.showAndWait();
            listaMidias.gravarNoArquivo();
        }

        //popula a tabela ao abrir
        controller.popularTableView();

        //gravar ao sair
        primaryStage.setOnCloseRequest(e -> {
            try {
                listaMidias.gravarNoArquivo();
            } catch (IOException i) {
                i.printStackTrace();
            }
        });

        //atualizar a tabela automaticamente
//        primaryStage.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//            try {
//                controller.popularTableView();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}