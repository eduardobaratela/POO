package aula7;

public class PoupancaSimples extends ContaPoupanca{
	
	public PoupancaSimples(String n, int dia) {
		super(n, dia);
	}

	@Override
	public void atualiza(double taxa) {
		double s = getSaldo();
		setSaldo(s * (1.0 + taxa));
	}

}
