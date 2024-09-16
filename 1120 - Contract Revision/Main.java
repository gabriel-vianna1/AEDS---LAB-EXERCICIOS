import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long d, n;
        boolean fim = true;
        do{
            d = sc.nextLong();
            n = sc.nextLong();
            if(d == 0 && n == 0){
                fim = false;
            }
            else
            System.out.println(correcaoContrato(d, n));
        }while(fim);
        System.out.println();

      

        sc.close();
    }

    public static long correcaoContrato(long d, long n){

        String D = Long.toString(d);
        String N = Long.toString(n);
        
        // Usa um loop for-each, transforma o  D em um array de char e troca em N, todos os D.
        for(char c : D.toCharArray()){
            N = N.replace(String.valueOf(c), "");
        }

        if(N.isEmpty()){
            return 0;
        }
        
        long num = Long.parseLong(N);

        return num;
        
    }
    
}
