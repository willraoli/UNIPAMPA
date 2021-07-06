import java.util.Scanner;

public class SistemaDeBanco {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("===INÍCIO===");
        System.out.println("O que você deseja fazer?");
        System.out.println("[1] Abrir uma conta");
        System.out.println("[2] Encerrar uma conta");
        System.out.println("[3] Depositar dinheiro");
        System.out.println("[4] Sacar dinheiro");
        System.out.println("[5] Verificar saldo");
        System.out.println("[6] Emitir extrato");

        int escolha = in.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("===[1] Abrir uma conta===");
                break;
            case 2:
                System.out.println("===[2] Encerrar uma conta===");
                break;
            case 3:
                System.out.println("===[3] Depositar dinheiro===");
                break;
            case 4:
                System.out.println("===[4] Sacar dinheiro===");
                break;
            case 5:
                System.out.println("===[5] Verificar o saldo===");
                break;
            case 6:
                System.out.println("===[6] Emitir extrato===");
                break;

        }
        in.close();

    }
}
