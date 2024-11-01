import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int numTestes = sc.nextInt();
        int cont;
        int[] sequencia;
        
        //O primeioro loop vai servir para fazer o programa quantas vezes chegar na entrada.
        for(int i = 0; i < numTestes; i++){
             
           int tam = sc.nextInt();
           sequencia = new int[tam];
           cont = 0;
           // Lê a sequência de DNA
            for(int j = 0; j < tam; j++){
                sequencia[j] = sc.nextInt();
            } 
         
            // Por ser parecido com o bubble não é ideal em termos de complexidades de comparação, porém funciona para contar o min de trocas
            for(int k = 0; k < tam; k++){
                for(int w = 0; w < tam - 1; w++){
                 if(sequencia[w] > sequencia[w + 1]){
                    swap(sequencia, w, w + 1);
                    cont++;
                 }
              }
            }
           System.out.println(cont);
        }
       sc.close();
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
