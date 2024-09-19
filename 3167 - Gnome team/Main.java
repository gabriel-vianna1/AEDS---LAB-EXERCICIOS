import java.util.*;

   public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // ler o numero de gnomos e limpar o buffer
        int n = sc.nextInt();
        //ver o numero de times
        sc.nextLine();
        int numTeams = n / 3;

        Gnomo[] gnomos = new Gnomo[n];
        // não usar o for-each pq vc precisa o indice // loop para ler os gnomos
        // CONFERIR SE VAI PRECISAR DAR O SPLIT(" "), DEPENDE DE COMO FOR A ENTRADA.    
        for(int i = 0; i < n; i++){
            String gnomo = sc.nextLine();
            String[] nomeIdade = gnomo.split(" ");
            gnomos[i] = new Gnomo();
            gnomos[i].nome = nomeIdade[0];
            gnomos[i].idade = Integer.parseInt(nomeIdade[1]);
            
        }
        
        // ordenar os gnomos por idade e, se eas forem iguais, colocar por ordem alfabética
        for(int i = 1; i < n; i++){
        int j = i - 1;
        Gnomo k = gnomos[i];
       while (j >= 0 && (gnomos[j].idade < k.idade || (gnomos[j].idade == k.idade && gnomos[j].nome.compareTo(k.nome) > 0))){
            gnomos[j + 1] = gnomos[j];
            j--;
        }
        gnomos[j + 1] = k;
        }
       
    
        Gnomo[] leaders = new Gnomo[numTeams];
        Gnomo[] deliver = new Gnomo[numTeams];
        Gnomo[] driver = new Gnomo[numTeams];

            int j = 0;
            int k = numTeams;
            int g = (numTeams * 2);
            
            while(j < numTeams && k < (2 * numTeams) && g < n){
                leaders[j] = gnomos[j];
                
                deliver[j] = gnomos[k];
                
                driver[j] = gnomos[g];         
                
                j++;
                k++;
                g++;
            }    

            for(int i = 1; i <= numTeams; i++){
                System.out.println("Time " + i);
                System.out.println(leaders[i - 1].nome + " " + leaders[i - 1].idade);
                System.out.println(deliver[i - 1].nome + " " + deliver[i - 1].idade);
                System.out.println(driver[i - 1].nome + " " + driver[i - 1].idade);
                System.out.println();
            }
            
        
        
    sc.close();
    }

    static class Gnomo{
        public String nome;
        public int idade;
       }
}

