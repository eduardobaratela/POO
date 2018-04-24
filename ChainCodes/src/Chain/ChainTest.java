package Chain;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class ChainTest {
	

	@Test
	void testCirculo() throws IOException {
		String s = "circulo.png";
		calculos m = new calculos();
		m.leImagem(s);
		
		assertEquals(50, m.getmaxY());
		assertEquals(50, m.getmaxX());
		
		int[] ptoMin = new int[2];
		ptoMin= m.getPtoMin();
		int[] expectedMin = new int[]{16, 23};
		assertArrayEquals(expectedMin, ptoMin);
		
		int[] ptoMax = new int[2];
		ptoMax = m.getPtoMax();
		int[] expectedMax = new int[]{35, 26};
		assertArrayEquals(expectedMax, ptoMax);
		
		
		assertEquals(20, m.getAltura());
		assertEquals(20, m.getLargura());
		assertEquals(52, m.borda());
		
		m.zeraVisitado();
        assertEquals( 61.94112549695426, m.calculaPerimetro(ptoMin[0], ptoMin[1]), 0);	
    }
	
	@Test
	void testOval() throws IOException {
		String s = "oval.png";
		calculos m = new calculos();
		m.leImagem(s);
		
		assertEquals(172, m.getmaxY());
		assertEquals(288, m.getmaxX());
		
		int[] ptoMin = new int[2];
		ptoMin= m.getPtoMin();
		int[] expectedMin = new int[]{51, 139};
		assertArrayEquals(expectedMin, ptoMin);
		
		int[] ptoMax = new int[2];
		ptoMax = m.getPtoMax();
		int[] expectedMax = new int[]{111, 163};
		assertArrayEquals(expectedMax, ptoMax);
		
		assertEquals(61, m.getAltura());
		assertEquals(196, m.getLargura());
		assertEquals(407, m.borda());
		
		m.zeraVisitado();
		assertEquals(449.6639969244296, m.calculaPerimetro(ptoMin[0], ptoMin[1]), 0);
		
		
	}

}
