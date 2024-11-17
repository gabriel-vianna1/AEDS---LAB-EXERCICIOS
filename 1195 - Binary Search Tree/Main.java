import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        int numNumeros;

        for(int i = 1; i <= numCasos; i++){
           
            if(i != 1){System.out.println();}

            Arvore arvore = new Arvore(); 
           numNumeros = sc.nextInt();

           for(int j = 0; j < numNumeros; j++){
            int num = sc.nextInt();
            arvore.inserir(num);
         }

           System.out.println("Case " + i +":");
           System.out.print("Pre.: ");
           Arvore.préOrdem(arvore.raiz);      
           System.out.println();     
           System.out.print("In..: ");
           Arvore.emOrdem(arvore.raiz);
           System.out.println();
           System.out.print("Post: ");
           Arvore.pósOrdem(arvore.raiz);
           System.out.println();

        }

        sc.close();

    }

}
class Arvore{
    No raiz;

    public Arvore(){
        raiz = null;
    }

private No inserir(No i, int x){
    if(i == null){
      i = new No(x);
    }
    else if(x < i.num){
      i.esq = inserir(i.esq, x);
    }
    else if(x > i.num){
      i.dir = inserir(i.dir, x);
    }
    return i;
}

public void inserir(int x){
    raiz = inserir(raiz, x);
}

public static void emOrdem(No i){
    if(i != null){
    emOrdem(i.esq);
    System.out.print(i.num + " ");
    emOrdem(i.dir);
    }
}

public static void préOrdem(No i){
    if(i != null){
    System.out.print(i.num + " ");
    préOrdem(i.esq);
    préOrdem(i.dir);
    }
}

public static void pósOrdem(No i){
    if(i != null){
    pósOrdem(i.esq);
    pósOrdem(i.dir);
    System.out.print(i.num + " ");
   }
 } 
}

class No{
    int num;
    No esq, dir;

    public No(int x){
        this.esq = this.dir = null;
        this.num = x;
    }

}
