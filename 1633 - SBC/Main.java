import java.util.*;

public class Main {
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);    
      
      long contador;

      while(sc.hasNextLine()){
        contador = 0;
      
        int numProcessos = sc.nextInt();
        Processo[] processos = new Processo[numProcessos];   
    
      for(int i = 0; i < numProcessos; i++){
        processos[i] = new Processo();
        processos[i].tempo = sc.nextInt();
        processos[i].ciclos = sc.nextInt();
      }
      
      quicksort(processos, 0, numProcessos - 1);

      if(numProcessos != 1){
        for(int i = 1; i < numProcessos; i++){
            contador+= processos[i - 1].ciclos;
        }
      }
      
      System.out.println(contador);
 }
}

public static void quicksort(Processo[] array, int inicio, int fim){
    if(inicio < fim){
    int posicaoPivo = partition(array, inicio, fim);
    quicksort(array, posicaoPivo + 1, fim);
    quicksort(array, inicio, posicaoPivo - 1);
    }
}

public static int partition(Processo[] array, int inicio, int fim){
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
    array[fim] = tmp;

    return i + 1;

}


static class Processo{
    int tempo;
    int ciclos;
}


}
