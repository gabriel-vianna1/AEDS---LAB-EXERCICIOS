import java.util.*;

class Main{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      int numCompetidor = 0;
      int ultrapassagens = 0;
      int k = 0;
      int[]  arrayUltrapassagem = new int[3];
    
      while(sc.hasNextLine()){
    
      numCompetidor = sc.nextInt();
      //int[] idCompetidores = new int[numCompetidor];
      //recebe a ordem em uma linha e transoforma p array
      // pegar as diferenças entre a posição que o numero esta
      String entradaSaida = sc.nextLine();
      String[] ordemSaida = entradaSaida.split(" ");
      String entradaChegada = sc.nextLine();
      String[] ordemChegada = entradaChegada.split(" ");
    
      for(int i = 0; i < numCompetidor; i++){
        String tmp =  ordemSaida[i];
        for(int j = 0; j < numCompetidor; j++){
            if(ordemChegada[j].equals(tmp) && j - i > 0){
                ultrapassagens += j - i;
            }
        }
    }
arrayUltrapassagem[k] = ultrapassagens;
k++;

}
//Imprime o numero de ultrapassagens      
for(int i = 0; i < numCompetidor; i++){
System.out.println(arrayUltrapassagem[i]);
}

sc.close();
    }
}