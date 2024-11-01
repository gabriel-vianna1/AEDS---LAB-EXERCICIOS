import java.util.*;

public class Main {
 public static void main(String[] args){
   
    Scanner sc = new Scanner(System.in);
    int numAlunos;
    
    // Repete o processo até o EOF
    while(sc.hasNextLine()){
        
        numAlunos = sc.nextInt();
        sc.nextLine(); // Limpa o buffer após a leitura do numero de alunos
        Aluno[] alunos = new Aluno[numAlunos];
    
    // Lê os atributos de cada alunos    
    for(int i = 0; i < numAlunos; i++){
      
        alunos[i] = new Aluno();
        alunos[i].nome = sc.next();
        alunos[i].regiao = sc.next();
        alunos[i].distancia = sc.nextInt();
        sc.nextLine(); // Limpa o buffer após ler os atributos de cada alunos
    }

    // Ordenar por: Distância -> Região -> Nome
    
    quicksort(alunos, 0, numAlunos - 1);
    
    for(Aluno aluno : alunos){
        System.out.println(aluno.nome);
    }
 }

  sc.close(); 
} 

public static void quicksort(Aluno[] array, int inicio, int fim){
    if(inicio < fim){
        int posicaoPivo = partition(array, inicio, fim);
        quicksort(array, inicio, posicaoPivo - 1);
        quicksort(array, posicaoPivo + 1, fim);
    }
  
}

public static int partition(Aluno[] array, int inicio, int fim){
    Aluno pivo = array[fim];
    int i = inicio - 1;

    for(int j = inicio; j < fim; j++){
        if(array[j].distancia < pivo.distancia){
            i++;
            swap(array, i, j);
        }
        else if(array[j].distancia == pivo.distancia){ // Ordena em ordem alfabética da regiao, o compareTo retorna < 0 se for antes 
            if(array[j].regiao.compareTo(pivo.regiao) < 0){
                i++;
                swap(array, i, j);
            }
            else if(array[j].regiao.compareTo(pivo.regiao) == 0){ // Ordena ordem alfabética por nome caso as regiões sejam iguais
                if(array[j].nome.compareTo(pivo.nome) < 0){
                    i++;
                    swap(array, i, j);
                }
            }
        }
    }

    swap(array, i + 1, fim);
    return i + 1;
}


private static void swap(Aluno[] array, int i, int j) {
    Aluno temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

static class Aluno{
    String nome;
    String regiao;
    int distancia;
 }

}
