package GerenciaDeEstoque;
//teste
import java.util.Scanner;

public class Main {

    private ManipulaProduto produtos;
    private ManipulaNotaFiscal notasFiscais;
    private Scanner tc;

    public Main() {
        produtos = new ManipulaProduto();
        notasFiscais = new ManipulaNotaFiscal();

        ProdQuilo prodQuiloA = new ProdQuilo("Carne", "Bovina", 25, 50);
        ProdQuilo prodQuiloB = new ProdQuilo("Arroz", "Integral", 10, 5);
        ProdUnidade prodUnidadeA = new ProdUnidade("Smart TV", "50 polegadas", 1500, 10);
        ProdUnidade prodUnidadeB = new ProdUnidade("Ventilador", "Gira muito", 100, 1);
        NotaFiscal notaFiscal1 = new NotaFiscal("01/06/2001");
        NotaFiscal notaFiscal2 = new NotaFiscal("10/03/2021");
        produtos = new ManipulaProduto();
        notasFiscais = new ManipulaNotaFiscal();
        produtos.addProduto(prodQuiloA);
        produtos.addProduto(prodQuiloB);
        produtos.addProduto(prodUnidadeA);
        produtos.addProduto(prodUnidadeB);
        notasFiscais.addNotaFiscal(notaFiscal1);
        notasFiscais.addNotaFiscal(notaFiscal2);
    }

    public void menu() {
        tc = new Scanner(System.in);
        int op;

        do {
            System.out.println("Bem vindo ao Gerenciamento de Estoque");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Consultar produto");
            System.out.println("3. Alterar informações do produto");
            System.out.println("4. Excluir produto");
            System.out.println("5. Gerar uma nota fiscal");
            System.out.println("6. Consultar nota fiscal");
            System.out.println("7. Alterar nota fiscal");
            System.out.println("8. Consultar total vendido");
            System.out.println("9. Excluir Nota Fiscal");
            System.out.println("0. Sair");
            op = tc.nextInt();
            tc.nextLine();

            switch (op) {
            case 1:
                cadastrarProduto();
                break;

            case 2:
                consultarProduto();
                break;

            case 3:
                alterarProduto();
                break;

            case 4:
                excluirProduto();
                break;

            case 5:
                criarNotaFiscal();
                break;

            case 6:
                consultarNotaFiscal();
                break;

            case 7:
                alterarNotaFiscal();
                break;

            case 8:
                totalVendido();
                break;

            case 9:
                removerNotaFiscal();
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida");
                break;

            }

        } while (op != 0);
    }

    public void cadastrarProduto() {
        tc = new Scanner(System.in);
        String nomeProduto;
        String descricaoProduto;
        double valorProduto;
        double quantidadeQuilo;
        int quantidadeP = 0;
        String resp;
        boolean ok;

        System.out.println("[CADASTRO DE PRODUTO]");

        System.out.println("Informe o nome do produto: ");
        nomeProduto = tc.nextLine();

        System.out.println("Dê uma descrição para o produto: ");
        descricaoProduto = tc.nextLine();

        System.out.println("Informe o valor do produto: ");
        valorProduto = tc.nextDouble();
        tc.nextLine();

        System.out.println("Deseja cadastrar por Unidade ou Quilo");
        System.out.println("[Unidade]/[Quilo]: ");
        resp = tc.nextLine();

        if (resp.equalsIgnoreCase("unidade")) {
            do {
                try {
                    System.out.println("Informe a quantidade do produto: ");
                    quantidadeP = tc.nextInt();
                    ok = true;
                } catch (Exception IO) {
                    System.out.println("Informe, por favor, um inteiro!");
                    ok = false;
                } finally {
                    tc.nextLine();
                }
            } while (!ok);

            Produto pUnidade = new ProdUnidade(nomeProduto, descricaoProduto, valorProduto, quantidadeP);
            System.out.println(pUnidade.toString());
            produtos.addProduto(pUnidade);

        } else if (resp.equalsIgnoreCase("Quilo")) {
            System.out.println("Informe a quantidade do produto:");
            quantidadeQuilo = tc.nextDouble();
            tc.nextLine();

            Produto pQuilo = new ProdQuilo(nomeProduto, descricaoProduto, valorProduto, quantidadeQuilo);
            System.out.println(pQuilo.toString());
            produtos.addProduto(pQuilo);
        }
    }

