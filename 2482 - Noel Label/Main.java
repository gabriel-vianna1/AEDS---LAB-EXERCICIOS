import java.util.*;

public class Main {
    public static void main(String[] args){

                Scanner sc = new Scanner(System.in);
                
                int n = sc.nextInt();
                sc.nextLine();
                
                String[] idiomas = new String[n];
                String[] traducoes = new String[n];
                
                // recebe os idiomas e os respectivos idiomas nos msms indices
                for(int i = 0; i < n; i++){
                    idiomas[i] = sc.nextLine();
                    traducoes[i] = sc.nextLine();
                } //rever  para (n * 2) caso de errado.
                
                int m = sc.nextInt();
                sc.nextLine();
                
                String[] nomes = new String[m];
                String[] linguaC = new String[m];
                
                // guarda o nome das crianças e seus respectivos idiomas
                for(int i = 0; i < m; i++){
                    nomes[i] = sc.nextLine();
                    linguaC[i] = sc.nextLine();
                    }
                int marcador = 0;
                // fazer as impressões dos lables
                for(int i = 0; i < m; i++){
                    // achar o idiomas correspondente;
                    for(int j = 0; j < n; j++){
                        if(linguaC[i].equals(idiomas[j].trim())){
                         marcador = j;
                         j = n;
                        }
                    }

                    
                  
                    System.out.println(nomes[i]);
                    System.out.println(traducoes[marcador]);
                    System.out.println();
                }
                sc.close();
            }
        }