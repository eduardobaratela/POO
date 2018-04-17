package exercicioFuncionario;

public class Assistente extends Funcionarios{

	public Assistente(String nome, String CPF, double Salario) {
		super(nome, CPF, Salario);
	}
	
	@Override
	public double calculaSalario() {
		return getSalarioBase();
	}

}
