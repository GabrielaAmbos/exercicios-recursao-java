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
        in.close();
    }
    
    
    
    private boolean verificaNumeroPrimo(int n, int auxiliar) {
    	if(n == 0 && n == 1) {
    		return false;
    	} else {
    		if(auxiliar == 1) {
    			return true;
    		} else {
    			if(n % auxiliar == 0) {
    				return false;
    			} else {
    				return verificaNumeroPrimo(n, (auxiliar - 1));
    			}
    		}
    	}
    }
    
    public void exercicio2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o numero que voce quer testar: ");
        int numero = in.nextInt();
        if(verificaNumeroPrimo(numero, (numero-1))){
        	System.out.println("Opaaaa, e primo em!");
        } else {
        	System.out.println("Oxe, e composto!");
        }
        in.close();
    }
    
    
   // private String inverteString(String mensagem, int posicao) {
    //	int tamanho = mensagem.length();
    //	int aux = tamanho-1;
    //	to
    //}
    
    //private String inverteString(String mensagem, int maior, int menor) {
    	
    //}
    
    
    
    private boolean somaNumeroPerfeito(int numero, int anterior, int soma) {
    	if(anterior == 1) {
    		soma++;
    		if(soma == numero) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		if((numero % anterior) == 0) {
    			soma += anterior;
    			return somaNumeroPerfeito(numero, (anterior-1), soma);
    		} else {
    			return somaNumeroPerfeito(numero, (anterior-1), soma);
    		}
    	}
    }
    
    public void exercicio11() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite um numero: ");
    	int numero = in.nextInt();
    	if(somaNumeroPerfeito(numero, (numero-1), 0)){
    		System.out.println("Que perfeicao!!!!!");
    	} else {
    		System.out.println("Que pena, nao e perfeito, e boy lixo :`c");
    	}
    }
    
    
    
    
    
    
    
    
    
}
