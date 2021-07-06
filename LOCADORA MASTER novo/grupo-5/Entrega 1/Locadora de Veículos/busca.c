#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "busca.h"
#include "registroCliente.h"
#include "structs.h"

void refresh_lista_carros() {
    //definições
    FILE *arquivo = fopen("locadora.txt", "r");
    int i = 0;

    //retorna o arquivo como uma array de char
    fseek(arquivo, 0, SEEK_END);
    long tamanho = ftell(arquivo);
    fseek(arquivo, 2, SEEK_SET);
    char *substring = malloc(tamanho + 1);
    fread(substring, 1, tamanho, arquivo);
    substring[tamanho] = 0;

    //token
    char *token;
    token = strtok(substring, SEPARADOR);

    while(token) {
        //malloc pq os chars[] podem ter tamanhos diferentes
        carros[i].placa = malloc(TAMANHO_BUFFER);
        carros[i].marca = malloc(TAMANHO_BUFFER);
        carros[i].modelo = malloc(TAMANHO_BUFFER);
        carros[i].aluguel = malloc(TAMANHO_BUFFER);

        //placa
        strcpy(carros[i].placa, token);
        token = strtok(NULL, SEPARADOR);

        //marca
        strcpy(carros[i].marca, token);
        token = strtok(NULL, SEPARADOR);

        //modelo
        strcpy(carros[i].modelo, token);
        token = strtok(NULL, SEPARADOR);

        //ano
        carros[i].ano = atoi(token);
        token = strtok(NULL, SEPARADOR);

        //quilometragem
        carros[i].quilometragem = atoi(token);
        token = strtok(NULL, SEPARADOR);

        //categoria
        carros[i].categoria = atoi(token);
        token = strtok(NULL, SEPARADOR);

        //aluguel
        strcpy(carros[i].aluguel, token);
        token = strtok(NULL, SEPARADOR);
        i++;
    }
    fclose(arquivo);
};

//Método responsável por pegar um determinado carro através do id(placa) retornando seu espaço na memória
struct carro get_carro(char *placa) {
    int index = -1;

    for(int i=0; i<NUMERO_DE_CARROS; i++) {
        if (strcmp(placa, carros[i].placa) == 0) {
            index = i;
            break;
        }
    }
    return carros[index];
}

//Método responsável por pegar um determinado carro através do id(placa) retornando sua posição no vetor
int get_carro_id(char *placa) {
    for(int i=0; i<NUMERO_DE_CARROS; i++) {
        if(strcmp(placa, carros[i].placa) == 0) {
            return i;
        }
    }
    return -1;
}

//Método responsável pelo aluguel de um carro recebendo como parâmetros a cnh e a placa
int alugar_carro(long int cnh_cliente, char *placa) {
    if(strcmp(get_carro(placa).aluguel, "Indisponivel") == 0) {
        printf("O carro %s não está disponível.\n", carros[get_carro_id(placa)].placa);
        return -1;
    }
    strcpy(carros[get_carro_id(placa)].aluguel, "Indisponivel");
    strcpy(clientes[get_cliente_id(cnh_cliente)].placa, placa); 
    printf("O carro com placa %s foi locado com sucesso.\n", placa);
    printf("LOCOU %s", clientes[get_cliente_id(cnh_cliente)].placa);
    return 0;
}

//Método responsável pela devolução de um carro recebendo como parâmetro a cnh do cliente e os quilômetros rodados
// e então é chamado o método addpontos que incrementa a pontuação do cliente
void entregar_carro(long int cnh_cliente, int km) { 
    printf("\nEntregando o carro %s.", get_cliente(cnh_cliente).placa);
    strcpy(clientes[get_cliente_id(cnh_cliente)].placa, "NA");
    add_pontos(cnh_cliente, km); 
}

//A partir da cnh do cliente é mostrado os carros que ele consegue alugar
//Sem utilizar como parâmetro a cnh
void mostrar_carros_disponiveis() {
    long int cnh;

    printf("Informe a CNH do cliente: \n");
    scanf("%d", &cnh);

    if(verificar_cnh(cnh) == 1) {
        printf("\nErro: informe uma CNH de um cliente existente.\n");
        return;
    }

    printf("\nO cliente %s pode alugar os seguintes carros:\n", get_cliente(cnh).nome);

    for(int i=0; i<NUMERO_DE_CARROS; i++){
        if(strstr(carros[i].aluguel, "Disponivel")) {
            if (get_cliente(cnh).pontos >= carros[i].categoria * 50) {
                printf("\n-------[%d]-------\nPlaca: %s\nMarca: %s\nModelo: %s\nCategoria: %d\nAno: %d\nQuilometragem: %.0fkm\n=================\n",
                    (i+1),
                    carros[i].placa,
                    carros[i].marca,
                    carros[i].modelo,
                    carros[i].categoria,
                    carros[i].ano,
                    carros[i].quilometragem);
                }
        }
    }
}

//A partir da cnh do cliente é mostrado os carros que ele consegue alugar
//Utilizando como parâmetro a cnh
void mostrar_carros_cnh(long int cnh){
    printf("\nO cliente %s pode alugar os seguintes carros:\n", get_cliente(cnh).nome);

    for(int i=0; i<NUMERO_DE_CARROS; i++){
        if(strstr(carros[i].aluguel, "Disponivel")) {
            if (get_cliente(cnh).pontos >= carros[i].categoria * 50) {
                printf("\n-------[%d]-------\nPlaca: %s\nMarca: %s\nModelo: %s\nCategoria: %d\nAno: %d\nQuilometragem: %.0fkm\n=================\n",
                    (i+1),
                    carros[i].placa,
                    carros[i].marca,
                    carros[i].modelo,
                    carros[i].categoria,
                    carros[i].ano,
                    carros[i].quilometragem);
                }
        }
    }

}

//Método responsável por checar se a placa informada existe
int verificar_placa(char *placa){
    for(int i =0; i < NUMERO_DE_CARROS; i++){
        if(strcmp(carros[get_carro_id(placa)].placa, placa) != 0){
            return 1;
        }
    }
    return -1;
}