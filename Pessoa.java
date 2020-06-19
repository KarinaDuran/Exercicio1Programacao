//Super classe herdada pelas subclasses Gerente e Cliente
public abstract class Pessoa {
	String nome;
	int cpf;

//Construtor para pessoa, com cpf e nome de atributos
	Pessoa(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

//Método a ser sobrescrito pelas subclasses
	abstract String retornaTipo();

}
