import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String base;
        int B, C, F, S;
        int CF, BS;
        int contador;

        // Vai ler até achar o final do arquivo
        while(sc.hasNextLine()){
           B = C = F = S = 0;
           contador = 0;
        
           base = sc.nextLine();
           int n = base.length();
           
           // For normal e não um for-each porque eu preciso dos índice
           for(int i = 0; i < n; i++){

           if(base.charAt(i) == 'B' ) {B++;}
           else if(base.charAt(i) == 'C') {C++;}
           else if(base.charAt(i) == 'S') {S++;}
           else if(base.charAt(i) == 'F') {F++;}
           }
          
           if(C == F) {CF = C;}
           else if(C == 0 || F == 0) {CF = 0;}
           else { CF = (C < F) ? C : F;}

           if(B == S) {BS = B;}
           else if(B == 0 || S == 0) {BS = 0;}
           else { BS = (B < S) ? B : S;}

      
           contador = CF + BS;
           
           if(C == 1 && B == 1 && F == 1 && S == 1) {contador = 0;}
    System.out.println(contador);
}
sc.close();
    }    
}
