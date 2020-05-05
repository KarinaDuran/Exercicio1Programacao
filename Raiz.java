/*********************************************************************/
/**   ACH2001 - Introdu��o � Programa��o                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   2020104 - Norton Trevisan Roman                               **/
/**                                                                 **/
/**   Segundo Exerc�cio-Programa                                    **/
/**                                                                 **/
/**   Karina Duran Munhos                   11295911                **/
/**                                                                 **/
/**   05/05/2020                                                    **/
/*********************************************************************/

// C�lculo para raiz quadrada
public class Raiz {
	/*
	 * Calcula a raiz quadrada de um valor, com uma determinada precis�o. Retorna
	 * esse valor, ou -1 quando: a < 0 epsilon <= 0 epsilon >= 1
	 * 
	 * Par�metro: a - valor cuja raiz quadrada ser� calculada epsilon - precis�o do
	 * c�lculo quanto menor epsilon, maior a precis�o
	 * 
	 * Utiliza o m�todo de Newton para c�lculo de ra�z quadrada
	 */

	// vari�veis auxiliares

	// equivalente a xi
	static double x1;

	// equivalente a xi+1
	static double x2;

	// M�todo para calcular o m�dulo de um valor.
	static double valorAbsoluto(double valor) {
		if (valor < 0) {
			valor = valor * (-1);
		}

		return valor;

	}

	// M�todo para calcular a ra�z
	static double raizQuadrada(double a, double epsilon) {
		if (a < 0 || epsilon < 0 || epsilon > 1) {
			return -1;
		}
		/*
		 * Atribui-se ao primeiro valor a/2, e ent�o aplica a f�rmula e se inicia o
		 * loop. Quando a diferen�a de x2, �ltimo valor resultante do la�o, e x1, valor
		 * anterior a passar pelo la�o, for menor que epsilon obteve-se a precis�o
		 * desejada. Retornar, ent�o, o valor.
		 */
		else {
			x2 = a / 2;

			while (valorAbsoluto(x2 - x1) > epsilon) {
				x1 = x2;
				x2 = 1.0 / 2.0 * (x1 + a / x1);
			}

			return x2;
		}
	}

	
	 //Apenas para seus testes. ISSO SER� IGNORADO NA CORRE��O

	public static void main(String[] args) {
		// inserir valores de a e epsilon
		double a = 23;
		double epsilon = 0.1;
		System.out.println("Raiz de : " + a + " = " + raizQuadrada(a, epsilon));
	}
}
