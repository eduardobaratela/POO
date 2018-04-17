package exercicioFuncionario;

public abstract class Funcionarios {
	
	private String nome;
	private String CPF;
	private double salarioBase;
	
	public Funcionarios(String nome, String CPF, double Salario) {
		this.nome = nome;
		this.CPF = CPF;
		this.salarioBase = Salario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	abstract double calculaSalario();
	
	//static boolean verificaCPF() {}
	
}
