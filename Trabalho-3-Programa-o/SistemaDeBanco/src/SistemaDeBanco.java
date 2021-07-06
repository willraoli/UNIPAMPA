import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class SistemaDeBanco {
    public static void main(String[] args) throws Exception {
        Menu.homePage();

        Scanner in = new Scanner(System.in);
        int escolha = in.nextInt();

        switch (escolha) {
            case 1:
                Menu.abrirConta();
                break;
            case 2:
                Menu.encerrarConta();
                break;
            case 3:
                Menu.depositarDinheiro();
                break;
            case 4:
                Menu.sacarDinheiro();
                break;
            case 5:
                Menu.verificarSaldo();
                break;
            case 6:
                Menu.emitirExtrato();
                break;

        }
        in.close();
    }

    static void escreverNoArquivo(String arquivo, String arg) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true)); // true = append
            bw.write(arg + "\n");
            bw.close();
        } catch (IOException e) {
        }
    }
}