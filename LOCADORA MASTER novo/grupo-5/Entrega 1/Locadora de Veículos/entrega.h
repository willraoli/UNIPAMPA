#ifndef ENTREGA_H_INCLUDED
#define ENTREGA_H_INCLUDED
#include <time.h>

void entrega();
void valorLocacao(char placaInf[8], float quilometragemInf, float dias);
float calculoDias(char placaInf[8], time_t dataE);
#endif // ENTREGA_H_INCLUDED
