package exercicioFuncionario;

public class Gerente extends Funcionarios{
	
	private double comissao;

	public Gerente(String nome, String CPF, double Salario) {
		super(nome, CPF, Salario);
		
	}
	
	@Override
	public double calculaSalario() {
		return getSalarioBase() * 2;
	}
}
