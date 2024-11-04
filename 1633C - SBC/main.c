#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct{
int tempo;
int ciclos;
}Processo;

int partition(Processo* array, int inicio, int fim){
    Processo pivo = array[fim];
    int i = inicio - 1;

    for(int j = inicio; j < fim; j++){
        if(array[j].tempo < pivo.tempo){
            i++;
            Processo tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
    }

    Processo tmp = array[i + 1];
    array[i + 1] = array[fim];
    array[fim] = array[i + 1];

    return i + 1;
}

void quicksort(Processo* array, int inicio, int fim){
    if(inicio < fim){
     int posicaoPivo = partition(array, inicio, fim);
     quicksort(array, posicaoPivo + 1, fim);
     quicksort(array, inicio, posicaoPivo - 1);
    }
}

int main(){

int numProcessos;
long contador;

while(scanf("%d", &numProcessos) != EOF){
 contador = 0;
 Processo processos[numProcessos];

 for(int i = 0; i < numProcessos; i++){
    scanf("%d %d", &processos[i].tempo, &processos[i].ciclos);
 }
 
 quicksort(processos, 0, numProcessos - 1);

 if(numProcessos != 1){
    for(int i = 1; i < numProcessos; i++){
        contador += processos[i - 1].ciclos;
    }
 }

 printf("%ld\n", contador);

}
  return 0;
}