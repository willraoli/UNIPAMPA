#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "leituraArquivo.h"
#include "structs.h"

//cria��o de um struct contendo as informacoes de um veiculo

struct Car car[1000];



char *token;
const char sep[2] = ";";
int cont;

void contInicia()
{
    cont = 0;
}

//Método responsável por separar as informações do carro passando para a struct
void separaInfo(char linha[150])
{

    token = strtok(linha, sep);
    strcpy(car[cont].placa, token);

    token = strtok(NULL, sep);
    strcpy(car[cont].marca, token);

    token = strtok(NULL, sep);
    strcpy(car[cont].modelo, token);

    token = strtok(NULL, sep);
    car[cont].ano = strtol(token, NULL, 10);

    token = strtok(NULL, sep);
    car[cont].quilometragem = strtof(token, NULL);

    token = strtok(NULL, sep);
    strcpy(car[cont].categoria, token);

    token = strtok(NULL, sep);
    strcpy(car[cont].aluguel, token);

    token = strtok(NULL, sep);

    /*printf("placa %s\n", car[cont].placa);
        printf("marca %s\n", car[cont].marca);
        printf("modelo %s\n", car[cont].modelo);
        printf("ano %d\n", car[cont].ano);
        printf("quilometragem %ld\n", car[cont].quilometragem);
        printf("categoria %s\n", car[cont].categoria);
        printf("situacao %s\n", car[cont].aluguel);*/

    cont++;
}

//Método responsável por percorrer a struct de carro imprimindo os dados do veículo
void relatorio()
{

    int quantidade = 6;
    for (int i = 0; i < quantidade; i++)
    {
        printf("|Placa: %s\n", car[i].placa);
        printf("|Marca: %s\n", car[i].marca);
        printf("|Modelo: %s\n", car[i].modelo);
        printf("|Ano: %d\n", car[i].ano);
        printf("|Quilometragem: %.1f\n", car[i].quilometragem);
        printf("|Categoria: %s\n", car[i].categoria);
        printf("|Situacao: %s\n", car[i].aluguel);
    }
}

//Método responsável por abrir o txt e então chamar o método separarInfo()
void aberturaArq()
{

    char linha[150];
    char *token;
    const char separator[2] = ";";
    FILE *arquivo;
    arquivo = fopen("locadora.txt", "r");
    fgets(linha, 150, arquivo);
    token = strtok(linha, separator);

    while (!feof(arquivo))
    {
        fgets(linha, 150, arquivo);
        separaInfo(linha);
    }
    fclose(arquivo);
}

//Método responsável por percorrer a struct de carros procurando uma placa e então imprimindo os dados da placa desejada
void infoPlaca(char placaInfo[8])
{
    for (int i = 0; i < 100; i++)
    {
        if (strcmp(car[i].placa, placaInfo) == 0)
        {
            printf("|Placa: %s\n", car[i].placa);
            printf("|Marca: %s\n", car[i].marca);
            printf("|Modelo: %s\n", car[i].modelo);
            printf("|Ano: %d\n", car[i].ano);
            printf("|Quilometragem: %f\n", car[i].quilometragem);
            printf("|Categoria: %s\n", car[i].categoria);
            printf("|Situacao: %s\n", car[i].aluguel);
        }
    }
}
