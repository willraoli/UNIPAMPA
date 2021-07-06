#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "entrega.h"
#include "structs.h"
#include "locacao.h"
#include "registroCliente.h"
#include <ctype.h>
#include <time.h>

extern struct locacoes locacoes[1000];
extern struct Car car[1000];

char diaL[10];
char mesL[10];
char anoL[10];


void entrega()
{

    long int cnh;
    char placaInfo[8];
    char dia[10];
    char mes[10];
    char ano[10];

    float quilometragemInfo;
//Valores para cada categoria
    printf("-------------------------------------------------------------------------------\n");
    printf("Valores para cada categoria:\n");
    printf("Categoria 1: Valor diária = R$10,00 / Valor a cada 10 quilômetros = R$5,00\n");
    printf("Categoria 2: Valor diária = R$20,00 / Valor a cada 10 quilômetros = R$10,00\n");
    printf("Categoria 3: Valor diária = R$30,00 / Valor a cada 10 quilômetros = R$15,00\n");
    printf("-------------------------------------------------------------------------------\n");

    printf("Digite a cnh do cliente: ");
    scanf("%ld", &cnh);

    //tratamento de exceção para verificar a cnh
    if(verificar_cnh(cnh) == 1){
        printf("\nErro: a CNH informada está errada ou não existe.\n");
        return;
    }

    //tratamento de exceção verificando se o cliente possui ou não um carro locado
    if(verificar_aluguel(cnh) == -1){
        printf("\nErro: cliente não está locando nenhum carro.\n");
        return;
    }

    //Mostra as informações dos clientes
    show_cliente_info(cnh);

    struct tm dataEntrega;
    time_t dataE;

    printf("Digite o dia de entrega: ");
    fflush(stdin);
    scanf("%s", dia);

    //tratamento de exceção para dia
    if (atoi(dia) < 1 || atoi(dia) > 32) {
        printf("\nDia inválido. \n");
        return;
    }

    printf("Digite o mês de entrega: ");
    fflush(stdin);
    scanf("%s", mes);

    //tratamento de exceção para mês
    if (atoi(mes) < 1 || atoi(mes) > 12){
        printf("\nMês inválido. \n");
        return;
    }

    printf("Digite o ano de entrega: ");
    fflush(stdin);
    scanf("%s", ano);

    //tratamento de exceção para ano
    if(atoi(ano) < 1){
        printf("\nAno inválido.\n");
        return;
    }

//conversão da data para o formato tm (time)
    dataEntrega.tm_mday = atoi(dia);
    dataEntrega.tm_mon = atoi(mes) - 1;
    dataEntrega.tm_year = atoi(ano) - 1900;
    dataEntrega.tm_hour = 0;
    dataEntrega.tm_min = 0;
    dataEntrega.tm_sec = 0;
    dataEntrega.tm_isdst = 0;

    dataE = mktime(&dataEntrega);

    printf("\nO número de dias que o veículo foi alugado: %.0f\n", calculoDias(clientes[get_cliente_id(cnh)].placa, dataE));

    printf("Informe a quantidade de quilômetros percorrida: ");
    scanf("%f", &quilometragemInfo);

    for (int i = 0; i < 7; i++)
    {
        if (strcmp(locacoes[i].placa, clientes[get_cliente_id(cnh)].placa) == 0)
        {
            for (int i = 0; i < 7; i++)
            {
                if (strcmp(car[i].placa, clientes[get_cliente_id(cnh)].placa) == 0)
                {
                    strcpy(car[i].aluguel, "Disponivel\n");

                    valorLocacao(clientes[get_cliente_id(cnh)].placa, quilometragemInfo, calculoDias(clientes[get_cliente_id(cnh)].placa, dataE));

                    add_pontos(cnh, quilometragemInfo);
                    printf("\nO veiculo foi entregue com sucesso!\n");
                    show_cliente_info(cnh);
                    
                }
            }
        }
    }
}

//pega a inforção da placa informada, passando por dois "for's" para verificar se há um carro com esta placa
void valorLocacao(char placaInf[8], float quilometragemInf, float dias){
    float valorTotal;
    for (int i = 0; i < 100; i++)
    {
        if (strcmp(locacoes[i].placa, placaInf) == 0)
        {
            for (int i = 0; i < 100; i++)
            {
                if (strcmp(car[i].placa, placaInf) == 0)
                {
                    //são calculados os valores com base na categoria do veiculo
                    if (strcmp(car[i].categoria, "1") == 0)
                    {
                        valorTotal = (quilometragemInf / 10.0f) * 5.0f + (dias * 10.0f);
                        car[i].quilometragem = car[i].quilometragem + quilometragemInf;
                    }
                    else if (strcmp(car[i].categoria, "2") == 0)
                    {
                        valorTotal = (quilometragemInf / 10.0f) * 10.0f + (dias * 20.0f);
                        car[i].quilometragem = car[i].quilometragem + quilometragemInf;
                    }
                    else if (strcmp(car[i].categoria, "3") == 0)
                    {
                        valorTotal = (quilometragemInf / 10.0f) * 15.0f + (dias * 30.0f);
                        car[i].quilometragem = car[i].quilometragem + quilometragemInf;
                    }
                }
            }
            printf("Valor total da locacao do veiculo: R$%.2f\n", valorTotal);
        }
    }
}


float calculoDias(char placaInf[8], time_t dataE){
    double diff_t;
    float dias = 0;
    
    for (int i = 0; i < NUMERO_DE_CARROS; i++)
    {
        if (strcmp(locacoes[i].placa, placaInf) == 0)
        {
            struct tm dataLocacao;
            time_t dataL;
            //conversão da data de locacao para o formato tm (time)
            dataLocacao.tm_mday = atoi(locacoes[i].dia);
            dataLocacao.tm_mon = atoi(locacoes[i].mes) - 1;
            dataLocacao.tm_year = atoi(locacoes[i].ano) - 1900;
            dataLocacao.tm_hour = 0;
            dataLocacao.tm_min = 0;
            dataLocacao.tm_sec = 0;
            dataLocacao.tm_isdst = 0;

            dataL = mktime(&dataLocacao);
            //São pegas as duas datas: a data da locacao e entrega para realização da diferença em segundos delas
            diff_t = difftime(dataE, dataL);

            //Conversão dos segundos em dias
            dias = diff_t / 86400;
        }
    }
    return dias;
}