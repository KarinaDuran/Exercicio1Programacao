# Exercicio1Programacao
Primeiro exercicio de programação
/*
	Caixa eletrônico das Ilhas Weblands, com estoque ilimitado de cédulas
	de B$50,00, B$10,00, B$5,00 e B$1,00.
*/
public class caixaEletronico {
   
    // Número de cédulas de B$50,00
	static int n50;
	
	// Número de cédulas de B$10,00
	static int n10;
	
	// Número de cédulas de B$5,00
	static int n5;
	
	// Número de cédulas de B$1,00
	static int n1;

	/*
		Determinar a quantidade de notas necessárias para atingir o objetivo 
		utilizando o mínimo de cédulas possível.
		
		Abastecer as variáveis globais n50,n10, n5 e n1 com seu respectivo
		número de cédulas.
		
		Parâmetro:
			valor - O valor total a ser retirado
	*/
	
	static void fazRetirada(int valor) {
		if (valor >= 0) { 
	        if (valor/50 < 0) {
		       n50 = 0;  } 
		    else{ 
		       n50 = valor/50;
			    }
	        
		    if ((valor - n50*50 == 0) || (valor - n50*50 < 10)) { 
		       n10 = 0; }
		    else{
		       n10 = (valor - n50*50)/10;
			    }
		    
			if ((valor - n50*50 - n10*10 == 0) || (valor - n50*50 - n10*10 < 5)) {
			   n5 = 0; }
			else{
		       n5 = (valor - n50*50 - n10*10 )/5;
		        }
			
		    if(valor - n50*50 - n10*10 - n5*5 == 0 ) {
			   n1 = 0; }
		    else{
		       n1 = (valor - n50*50 - n10*10 - n5*5);
		        }
			                    
		                 }    
	    else{
			   n50 = -1;
			   n10 = -1;
			   n5 = -1;
			   n1 = -1;
		    }
	}
	
	

	public static void main(String[] args) {
        caixaEletronico.fazRetirada(0);
		System.out.println("Notas de 50: "+ n50);
		System.out.println("Notas de 10: "+ n10);
		System.out.println("Notas de 5:  "+ n5);
		System.out.println("Notas de 1:  "+ n1);
	}
}


