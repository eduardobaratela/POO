import java.util.Calendar;
/**
 * Gerador simples de n�meros aleat�rios.
 */
public class Random {
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	private long xi = 1023;
	
	/**
	 * Retorna um numero gerado atrav�s do metodo Math.random()
	 * @return o n�mero gerado.
	 */
	public double getRand() {
		return Math.random();
	}
	
	/**
	 * Retorna um valor inteiro no intervalo (0,n[])
	 * @param n - O valor limite para a gera��o do n�mero inteiro
	 * @return o n�mero gerado
	 */
	public int getIntRand(int n) {
		double aux = getRand() * n;
		
		return (int)Math.abs(aux) + 1;
	}
	 /**
	  * Permite alterar a semente de gera��o de n�meros aleat�rios. Supostamente deve ser chamada antes de iniciar
	  *  a gera��o, mas se for chamado a qualquer instante, reseta o valor da semante
	  * @param k - o valor da nova semente de gera��o
	  */
	public void setSemente(int k) {
		xi = k;
	}
	
	/**
	 * Construtor que permite criar o gerador, especificando o valor inicial da semente.
	 * @param k - O valor inicial da semente.
	 */
	public Random(int k) {
		xi = k;
	}
	
	/**
	 * Construtor que usa uma semente aleat�ria, adquerida usando o m�todo Calendar.getTimeInMillis().
	 */
	public Random() {
		xi = -Calendar.getInstance().getTimeInMillis();
	}
}