    public void consultarProduto() {
        tc = new Scanner(System.in);
        int codInfo;

        System.out.println("[CONSULTAR PRODUTO]");
        do {
            System.out.println("Informe o código do produto que deseja consultar: ");
            codInfo = tc.nextInt();
            if (produtos.getProduto(codInfo) != null) {
                System.out.println(produtos.getProduto(codInfo).toString());
            }
        } while (produtos.getProduto(codInfo) == null);
    }

    public void alterarProduto() {
        tc = new Scanner(System.in);
        int codigo;
        String descricao, nome;
        double valor;
        double quantidade;

        System.out.println("[ALTERAR PRODUTO]");
        System.out.println(produtos.listaProdString());

        do {
            System.out.println("Informe o código do produto que deseja consultar:");
            codigo = tc.nextInt();
            tc.nextLine();
            if (produtos.getProduto(codigo) != null) {
                System.out.println(produtos.getProduto(codigo).toString());

                System.out.println("Para qual nome você quer alterar?");
                nome = tc.nextLine();

                System.out.println("Qual será a nova descrição?");
                descricao = tc.nextLine();

                System.out.println("Qual será o novo valor?");
                valor = tc.nextDouble();
                tc.nextLine();

                System.out.println("Qual será a nova quantidade?");
                quantidade = tc.nextDouble();
                tc.nextLine();

                produtos.getProduto(codigo).setNome(nome);
                produtos.getProduto(codigo).setDescricao(descricao);
                produtos.updatePreco(codigo, valor);
                produtos.updateQuantidade(codigo, quantidade);

                System.out.println(produtos.getProduto(codigo).toString());

            }
        } while (produtos.getProduto(codigo) == null);

    }

    public void excluirProduto() {
        tc = new Scanner(System.in);
        int codProduto;

        System.out.println("[EXCLUIR PRODUTO]");
        System.out.println(produtos.listaProdString());
        System.out.println("Informe o código do produto a ser excluído: ");
        codProduto = tc.nextInt();
        tc.nextLine();

        if (produtos.getProduto(codProduto) != null) {
            System.out.println(produtos.getProduto(codProduto).toString());
            System.out.println(produtos.getProduto(codProduto).getNome() + " foi excluído.");
            produtos.removeProduto(codProduto);
        }
    }

    public void criarNotaFiscal() {
        NotaFiscal nf;
        tc = new Scanner(System.in);
        int codInfo;
        double quantidadeVendida;
        String data = "";
        String resp;
        boolean ok;

        System.out.println("[CRIAÇÃO DA NOTA FISCAL]");
        nf = new NotaFiscal(data);

        System.out.println("Código da nota fiscal: " + nf.getCodigo());

        System.out.println("Qual a data da criação da nota fiscal (dd/MM/yyyy): ");
        data = tc.nextLine();
        nf.setData(data);

        System.out.println(produtos.listaProdString());

        do {
            do {
                System.out.println("Informe o código do produto que você deseja cadastrar na nota fiscal: ");
                codInfo = tc.nextInt();
                tc.nextLine();
                if (produtos.getProduto(codInfo) != null) {
                    System.out.println(produtos.getProduto(codInfo).toString());
                }
            } while (produtos.getProduto(codInfo) == null);

            do {
                System.out.println("Agora por favor, informe a quantidade vendida deste produto: ");
                quantidadeVendida = tc.nextDouble();
                tc.nextLine();

                Item itemADD = new Item(produtos.getProduto(codInfo), quantidadeVendida);
                ok = nf.addItem(itemADD);
                if (ok) {
                    System.out.println("Este produto foi adicionado a nota fiscal.");
                    notasFiscais.addNotaFiscal(nf);
                } else {
                    System.out.println("A quantidade informada está acima da em estoque.");
                }

            } while (!ok);

            System.out.println("Você quer adicionar mais um produto? [Sim/Não]");
            resp = tc.nextLine();

        } while (resp.equalsIgnoreCase("sim"));
    }

