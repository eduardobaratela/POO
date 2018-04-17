package aula7;

public class PoupancaOuro extends ContaPoupanca{
	
	public PoupancaOuro(String n, int dia) {
		super(n, dia);
	}

	@Override
	public void atualiza(double taxa) {
		double s = getSaldo();
		setSaldo(s * (1.0 + 1.5*taxa));
	}

}
