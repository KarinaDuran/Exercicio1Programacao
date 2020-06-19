
public class Gerente extends Pessoa implements InterfaceGerente {
	private static final String tipo = "G";
	private Cliente[] clientes;
	private int numClientes;

	/*
	 * Construtor da Classe Gerente Este construtor invoca o construtor da classe
	 * Pessoa e inicializa os dois atributos do objeto que esta sendo instanciado.
	 */
	Gerente(String nome, int cpf) {
		super(nome, cpf);
		clientes = new Cliente[20];
		numClientes = 0;
	}

	/* Metodo que retorna o valor do atributo tipo do objeto atual */
	String retornaTipo() {
		return tipo;
	}

	/*
	 * Metodo para imprimir informacoes sobre os clientes gerenciados pelo gerente
	 * atual
	 */
	void imprimirClientes() {
		Cliente atual;
		System.out.println("\tNumero de clientes: " + numClientes);
		for (int c = 0; c < numClientes; c++) {
			atual = clientes[c];
			System.out.println("\t" + (c + 1) + "\t" + atual.retornaTipo() + "\t" + atual.nome + "\t" + atual.cpf + "\t"
					+ atual.getValorContaCorrente() + "\t" + atual.getValorDaDivida() + "\t" + atual.negativado());
		}
	}

	/*
	 * Metodo para adicionar um cliente no arranjo de clientes do gerente atual.
	 * Caso o numero de clientes seja igual a 20, nao deve adicionar e deve retornar
	 * false. Caso contrario, ha duas situacoes:
	 * 
	 * 1)o cliente ja consta no arranjo de clientes (verifica-se pelo cpf), neste 
	 * caso o cliente nao deve ser reinserido e o metodo deve retornar false;
	 * 
	 * 2) o cliente passado como parametro nao consta no arranjo de clientes: o 
	 * cliente deve ser adicionado na posicao numClientes, o atributo numClientes
	 * deve ser incrementado em 1 e o metodo deve retornar true.
	 * 
	 */
	public boolean adicionarCliente(Cliente cliente) {
		if (numClientes < clientes.length) {
			int i = 0;
			while (i < numClientes) {
				if (clientes[i].cpf == cliente.cpf) {
					return false;
				} else {
					i++;
				}
			}

			clientes[numClientes] = cliente;
			numClientes++;
			return (true);
		}

		return (false);
	}

	/*
	 * Metodo para cobrar os emprestimos de todos os clientes do gerente atual. Para
	 * cada um dos clientes presentes no arranjo clientes, este metodo deve: 
	 * 
	 * 1) Nao fazer nada para o cliente, caso seu valorDaDivida seja igual a zero 
	 * 
	 * 2) Caso contrario, ha duas situacoes: 
	 *	a) se o valorContaCorrente do cliente for maior ou igual ao valorDaDivida, 
	 *	deve fazer o cliente pagar a divida, isto e, o valorContaCorrente sera atualizado,
	 *	descontando-se o valor da divida e o valorDaDivida sera zerado.
	 *  
	 *	b) se o valorContaCorrente do cliente for menor do que o valorDaDivida, deve fazer
	 *	o cliente pagar parte da divida, isto e, o valorDaDivida sera atualizado, tendo seu
	 *	valor diminuido pelo valorContaCorrente e o valorContaCorrente sera zerado.
	 * 
	 */
	public void cobrarTodosEmprestimos() {
		for (int j = 0; j < numClientes; j++) {
			if (clientes[j].getValorDaDivida() > 0) {
				// variaveis auxiliares para armazenar o valor da divida (d) e da conta corrente
				// (cc)
				int d = clientes[j].getValorDaDivida();
				int cc = clientes[j].getValorContaCorrente();
				if (cc > d) {
					clientes[j].setValorContaCorrente(cc - d);
					clientes[j].setValorDaDivida(0);

				} else {
					clientes[j].setValorDaDivida(d - cc);
					clientes[j].setValorContaCorrente(0);
				}
			}

		}

	}

}
