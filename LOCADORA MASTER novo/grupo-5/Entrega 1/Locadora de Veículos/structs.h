#ifndef STRUCTS_H_INCLUDED
#define STRUCTS_H_INCLUDED

#include "registroCliente.h"
#include "busca.h"

struct Car
{
    char placa[8];
    char marca[21];
    char modelo[21];
    int ano;
    float quilometragem;
    char categoria[10];
    char aluguel[12];
};

struct cliente {
    char *nome;
    char *placa;
    long int cnh;
    int pontos;
    float total_km;
};

struct cliente clientes[MAX_CLIENTES];

struct carro {
    char *placa;
    char *marca;
    char *modelo;
    char *aluguel;
    int categoria;
    int ano;
    float quilometragem;
};

struct carro carros[NUMERO_DE_CARROS];

struct locacoes
{
    char nome[50];
    long int cnh;
    char categoria[20];
    char placa[8];
    char dia[3];
    char mes[3];
    char ano[5];
    float quilometragem;
    char aluguel[12];
};

#endif