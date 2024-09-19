import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Ler o número de operações e limpar o buffer
        int n = sc.nextInt();
        sc.nextLine();
        
        int[] pilha = new int[n];
        String[] comandos = new String[n];
        int cont = 0;
        // Ver se pode ser mais eficiente.         
        for(int i = 0; i < n; i++){
         comandos[i] = sc.nextLine(); 
         //Se for PUSH, ele pega o numero e joga para a pilha
        if(comandos[i].charAt(0) == 'P' && comandos[i].charAt(1) == 'U'){
            String[] separados = comandos[i].split(" ");
            pilha[cont] = Integer.parseInt(separados[1]);
            cont++;
        }
        else if(comandos[i].charAt(1) == 'O' && cont > 0){
            cont--;
        }
        else{
            if(cont > 0)
            System.out.println(menorElemento(pilha, cont));
            else
            System.out.println("EMPTY");
        }

        }
        sc.close();
    }

    public static int menorElemento(int[] array, int i){
        int menor = array[0];
        for(int a = 1; a < i; a++){
            if(array[a] < menor){
                menor = array[a];
            }
        }
        return menor;
    }
}

