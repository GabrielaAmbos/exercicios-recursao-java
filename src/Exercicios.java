import java.util.Random;
import java.util.Scanner;

public class Exercicios {



    private boolean verificaSeONumeroEstaNoArray(int [] array, int n) {
        int posicao = array.length;
        if(array[posicao] == n) {
            return true;
        } else {
            posicao--;
            if(posicao == 0){
                return false;
            } else {
                int [] euOdeioRecursao = new int[posicao];
                for(int i = 0; i < posicao; i++){
                    euOdeioRecursao[i] = array[i];
                }
                return verificaSeONumeroEstaNoArray(euOdeioRecursao, n);
            }
        }
    }

    public void exercicio1(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o tamanho que o array precisa ter: ");
        int quant = in.nextInt();
        Random random = new Random();
        int tamanho = random.nextInt(quant);
        int [] array = new int[tamanho];
        System.out.println("Digite o numero que voce quer testar: ");
        int numero = in.nextInt();
        if(verificaSeONumeroEstaNoArray(array, numero)){
            System.out.println("Oia, esse numero ta no array em bichao!");
        } else {
            System.out.println("Ah, que pena. Ce errou sua pamonha");
        }
    }

}
