import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ManipulaCliente;
import model.ManipulaConsumo;
import model.ManipulaProduto;
import controller.Home;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private final ManipulaConsumo mc = new ManipulaConsumo();
    private final ManipulaProduto mp = new ManipulaProduto();
    private final ManipulaCliente mcli = new ManipulaCliente();

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/view/NovoHome.fxml")));
        Parent root = loader.load();

        Home controller = loader.getController();

        //ler o db
        try {
            mc.lerArquivo();
            mcli.lerClientes();
            mp.lerProdutos();
        } catch (IOException | ClassNotFoundException ignore) {
            mc.gravarNoArquivo();
            mcli.gravarClienteArquivo();
            mp.gravarProdutoArquivo();
        }

        //seta as listas
        controller.setListaConsumos(mc);
        controller.setListaClientes(mcli);
        controller.setListaProdutos(mp);
        controller.popularTabela();

        primaryStage.setTitle("Gerenciador");
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();

        //gravar ao sair
        primaryStage.setOnCloseRequest(e -> {
            try {
                mc.gravarNoArquivo();
                mcli.gravarClienteArquivo();
                mp.gravarProdutoArquivo();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
