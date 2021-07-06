#ifndef REGISTROCLIENTE_H_INCLUDED
#define REGISTROCLIENTE_H_INCLUDED

#define TAMANHO_BUFFER 1024
#define MAX_CLIENTES 100
#define SEPARADOR ";\n"

void refresh_lista_clientes();
struct cliente get_cliente(long int cnh);
int get_cliente_id(long int cnh);
void add_pontos(long int cnh, float km);
void add_cliente(char nome[161], long int cnh);
int registrar_cliente();
int verificar_cnh(long int cnh);
void show_cliente_info(long int cnh);
int verificar_aluguel(long int cnh);


#endif