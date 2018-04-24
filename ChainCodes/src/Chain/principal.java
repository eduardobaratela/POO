package Chain;
import java.io.IOException;

/**
 * Classe principal que chama as funcoes e printa os dados
 * @author eduar
 *
 */
public class principal {
	
	/**
	 * Funcao main do programa que printa todas as informacoes
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		calculos m = new calculos();
		int[] ptoMin = new int[2];
		
		String s = "circulo.png";
		m.leImagem(s);
		ptoMin = m.getPtoMin();
		m.getPtoMax();
		
		System.out.println("Circulo");	
		System.out.println("Inicio: " + ptoMin[1] + " " + ptoMin[0]);
		System.out.println("Largura: " + m.getLargura());
		System.out.println("Altura: " + m.getAltura());
		System.out.println("Número de pontos na borda: " + m.borda());
		m.zeraVisitado();
		System.out.println("Perimetro: " + m.calculaPerimetro(ptoMin[0], ptoMin[1]));
		
		System.out.println();
		System.out.println();
		
		s = "oval.png";
		m.leImagem(s);
		ptoMin = m.getPtoMin();
		m.getPtoMax();
		
		System.out.println("Oval");	
		System.out.println("Inicio: " + ptoMin[1] + " " + ptoMin[0]);
		System.out.println("Largura: " + m.getLargura());
		System.out.println("Altura: " + m.getAltura());
		System.out.println("Número de pontos na borda: " + m.borda());
		m.zeraVisitado();
		System.out.println("Perimetro: " + m.calculaPerimetro(ptoMin[0], ptoMin[1]));
	}
	
}
