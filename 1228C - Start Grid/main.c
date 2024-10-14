  #include <stdio.h>
  #include <stdlib.h>
  #include <string.h>
    
    int main(){

    int numCompetidor = 0;
    int ultrapassagens = 0;
    int k = 0;
    int arrayUltrapassagens[3];
    char linha[50];
    
    //Le o numero e o proximo caractere, mas descarta o próximo caractere
    while(scanf("%d", &numCompetidor) != EOF){
    int ordemSaida[numCompetidor];   
    int ordemChegada[numCompetidor]; 
      //Ler a ordem de saida
    for(int i = 0; i < numCompetidor; i++){
        scanf("%d", &ordemSaida[i]);
    } 

    //Ler a ordem de entrada
    for(int i = 0; i < numCompetidor; i++){
        scanf("%d", &ordemChegada[i]);
    } 


    
  // zerar as ultrapassagens para cada entrada
  ultrapassagens = 0;
  // pegar as diferenças entre a posição que o numero esta, for duplo, logo : O(N2)
      for(int i = 0; i < numCompetidor; i++){
      int tmp = ordemSaida[i];
        for(int j = 0; j < numCompetidor - 1; j++){
            if(ordemChegada[j] == tmp && i - j > 0){
                ultrapassagens += (i - j);
  }
          else if(ordemChegada[j] == tmp && i - j == 0  && i != 0 && ordemChegada[j + 1] == ordemSaida[i - 1]){
              ultrapassagens++;
      } 
    }
  }

printf("%d\n", ultrapassagens);

    }
    return 0;
  }