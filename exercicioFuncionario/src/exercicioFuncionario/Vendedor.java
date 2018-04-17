package exercicioFuncionario;

public class Vendedor extends Funcionarios{
	
	private double comissao;

	public Vendedor(String nome, String CPF, double Salario, double comissao) {
		super(nome, CPF, Salario);
		this.comissao = comissao;
	}

	@Override
	public double calculaSalario() {
		return getSalarioBase() + getComissao();
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
}
