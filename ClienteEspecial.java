//Essa classe herda a classe Cliente
public class ClienteEspecial extends Cliente {
	static final int dividaMaxima = 50000;
	static final String tipo = "CE";

	/*
	 * Construtor da Classe ClienteEspecial 
	 * Este construtor invoca o construtor da classe Cliente.
	 */
	ClienteEspecial(String nome, int cpf, int valor) {
		super(nome, cpf, valor);
	}

	/* Metodo que retorna o valor do atributo tipo do objeto atual */
	String retornaTipo() {
		return tipo;
	}

	// Metodo para o Cliente especial possuir emprestimo
	public boolean obterEmprestimo(int valor) {
		if (valor > 0) {
			if ((getValorDaDivida() + valor) > dividaMaxima) {
				return false;
			} else {
				setValorDaDivida(getValorDaDivida() + valor);
				return true;
			}
		}

		return false;
	}

}
