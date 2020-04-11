import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    	Scanner in = new Scanner(System.in);
    	Exercicios chama = new Exercicios();
    	int opcao = 0;
    	do {
	    	System.out.println("Escolha um exercicio ou digite 0 para sair: ");
	    	opcao = in.nextInt();
	    	
	    	if(opcao == 1) {
	    		chama.exercicio1();
	    	} else if (opcao == 2) {
	    		chama.exercicio2();
	    	} else if (opcao == 3) {
	    		chama.exercicio3();
	    	} else if (opcao == 4) {
	    		chama.exercicio4();
	    	} else if (opcao == 5) {
	    		chama.exercicio5();
	    	} else if (opcao == 6) {
	    		chama.exercicio6();
	    	} else if (opcao == 7) {
	    		chama.exercicio7();
	    	} else if (opcao == 8) {
	    		chama.exercicio8();
	    	} else if (opcao == 9) {
	    		chama.exercicio9();
	    	} else if(opcao == 10) {
	    		chama.exercicio10();
	    	} else if (opcao == 11) {
	    		chama.exercicio11();
	    	} else {
	    		System.out.println("Opcao invalida!!!!!");
	    	}
	    	in.close();
    	} while(opcao != 0);
    }	
}
