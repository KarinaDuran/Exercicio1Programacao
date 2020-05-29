/*********************************************************************/
/**   ACH2001 - Introdu��o � Programa��o                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   <turma> - Norton Trevisan Roman                               **/
/**                                                                 **/
/**   Terceiro Exerc�cio-Programa                                   **/
/**                                                                 **/
/**   Karina Duran Munhos                        11295911           **/
/**                                                                 **/
/**   29/05/2020                                                    **/
/*********************************************************************/

/*
 * Jogo da Velha - programa para verificar o status de um jogo.
 * 
 * Lista de Status calculado: 0 - Jogo n�o iniciado: o tabuleiro est� 'vazio',
 * isto � sem pe�as X e O;
 * 1 - Jogo encerrado1: o primeiro jogador (que usa as pe�as X) � o ganhador;
 * 2 - Jogo encerrado2: o segundo jogador (que usa as pe�as O) � o ganhador; 
 * 3 - Jogo encerrado3: empate - todas as casas do tabuleiro est�o preenchidas 
 * com X e O, mas nenhum dos jogadores ganhou; 
 * 4 -Jogo j� iniciado e em andamento: nenhuma das alternativas anteriores.
 */

public class JogoDaVelha {
	// vari�veis auxiliares
	/*
	 * resolucionado -indicar se o jogo tem vencedores jogoIniciado - indicar se o
	 * jogo j� foi iniciado
	 */
	static final char pecaX = 'X';
	static final char pecaY = 'O';
	static final char espacoVazio = ' ';
	static boolean resolucionado;
	static boolean jogoIniciado;
	static char[][] matrizNula = { { espacoVazio, espacoVazio, espacoVazio }, { espacoVazio, espacoVazio, espacoVazio },
			{ espacoVazio, espacoVazio, espacoVazio } };

	/*
	 * Determina o status de uma partida de Jogo da Velha
	 * 
	 * Entrada: tabuleiro - matriz 3x3 de caracteres representando uma partida
	 * valida de Jogo da Velha
	 * 
	 * Sa�da: um inteiro contendo o status da partida (valores v�lidos de zero a
	 * quatro)
	 */

	static int verificaStatus(char[][] tabuleiro) {
		int status = -1;
		resolucionado = false;
		jogoIniciado = false;
		// Percorre a matriz e verifica se o jogo iniciou
		for (int m = 1; m < tabuleiro.length; m++) {
			for (int n = 1; n < tabuleiro.length; n++) {
				if (tabuleiro[m][n] != matrizNula[m][n]) {
					jogoIniciado = true;

				}
			}
		}
		// Percorre a matriz everifica se h� ganhador nas fileiras
		if (jogoIniciado == true) {
			for (int i = 0; i < tabuleiro.length; i++) {
				if ((tabuleiro[i][0] == tabuleiro[i][1]) && (tabuleiro[i][1] == tabuleiro[i][2])
						&& (tabuleiro[i][0] != espacoVazio)) {
					if (tabuleiro[i][0] == pecaX) {
						status = 1;
						resolucionado = true;
					}
					if (tabuleiro[i][0] == pecaY) {
						status = 2;
						resolucionado = true;
					}

				}
			}
			// Percorre a matriz e verifica se h� ganhador nas colunas
			for (int j = 0; j < tabuleiro.length; j++) {
				if (tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]
						&& tabuleiro[1][j] != espacoVazio) {
					if (tabuleiro[1][j] == pecaX) {
						status = 1;
						resolucionado = true;
					}
					if (tabuleiro[1][j] == pecaY) {
						status = 1;
						resolucionado = true;
					}

				}
			}
			// Verifica se h� ganhador na diagonal
			if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2])
					|| (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0])
							&& tabuleiro[1][1] != espacoVazio) {
				if (tabuleiro[1][1] == pecaX) {
					status = 1;
					resolucionado = true;

				}
				if (tabuleiro[1][1] == pecaY) {
					status = 2;
					resolucionado = true;
				}

			}
			/*
			 * Percorre a matriz procurando um elemento espacoVazio que indique que o jogo
			 * ainda n�o foi finalizado se o jogo ainda n�o estiver solucionado. Se a
			 * resposta for que n�o existe a vari�vel espacoVazio, ent�o deu empate pois n�o
			 * h� vencedores nem movimentos a se fazer.
			 */
			if (resolucionado == false) {
				for (int k = 0; k < 3; k++) {
					for (int f = 0; f < 3; f++) {
						if (tabuleiro[k][f] == espacoVazio) {
							status = 4;
						} else {
							status = 3;
						}
					}
				}

			}
		}
		else {

			status =0;
		}
			// Caso o jogo n�o foi iniciado, recebe o status 0.

		return status;
	}

	public static void main(String[] args) {
		char[][] tab0 = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		char[][] tab1 = { { 'X', 'X', 'X' }, { 'O', 'O', ' ' }, { ' ', ' ', ' ' } };
		char[][] tab2 = { { 'O', 'X', 'X' }, { 'X', 'O', 'O' }, { ' ', ' ', 'O' } };
		char[][] tab3 = { { 'O', 'X', 'X' }, { 'X', 'O', 'O' }, { 'O', 'X', 'X' } };
		char[][] tab4 = { { ' ', ' ', ' ' }, { 'X', 'O', 'X' }, { ' ', ' ', ' ' } };

		System.out.println("Status calculado: " + verificaStatus(tab0));
		System.out.println("Status esperado para o tabuleiro0: 0\n");

		System.out.println("Status calculado: " + verificaStatus(tab1));
		System.out.println("Status esperado para o tabuleiro1: 1\n");

		System.out.println("Status calculado: " + verificaStatus(tab2));
		System.out.println("Status esperado para o tabuleiro2: 2\n");

		System.out.println("Status calculado: " + verificaStatus(tab3));
		System.out.println("Status esperado para o tabuleiro1: 3\n");

		System.out.println("Status calculado: " + verificaStatus(tab4));
		System.out.println("Status esperado para o tabuleiro4: 4\n");

	}
}
