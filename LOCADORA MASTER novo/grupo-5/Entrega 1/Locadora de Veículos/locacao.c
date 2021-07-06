#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>
#include "locacao.h"
#include "leituraArquivo.h"
#include "structs.h"
#include "busca.h"
#include <time.h>

extern struct Car car[1000];
struct locacoes locacoes[1000];

void locacao()
{
    
    char nome[50];
    long int cnh;
    char dia[10];
    char mes[10];
    char ano[10];
    char disponibilidade[] = "Disponivel";
    char *placaInf;
    static int j = 0;

    placaInf = malloc(TAMANHO_BUFFER);

    printf("Digite a cnh do cliente: ");
    scanf("%ld", &cnh);
    //Verifica se a cnh está errada ou ainda não foi cadastrada
    if (verificar_cnh(cnh) == 1)
    {
        printf("\nA cnh informada está errada ou não existe.\n");
        return;
    }
    //Verifica se o cliente já locou algum veículo para que ele não possa locar mais de um carro
    if (verificar_aluguel(cnh) == 1)
    { //verificar se o cliente já está locando um carro
        printf("\nEsse cliente já está locando um carro.\n");
        return;
    }
    //Mostra carros disponíveis conforme a pontuação da cnh informada
    mostrar_carros_cnh(cnh);

    printf("\nDigite a placa do veículo: ");
    scanf("%s", placaInf);

    /*if(verificar_placa(placaInf) == 1){
        printf("A placa informada não existe.");
        return;
    }*/

    printf("Digite o dia de retirada: ");
    fflush(stdin);
    scanf("%s", dia);
    //Tratamento de exceção para dias inválidos
    if (atoi(dia) < 1 || atoi(dia) > 31)
    {
        printf("\nDia inválido.\n");
        return;
    }

    printf("Digite o mês de retirada: ");
    fflush(stdin);
    scanf("%s", mes);

    //Tratamento de exceção para meses inválidos
    if (atoi(mes) < 1 || atoi(mes) > 12)
    {
        printf("\nMês inválido\n");
        return;
    }

    printf("Digite o ano de retirada: ");
    fflush(stdin);
    scanf("%s", ano);
    //Tratamento de exceção para anos inválidos
    if (atoi(ano) < 2021)
    {
        printf("\nAno inválido\n");
        return;
    }

    //For percorrendo o vetor da struct de carros para encontrar a placa e então locar um carro
    for (int i = 0; i <= 100; i++)
    {
        if (strcmp(car[i].placa, placaInf) == 0 && strstr(car[i].aluguel, "Disponivel"))
        { //verificar se o carro está disponível para aluguel
            strcpy(car[i].aluguel, "Indisponivel\n");
            printf("\nVeículo locado com sucesso!\n");
            printf("\nDados do veículo:\nMarca: %s.\nModelo: %s.\nAno: %d.\nQuilometragem: %.1f.\n \n", car[i].marca, car[i].modelo, car[i].ano, car[i].quilometragem);
            //Dados da locação são passados para a struct de locação
            strcpy(locacoes[j].nome, nome);
            locacoes[j].cnh = cnh;
            strcpy(clientes[get_cliente_id(cnh)].placa, placaInf);
            strcpy(locacoes[j].placa, car[i].placa);
            strcpy(locacoes[j].categoria, car[i].categoria);
            locacoes[j].quilometragem = car[i].quilometragem;
            strcpy(locacoes[j].dia, dia);
            strcpy(locacoes[j].mes, mes);
            strcpy(locacoes[j].ano, ano);
            strcpy(locacoes[j].aluguel, car[i].aluguel);
            j++;
            return;
        }
        //verifica a disponibilidade do carro, se estiver indisponivel, ele não pode ser locado
        if (strcmp(car[i].placa, placaInf) == 0 && strstr(car[i].aluguel, "Indisponivel"))
        {
            printf("\nErro: esse veículo está indisponível.\n");
            return;
        }
    }
}
