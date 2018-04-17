package aula4;

import java.util.Calendar;

public class Random {
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	private long xi = 1023;
	
	
	public double getRand() {
		xi = (a + m *xi) % p;
		double d = xi;
		return d / p;
	}
	
	public int getIntRand(int n) {
		double aux = getRand() * n;
		return (int)aux;
	}
	
	public void setSemente(int k) {
		xi = k;
	}
	
	public Random(int k) {
		xi = k;
	}
	
	public Random() {
		Calendar.getInstance().getTimeInMillis();
	}
}
