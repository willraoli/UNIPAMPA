#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "registroCliente.h"
#include "structs.h"

void refresh_lista_clientes() {
    //definições
    FILE *arquivo = fopen("clientes.txt", "r");
    int i = 0;

    //retorna o arquivo como uma array de char
    fseek(arquivo, 0, SEEK_END);
    long tamanho = ftell(arquivo);
    fseek(arquivo, 0, SEEK_SET);
    char *substring = malloc(tamanho + 1);
    fread(substring, 1, tamanho, arquivo);
    substring[tamanho] = 0;

    //token
    char *token;
    token = strtok(substring, SEPARADOR);

    while(token) {
        //malloc pq o nome pode ter tamanhos diferentes
        clientes[i].nome = malloc(TAMANHO_BUFFER);
        clientes[i].placa = malloc(TAMANHO_BUFFER);

        //nome
        strcpy(clientes[i].nome, token);
        token = strtok(NULL, SEPARADOR);

        //cnh
        clientes[i].cnh = atoi(token);
        token = strtok(NULL, SEPARADOR);

        //placa
        strcpy(clientes[i].placa, token);
        token = strtok(NULL, SEPARADOR);

        //pontos
        clientes[i].pontos = atoi(token);
        token = strtok(NULL, SEPARADOR);

        //total de km rodados
        clientes[i].total_km = atoi(token);
        token = strtok(NULL, SEPARADOR);
        i++;
    }
    fclose(arquivo);
};

//retorna o cliente
struct cliente get_cliente(long int cnh) {
    int index = -1;

    for(int i=0; i<MAX_CLIENTES; i++) {
        if (clientes[i].cnh == cnh) {
            index = i;
            break;
        }
    }
    return clientes[index];
}

//retorna o id do cliente
int get_cliente_id(long int cnh) {
    for(int i=0; i<MAX_CLIENTES; i++) {
        if(clientes[i].cnh == cnh) {
            return i;
        }
    }
    return -1;
}

//adiciona pontos ao cliente com base na sua cnh
void add_pontos(long int cnh, float km) {
    for(int i=0; i<MAX_CLIENTES; i++) {
        if (clientes[i].cnh == cnh) {
            clientes[i].pontos += (km + clientes[i].total_km)/10;
            break;
        }
    }
}

//exibe as informações de um cliente
void show_cliente_info(long int cnh) {
    printf("\nNome: %s\nCNH: %ld\nPontos: %d\nPlaca: %s\n", clientes[get_cliente_id(cnh)].nome, clientes[get_cliente_id(cnh)].cnh, clientes[get_cliente_id(cnh)].pontos, clientes[get_cliente_id(cnh)].placa);
}

//Adiciona um novo cliente ao txt
void add_cliente(char nome[161], long int cnh) {
    FILE *arquivo = fopen("clientes.txt", "r+");
    char sufixo[12] = ";NA;50;0";

    char *array = malloc(TAMANHO_BUFFER);

    sprintf(array, "\n%s;%ld%s", nome, cnh, sufixo);
    fseek(arquivo, 0, SEEK_END);
    fwrite(array, sizeof(char), strlen(array), arquivo);
    fclose(arquivo);
}

//retorna -1 se a CNH está no banco de dados
//retorna 1 se a CNH não está no banco de dados
int verificar_cnh(long int cnh){
    for(int i =0; i < MAX_CLIENTES; i++){
        if(clientes[get_cliente_id(cnh)].cnh == cnh){
            return -1;
        }
    }
    return 1;
}

int registrar_cliente() {
    //definições
    char *nome = malloc(TAMANHO_BUFFER);
    long int cnh;

    //UI
    printf("Digite o nome do cliente: ");
    scanf("%s", nome);

    printf("Digite a CNH do cliente: ");
    scanf("%d", &cnh);

    if(verificar_cnh(cnh) == -1){
        printf("##################################");
        printf("\nErro: este cliente já existe.\n");
        printf("##################################");
        return -1;
    }
    
    //adiciona o cliente no .txt e atualiza a lista da clientes da struct
    add_cliente(nome, cnh);
    refresh_lista_clientes();

    //mostra as informações do cliente adicionado
    printf("\n###### Cliente adicionado! ######\n");
    printf("Nome: %s\nCNH: %ld\nTotal de pontos: %d\nPlaca do veículo locado: %s\nTotal de km rodados: %d\n",
        get_cliente(cnh).nome, 
        get_cliente(cnh).cnh,
        get_cliente(cnh).pontos,
        get_cliente(cnh).placa,
        get_cliente(cnh).total_km);
    printf("#################################\n");
    return 1;
}

//retorna 1 se o cliente está locando um carro
//retorna -1 se o cliente não está locando um carro
int verificar_aluguel(long int cnh) {
    for(int i=0; i<MAX_CLIENTES; i++){
        if(strcmp("NA", clientes[get_cliente_id(cnh)].placa) == 0){
            return -1;
        }
    }
    return 1;
}