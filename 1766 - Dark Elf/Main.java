import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cenarios;
        int total, usadas;
        
        //Recebe o numero total de cenarios, de renas que serão ordenadas e quantas serão impressas.
        cenarios = sc.nextInt();
        int c = 1;
        while(cenarios > 0){
        total = sc.nextInt();
        usadas = sc.nextInt();

        sc.nextLine();
        //Limpar o buffer

        Rena[] renas = new Rena[total];

        for(int i = 0; i < total; i++){
        
       // O programa recebe como uma string, por isso tem que fazer o tratamento
        String entrada = sc.nextLine();
        String[] divisao = entrada.split(" ");
        
        renas[i] = new Rena();
        renas[i].Nome = divisao[0];

        renas[i].weight = Integer.parseInt(divisao[1]);
        renas[i].age = Integer.parseInt(divisao[2]);
        renas[i].height = Double.parseDouble(divisao[3]);
     }
       
        heapSortDecrescente(renas);

        System.out.println("CENARIO" + " {" + c + "}");
        for(int j = 1; j <= usadas; j++){
         System.out.println(j + " - " + renas[j - 1].Nome);
        }
   
    cenarios--;
    c++;
}

    sc.close();    
}
   
    public static void heapify(Rena[] array, int n, int i) {
        int smallest = i; // Inicializa o menor como raiz
        int left = 2 * i + 1; // Filho esquerdo
        int right = 2 * i + 2; // Filho direito

        // Se o filho esquerdo é menor que a raiz
        if (left < n && array[left].weight < array[smallest].weight) {
            smallest = left;
        }else  if(left < n && array[left].weight == array[smallest].weight){
            if(array[left].age > array[smallest].age){
                smallest = left; //smallest mas nesse caso seria o maior dele           
                 }
            else if(array[left].age == array[smallest].age){
                if(array[left].height > array[smallest].height) {smallest = left;}
            }
            else if(array[left].height == array[smallest].height){
                if(array[left].Nome.compareTo(array[smallest].Nome)  > 0) {smallest = left;}
            }
        }

        // Se o filho direito é menor que o menor até agora
        if (right < n && array[right].weight < array[smallest].weight) {
            smallest = right;
        } else if(right < n && array[right].weight == array[smallest].weight){
            if(array[right].age > array[smallest].age){
                smallest = right; //smallest mas nesse caso seria o maior dele           
                 }
            else if(array[right].age == array[smallest].age){
                if(array[right].height > array[smallest].height) {smallest = right;}
            }
            else if(array[right].height == array[smallest].height){
                if(array[right].Nome.compareTo(array[smallest].Nome)  > 0) {smallest = right;}
            }
        }

        // Se o menor não é a raiz
        if (smallest != i) {
            // Troca a raiz com o menor
            Rena tmp = array[i];
            array[i] = array[smallest];
            array[smallest] = tmp;

            // Recursivamente faz heapify na subárvore afetada
            heapify(array, n, smallest);
        }
    }   
   
    public static void heapSortDecrescente(Rena[] array) {
        int n = array.length;

        // Constrói o Min-Heap (reorganizando o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrai os elementos um a um do heap e coloca no final do array
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual (menor elemento) para o fim
            Rena tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            // Chama heapify na árvore reduzida para restaurar o Min-Heap
            heapify(array, i, 0);
        }
    }
 
    static class Rena{
        public String Nome;
        public int weight;
        public int age;
        public double height;
    }
}