/*********************************************************************/
/**   Introdução à Programação                                      **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   Professor- Norton Trevisan Roman                              **/
/**                                                                 **/
/**   Segundo Exercício-Programa                                    **/
/**                                                                 **/
/**   Karina Duran Munhos                                           **/
/**                                                                 **/
/**   05/05/2020                                                    **/
/*********************************************************************/

// Cálculo para raiz quadrada
public class Raiz {
	/*
	 * Calcula a raiz quadrada de um valor, com uma determinada precisão. Retorna
	 * esse valor, ou -1 quando: a < 0 epsilon <= 0 epsilon >= 1
	 * 
	 * Parâmetro: a - valor cuja raiz quadrada será calculada epsilon - precisão do
	 * cálculo quanto menor epsilon, maior a precisão
	 * 
	 * Utiliza o método de Newton para cálculo de raíz quadrada
	 */

	// variáveis auxiliares

	// equivalente a xi
	static double x1;

	// equivalente a xi+1
	static double x2;

	// Método para calcular o módulo de um valor.
	static double valorAbsoluto(double valor) {
		if (valor < 0) {
			valor = valor * (-1);
		}

		return valor;

	}

	// Método para calcular a raíz
	static double raizQuadrada(double a, double epsilon) {
		if (a < 0 || epsilon < 0 || epsilon > 1) {
			return -1;
		}
		/*
		 * Atribui-se ao primeiro valor a/2, e então aplica a fórmula e se inicia o
		 * loop. Quando a diferença de x2, último valor resultante do laço, e x1, valor
		 * anterior a passar pelo laço, for menor que epsilon obteve-se a precisão
		 * desejada. Retornar, então, o valor.
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

	
	 //Apenas para seus testes. ISSO SERÁ IGNORADO NA CORREÇÃO

	public static void main(String[] args) {
		// inserir valores de a e epsilon
		double a = 23;
		double epsilon = 0.1;
		System.out.println("Raiz de : " + a + " = " + raizQuadrada(a, epsilon));
	}
}
