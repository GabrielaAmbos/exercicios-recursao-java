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
                int [] novoArray = new int[posicao];
                for(int i = 0; i < posicao; i++){
                	novoArray[i] = array[i];
                }
                return verificaSeONumeroEstaNoArray(novoArray, n);
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
            System.out.println("Oia, esse numero ta no array!");
        } else {
            System.out.println("Ah, que pena. Ce errou");
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
    
    public int[] selecaoDireta(int[] array, int posicao) {
        if (posicao == array.length) {
            return array;
        } else {
            int menorValor = array[posicao];
            int menorPosicao = posicao;

            for (int i = posicao; i < array.length; i++) {
                if (menorValor > array[i]) {
                    menorValor = array[i];
                    menorPosicao = i;
                }
            }
            int aux = array[posicao];
            array[posicao] = array[menorPosicao];
            array[menorPosicao] = aux;
            return selecaoDireta(array, posicao + 1);
        }
    }
    
    public void exercicio3() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite alguns numeros separados por virgula: ");
    	String numeros = in.nextLine();
    	String [] arrayNumeros = numeros.split(", ");
    	int[] array = new int[arrayNumeros.length];
    	for(int i = 0; i < arrayNumeros.length; i++) {
    		array[i] = Integer.parseInt(arrayNumeros[i]);
    	}
    	int[] novoArray = selecaoDireta(array, 0);
    	for(int i = 0; i < novoArray.length; i++) {
    		System.out.print(novoArray[i] + ", ");
    	}
    	in.close();
    }
    
    public int[] insercaoDireta(int[] array, int posicao){
        if(posicao == array.length){
            return array;
        }else {
            int posicaoAtual = posicao;
            int posicaoAnterior = posicaoAtual - 1;

            while ((posicaoAtual > 0) && (array[posicaoAtual] < array[posicaoAnterior])) {
                int aux = array[posicaoAtual];
                array[posicaoAtual] = array[posicaoAnterior];
                array[posicaoAnterior] = aux;
                posicaoAtual--;
                posicaoAnterior--;
            }
            return insercaoDireta(array, posicao + 1);
        }
    }
      
    public void exercicio4() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite alguns numeros separados por virgula: ");
    	String numeros = in.nextLine();
    	String [] arrayNumeros = numeros.split(", ");
    	int[] array = new int[arrayNumeros.length];
    	for(int i = 0; i < arrayNumeros.length; i++) {
    		array[i] = Integer.parseInt(arrayNumeros[i]);
    	}
    	int[] novoArray = insercaoDireta(array, 0);
    	for(int i = 0; i < novoArray.length; i++) {
    		System.out.print(novoArray[i] + ", ");
    	}
    	in.close();
    }
    
    
    private String inverteString(String mensagem, int posicao) {
    	int tamanho = mensagem.length() - 1;
    	int aux = tamanho - 1;
    	if(posicao == tamanho) {
    		return mensagem;
    	} else {
    		char[] converteString = mensagem.toCharArray();
    		char salvaChar = converteString[tamanho];
    		while(tamanho > posicao) {
    			converteString[tamanho] = converteString[aux];
    			tamanho--;
    			aux--;
    		}
    		converteString[posicao] = salvaChar;
    		posicao++;
    		return inverteString(String.valueOf(converteString), posicao);
    	}
    }
    
    public void exercicio5() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite uma mensagem: ");
    	String mensagem = in.nextLine();
    	System.out.println(inverteString(mensagem, 0));
    	in.close();
    }

    
    private double somaNumerosNPorUm(int n) {
    	if(n == 1) {
    		return n;
    	} else {
    		return (double)1/n + somaNumerosNPorUm(n-1); 
    	}
    }
    
    public void exercicio6() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite um numero: ");
    	int numero = in.nextInt();
    	System.out.println(somaNumerosNPorUm(numero));
    	in.close();
    }
    
    public boolean verificaSeEPalindromo(String palavra, int posicao) {
    	String palavraMaiscula = palavra.toUpperCase();
    	int tamanho = palavra.length() - 1;
    	if(posicao == palavra.length()) {
    		return true;
    	} else {
    		int posicaoFinal = tamanho - (posicao);
    		if(palavraMaiscula.charAt(posicao) == palavraMaiscula.charAt(posicaoFinal)) {
    			return verificaSeEPalindromo(palavra, (posicao + 1));
    		} else {
    			return false;
    		}
    	}
    }
    
    public void exercicio7() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite uma palavra: ");
    	String palavra = in.nextLine();
    	//palavra = palavra.replaceAll("[^a-zA-Z0-9]", "");      Nao sei se podia usar
    	palavra = palavra.replace(" ", "");
    	palavra = palavra.replace(",", "");
    	palavra = palavra.replace("!", "");
    	palavra = palavra.replace(";", "");
    	palavra = palavra.replace("?", "");
    	palavra = palavra.replace(".", "");
    	if(verificaSeEPalindromo(palavra, 0) == true) {
    		System.out.println("Boooooooh, e um PALINDROMO cara!!!!");
    	} else {
    		System.out.println("Sad, nao e um palindromo :`c ");
    	}
    	in.close();
    }
    
    private int quantDePalindromosNoArray(String [] array, int posicao) {
    	if(posicao == array.length) {
    		return 0;
	    } else {		
	    	if(verificaSeEPalindromo(array[posicao], 0)) {
	    		return 1 + quantDePalindromosNoArray(array, posicao + 1);
	    	} else {
	    		return quantDePalindromosNoArray(array, posicao + 1);
	    	}
    	}
    }
    
    public void exercicio8() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite algumas palavras: ");
    	String palavras = in.nextLine();
    	String[] arrayPalavras = palavras.split(", ");
    	System.out.println("Quantidade de palindromos: " + quantDePalindromosNoArray(arrayPalavras, 0));
    	in.close();
    }
    
    private int verificaSeDEstaDentroDeN(int d, int n) {
    	if(n < 1) {
    		return 0;
    	} else {
    		int aux = n % 10;
    		if(d == aux) {
    			return 1 + verificaSeDEstaDentroDeN(d, n/10);
    		} else {
    			return verificaSeDEstaDentroDeN(d, n/10);
    		}
    	}
    }
    
    public void exercicio9() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite um numero: ");
    	int numero = in.nextInt();
    	System.out.println("Digite um numero para procurar: ");
    	int procura = in.nextInt();
    	System.out.println(verificaSeDEstaDentroDeN(procura, numero));
    	in.close();
    }
    
     private double mediaDosDigitos(int n, int quantDigitos) {
    	if(n < 1) {
    		return n;
    	} else {
    		double aux = n % 10;
    		return aux/quantDigitos + mediaDosDigitos(n/10, quantDigitos);
    	}
    }
    
    public void exercicio10() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Digite um numero: ");
    	int numero = in.nextInt();
    	int tamanho = Integer.toString(numero).length();
    	System.out.println(mediaDosDigitos(numero, tamanho));
    	in.close();
    }
    
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
    		System.out.println("Que pena, nao e perfeito");
    	}
    	in.close();
    }

}
