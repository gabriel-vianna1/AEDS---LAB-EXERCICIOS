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
      sc.nextLine();//Consume a linha em branco depois do nextInt
     
      //recebe a ordem em uma linha e transoforma p array
      String entradaSaida = sc.nextLine();
      String[] ordemSaida = entradaSaida.trim().split(" ");

      String entradaChegada = sc.nextLine();
      String[] ordemChegada = entradaChegada.trim().split(" ");
      // zera as ultrapassagens depois de cada iteração
      ultrapassagens = 0;
      // pegar as diferenças entre a posição que o numero esta
      for(int i = 0; i < numCompetidor; i++){
        String tmp =  ordemSaida[i];
        for(int j = 0; j < numCompetidor; j++){
            if(ordemChegada[j].equals(tmp) && i - j > 0){
                ultrapassagens += i - j;
            }
            else if(ordemChegada[j].equals(tmp) && i - j == 0 && j != (ordemSaida.length - 1) && i != 0 && ordemChegada[j + 1].equals(ordemSaida[i - 1])){
                ultrapassagens += 1;
            }
        }
    }
arrayUltrapassagem[k] = ultrapassagens;
k++;

}
//Imprime o numero de ultrapassagens      
for(int numero : arrayUltrapassagem){
System.out.println(numero);
}

sc.close();
    }
}