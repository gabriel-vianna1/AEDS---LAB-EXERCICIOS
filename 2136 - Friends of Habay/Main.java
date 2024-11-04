import java.util.*;

public class Main {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);    
 
       String entradaNome;
       String entradaAmigo;
       boolean fim = true;
       boolean repetido = false;
       List<Pessoa> pessoas = new ArrayList<>();
       int p = 0;

       do{
       //Lê apenas o nome
       entradaNome = sc.next();
       if(entradaNome.equals("FIM")){
        fim = false;
       }
       else{
       // lê o resto
       entradaAmigo = sc.next();

       for(int i = 0; i < pessoas.size(); i++){
        if(entradaNome.equals(pessoas.get(i).nome)){ repetido = true;}
    }
        // Cria um nova instancia de pessoa e se ela já não estiver na lista, a adiciona.
        Pessoa pessoa = new Pessoa();
        pessoa.nome = entradaNome;
        pessoa.isFriend = (entradaAmigo.equals("YES") ? true : false);
        pessoa.prioridade = p;
        if(!repetido) {
            pessoas.add(pessoa);
            p++;
        }
 
        quicksort(pessoas, 0, pessoas.size() - 1);
        } 
    }while(fim);
    
    Pessoa amigo = isAmigo(pessoas);

    for(int i = 0; i < pessoas.size(); i++){
        System.out.println(pessoas.get(i).nome);
    }
        System.out.println();  
        System.out.println("Amigo do Habay:");
        System.out.println(amigo.nome);

       sc.close();
    }
    
    public static void quicksort(List<Pessoa> pessoas, int inicio, int fim){
     if(inicio < fim){  
     int posicaoPivo = partition(pessoas, inicio, fim);
    quicksort(pessoas, inicio, posicaoPivo - 1);
    quicksort(pessoas, posicaoPivo + 1, fim);
     }
}


    public static int partition(List<Pessoa> pessoas, int inicio, int fim){
        Pessoa pivo = pessoas.get(fim);
        int i = inicio - 1;

        for(int j = inicio; j < fim; j++){
            if(pessoas.get(j).nome.compareTo(pivo.nome) < 0){
                i++;
                Pessoa tmp = pessoas.get(i);
                pessoas.set(i, pessoas.get(j));
                pessoas.set(j, tmp);
            }
        }

        Pessoa tmp = pessoas.get(i + 1);
        pessoas.set(i + 1, pessoas.get(fim));
        pessoas.set(fim, tmp);

        return i + 1;
    }

    public static Pessoa isAmigo(List<Pessoa> pessoas){
    
    Pessoa amigo = pessoas.get(0);
    for(int i = 1; i < pessoas.size(); i++){
        String nome = pessoas.get(i).nome;
         if(amigo.isFriend && pessoas.get(i).isFriend && nome.length() > amigo.nome.length()){
            amigo = pessoas.get(i);
         } 
         else if(amigo.isFriend && pessoas.get(i).isFriend && nome.length() == amigo.nome.length()){
            if(pessoas.get(i).prioridade < amigo.prioridade){
                amigo = pessoas.get(i);
            }
         }
        
    } 

return amigo;
    }







    static class Pessoa{
        String nome;
        boolean isFriend;
        int prioridade;
    }
}
