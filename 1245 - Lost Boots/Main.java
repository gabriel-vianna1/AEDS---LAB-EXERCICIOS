import java.util.*;

public class Main {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       
       int numSapatos;
       int[] tamanhoSapato;
       String[] esqORdir;
       boolean[] achado;
       int contador;
       
    while(sc.hasNextLine()){
        numSapatos = sc.nextInt();
        
        tamanhoSapato = new int[numSapatos];
        esqORdir = new String[numSapatos];
        achado = new boolean[numSapatos];
        contador = 0;

        for(int i = 0; i < numSapatos; i++){
            tamanhoSapato[i] = sc.nextInt();
            esqORdir[i] = sc.next();
        }
        
      for(int i = 0; i < numSapatos; i++){
            for(int j = i + 1; j < numSapatos; j++){
                if(tamanhoSapato[j] == tamanhoSapato[i]){
                  if(!esqORdir[j].equals(esqORdir[i]) && !achado[i] && !achado[j]) {
                     contador++;
                     achado[i] = true; 
                     achado[j] = true;
                 }
                }
            }
        }
     
        System.out.println(contador);
    }
    sc.close();
  } 
}