    public void consultarNotaFiscal() {
        tc = new Scanner(System.in);

        System.out.println("Insira o código da nota fiscal a ser consultada: ");
        int resp = tc.nextInt();

        System.out.println(notasFiscais.getNotaFiscal(resp).toString());
    }

    public void alterarNotaFiscal() {
        tc = new Scanner(System.in);
        int respInt, respProduto;
        NotaFiscal nf;
        Item i;
        double quantidadeVendida;
        do {
            System.out.println("Insira o código da nota fiscal a ser alterada: ");
            respInt = tc.nextInt();
            nf = notasFiscais.getNotaFiscal(respInt);

            if (nf != null) {
                System.out.println(nf.toString());
            } else {
                System.out.println("Código inválido");
            }
        } while (nf == null);

        System.out.println("O que você deseja fazer?");
        System.out.println("[1] Adicionar item");
        System.out.println("[2] Remover item");

        int respSwitch = tc.nextInt();
        tc.nextLine();

        switch (respSwitch) {
        case 1:
            do {
                System.out.println(produtos.listaProdString());
                System.out.println("Qual o código do produto que você deseja adicionar?");
                respProduto = tc.nextInt();
                System.out.println("Informe a quantidade vendida do produto: ");
                quantidadeVendida = tc.nextDouble();
                if (produtos.getProduto(respProduto) != null) {
                    System.out.println("Será alterado:");
                    System.out.println(produtos.getProduto(respProduto).toString());
                } else {
                    System.out.println("Código Inválido");
                }
            } while (produtos.getProduto(respProduto) == null);

            i = new Item(produtos.getProduto(respProduto), quantidadeVendida);
            notasFiscais.addItem(respInt, i);

            break;
        case 2:
            do {
                System.out.println(produtos.listaProdString());
                System.out.println("Qual o código do produto que você deseja remover?");
                respProduto = tc.nextInt();

                System.out.println("Será removido:");
                System.out.println(produtos.getProduto(respProduto).toString());
                i = nf.getItem(respProduto);
                if (i != null) {
                    nf.removeItem(i);
                    System.out.println("Item removido");
                } else {
                    System.out.println("Código inválido");
                }
            } while (i == null);
            break;
        default:
            System.out.println("Opção inválida.");
        }
    }

    public void totalVendido() {
        String data;
        tc = new Scanner(System.in);
        System.out.println("[TOTAL VENDIDO]");
        System.out.println("Digite a data em que deseja consultar o total vendido: ");
        data = tc.nextLine();

        System.out.printf("O total vendido é de: R$ %.2f." + "\n", notasFiscais.getValorTotalAllNotaFiscal(data));

    }

    public void removerNotaFiscal() {
        tc = new Scanner(System.in);
        int codNotaF;

        System.out.println("[EXCLUIR NOTA FISCAL]");
        System.out.println(notasFiscais.getAllNotaFiscalToString());

        do {
            System.out.println("Insira o código da nota fiscal a ser removida: ");
            codNotaF = tc.nextInt();

            if (notasFiscais.getNotaFiscal(codNotaF) != null) {
                notasFiscais.getNotaFiscal(codNotaF).removeTodosItens();
                notasFiscais.removeNotaFiscal(codNotaF);
                System.out.println("A nota fiscal " + codNotaF + " foi removida com sucesso.");
                break;
            } else {
                System.out.println("Código não existe!");
            }
        } while (notasFiscais.getNotaFiscal(codNotaF) == null);

    }

    public static void main(String[] args) {
        Main mn = new Main();
        mn.menu();
    }
}