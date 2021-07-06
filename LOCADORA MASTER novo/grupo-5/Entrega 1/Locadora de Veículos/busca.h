#ifndef BUSCA_H_INCLUDED
#define BUSCA_H_INCLUDED

#define TAMANHO_BUFFER 1024
#define NUMERO_DE_CARROS 6
#define SEPARADOR ";\n"

void refresh_lista_carros();
struct carro get_carro(char *placa);
int get_carro_id(char *placa);
int alugar_carro(long int cnh_cliente, char *placa);
void entregar_carro(long int cnh_cliente, int km);
void mostrar_carros_disponiveis();
void mostrar_carros_cnh(long int cnh);
int verificar_placa(char *placa);

#endif