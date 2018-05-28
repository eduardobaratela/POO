package aula7;

/**
 * Representa uma conta bancaria generica.
 * @author delamaro
 *
 */
public abstract class ContaBancaria implements Comparable<ContaBancaria>{

	private String nomeCliente;
	private int numConta;
	private double saldo;
	private static int cont = 1;
	
	/**
	 * Construtor. Cria uma conta com saldo 0
	 * @param n Nome do titular da conta
	 * @param num Numero atribuido a conta
	 */
	public ContaBancaria(String n) {
		nomeCliente = n;
		numConta = getCont();
		saldo = 0.0;
		cont++;
	}

	/**
	 * Obtem o nome do titular da conta.
	 * @return Nome do titular da conta.
	 */
	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		ContaBancaria.cont = cont;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(double s)
	{
		this.saldo = s;
	}
	
	public void saca(double qto) throws IllegalArgumentException {
		if ( saldo < qto) 
			throw new IllegalArgumentException("Saldo insuficiente para esse saque");
		saldo -= qto;
	}
	
	public void deposita(double qto) {
		saldo += qto;
	}
	
	public abstract void atualiza(double taxa); 
	
	@Override
	public int compareTo(ContaBancaria b) {
		double x = this.getSaldo();
		double y = b.getSaldo();
		if ( x == y ) return 0;
		if ( x < y ) return -1;
		return 1;
	}


}
