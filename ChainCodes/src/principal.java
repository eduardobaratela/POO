import java.io.IOException;

public class principal {
	
	
	public static void main(String[] args) throws IOException {
		calculos m = new calculos();
		m.leImagem();
		int[] ptoMin = new int[2];
		int larg = 0, alt = 0;
		
		ptoMin = m.getPtoMin();
		alt = m.getLargura();
		larg = m.getAltura();
		
		//m.printa();
		
		System.out.println(" 0 " + ptoMin[1] + " 1 " + ptoMin[0]);
		System.out.println("alt = " + larg);
		System.out.println("larg = " + alt);
	}
	
}
