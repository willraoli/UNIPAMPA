#include <stdio.h>
#include <stdlib.h>
#include "leituraArquivo.h"
#include "registroCliente.h"
#include "locacao.h"
#include "entrega.h"
#include "busca.h"
#include <windows.h>

//Criacao do menu com as diferentes funcionalidades para locacao de veiculos
void menu()
{

    int op;

    do
    {
        printf("\nBem-vindo a Locadora de Veiculos\n");
        printf("#################################\n");
        printf("#  1. Registrar Cliente         #\n");
        printf("#  2. Locar Veiculo             #\n");
        printf("#  3. Entregar Veiculo          #\n");
        printf("#  4. Busca de um Veiculo       #\n");
        printf("#  5. Relatorio                 #\n");
        printf("#  6. Sair                      #\n");
        printf("#################################\n");
        scanf("%d", &op);

        switch (op)
        {
        case 1:
            printf("Voce selecionou o Registro de Cliente\n\n");
            registrar_cliente();

            break;

        case 2:
            printf("Voce selecionou a Locacao de veiculo\n\n");
            locacao();
            break;

        case 3:
            printf("Voce selecionou a Entrega de veiculo\n\n");
            entrega();
            break;

        case 4:
            printf("Voce selecionou a Busca de um veiculo\n\n");
            mostrar_carros_disponiveis();
            break;

        case 5:
            printf("-----Relatorio-----\n\n");
            relatorio();
            printf("-------------------\n");
            break;

        case 6:
            printf("Saindo\n\n");
            break;

        default:
            printf("Opcao invalida!\n\n");
        }

    } while (op != 6);
}

int main()
{
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);
    aberturaArq();
    contInicia();
    refresh_lista_carros();
    refresh_lista_clientes();
    menu();

}
