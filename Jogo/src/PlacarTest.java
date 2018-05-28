import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

public class PlacarTest {
	private Placar p1;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Placar();
	}

	@After
	public void setUp1()throws Exception{
		p1 =null;
	}

	@Test
	public void testGetScoreVazio() {
		int k= p1.getScore();
		assertEquals(0,k);
	}	
	@Test
	
	public void testGetScoreEmpty() {
		p1.add(1, new int[] {1, 2, 3, 4, 5});
		p1.add(2, new int[] {1, 2, 3, 4, 5});
		p1.add(3, new int[] {1, 2, 3, 4, 5});
		p1.add(4, new int[] {1, 2, 3, 4, 5});
		p1.add(5, new int[] {1, 2, 3, 4, 5});
		p1.add(6, new int[] {1, 2, 3, 4, 5});
		p1.add(7, new int[] {1, 2, 3, 4, 5});
		p1.add(8, new int[] {1, 2, 3, 4, 5});
		p1.add(9, new int[] {1, 2, 3, 4, 5});
		p1.add(10, new int[] {1, 2, 3, 4, 5});
		int k= p1.getScore();
		assertEquals(35,k);
	}
	
	@Test
	public void testGetScoreFullHandFalha() {
		p1.add(7, new int[] {3, 3, 3, 4, 4});
		p1.add(2, new int[] {1, 2, 3, 4, 5});
		p1.add(7, new int[] {2, 2, 2, 4, 5});
		p1.add(1, new int[] {1, 1, 3, 2, 1});
		p1.add(7, new int[] {2, 2, 3, 3, 2});
		p1.add(4, new int[] {1, 2, 5, 4, 5});
		p1.add(8, new int[] {1, 2, 3, 4, 5});
		p1.add(5, new int[] {1, 2, 3, 4, 5});
		p1.add(6, new int[] {6, 6, 3, 4, 5});
		p1.add(9, new int[] {3, 3, 1, 3, 3});
		int k= p1.getScore();
		assertEquals(91,k);
	}
	
	@Test
	public void testGetScoreNormal() {
		p1.add(7, new int[] {3, 3, 3, 4, 4});
		p1.add(5, new int[] {1, 2, 3, 4, 5});
		p1.add(2, new int[] {2, 2, 2, 5, 5});
		p1.add(1, new int[] {1, 1, 3, 2, 1});
		p1.add(3, new int[] {1, 2, 3, 3, 2});
		p1.add(4, new int[] {1, 2, 4, 4, 5});
		p1.add(8, new int[] {2, 3, 4, 5, 6});
		p1.add(6, new int[] {6, 6, 3, 4, 5});
		p1.add(9, new int[] {3, 3, 3, 1, 3});
		p1.add(10, new int[] {6, 6, 6, 6, 6});
		int k= p1.getScore();
		assertEquals(145,k);
	}
	
	@Test
	public void testGetScoreSequenciaFalha() {
		p1.add(9, new int[] {6, 4, 4, 4, 4});
		p1.add(8, new int[] {5, 4, 3, 6, 5});
		p1.add(8, new int[] {1, 2, 3, 4, 6});
		p1.add(5, new int[] {1, 2, 3, 4, 5});
		p1.add(2, new int[] {2, 2, 2, 5, 5});
		p1.add(1, new int[] {1, 1, 3, 2, 1});
		p1.add(3, new int[] {1, 2, 3, 3, 2});
		p1.add(4, new int[] {1, 2, 4, 4, 5});
		p1.add(8, new int[] {1, 2, 3, 4, 5});
		p1.add(10, new int[] {6, 6, 6, 6, 6});
		int k= p1.getScore();
		assertEquals(98,k);
	}
	
	@Test
	public void testGetScoreQuina() {
		p1.add(9, new int[] {3, 1, 3, 3, 3});
		p1.add(10, new int[] {3, 3, 3, 3, 3});
		p1.add(8, new int[] {1, 4, 3, 6, 5});
		p1.add(7, new int[] {2, 2, 2, 1, 3});
		p1.add(10, new int[] {1, 1, 1, 1, 1});
		p1.add(3, new int[] {1, 2, 3, 3, 2});
		int k= p1.getScore();
		assertEquals(76,k);
	}
	
	@Test
	public void testGetScoreQuadra() {
		p1.add(9, new int[] {2, 2, 2, 2, 3});
		int k= p1.getScore();
		assertEquals(30,k);
	}
	
	
	@Test
	public void toStringPreenchido() throws IllegalArgumentException, IOException{
		String recebido = "";
		
		p1.add(1, new int[] {1, 2, 3, 4, 5} );
		p1.add(2, new int[] {1, 2, 3, 4, 5} );
		p1.add(3, new int[] {1, 2, 3, 4, 5} );
		p1.add(4, new int[] {1, 2, 3, 4, 5} );
		p1.add(5, new int[] {1, 2, 3, 4, 5} );
		p1.add(6, new int[] {1, 2, 3, 4, 5} );
		p1.add(7, new int[] {1, 2, 3, 4, 5} );
		p1.add(8, new int[] {1, 2, 3, 4, 5} );
		p1.add(9, new int[] {1, 2, 3, 4, 5} );
		p1.add(10, new int[] {1, 2, 3, 4, 5} );
		
		recebido += ("  " + p1.resultado[0] + "  |");
		recebido += ("  " + p1.resultado[6] + "  |");
		recebido += ("  " + p1.resultado[3] + "  |");
		
		recebido += '\n';
		recebido += ("------------------------\n");
		
		recebido += ("  " + p1.resultado[1] + "  |");
		recebido += ("  " + p1.resultado[7] + "  |");
		recebido += ("  " + p1.resultado[4] + "  |");
		
		recebido += '\n';
		recebido += ("------------------------\n");
		
		recebido += ("  " + p1.resultado[2] + "  |");
		recebido += ("  " + p1.resultado[8] + "  |");
		recebido += ("  " + p1.resultado[5] + "  |");
		
		recebido += '\n';
		recebido +=("------------------------\n");
		
		recebido += ("        |"  + "  " + p1.resultado[9] + "   " +  "|   ");
		
		recebido +='\n';
		recebido +=("       x-------x        \n");
		
		assertEqualsArray(p1.toString(), recebido);
	}

	
	@Test
	public void toStringNulo() throws IllegalArgumentException, IOException{
		String recebido = "";
	
		recebido += ("  (1)  |");
		recebido += ("  (7)  |");
		recebido += ("  (4)  |");
		
		recebido += '\n';
		recebido += ("------------------------\n");
		
		recebido += ("  (2)  |");
		recebido += ("  (8)  |");
		recebido += ("  (5)  |");
		
		recebido += '\n';
		recebido += ("------------------------\n");
		
		recebido += ("  (3)  |");
		recebido += ("  (9)  |");
		recebido += ("  (6)  |");
		
		recebido += '\n';
		recebido +=("------------------------\n");
		
		recebido += ("       |  (10)  |       ");
		
		recebido +='\n';
		recebido +=("       x-------x        \n");
		
		assertEqualsArray(p1.toString(), recebido);
	}
	
	
	private void assertEqualsArray(String string, String retorno) {
		// TODO Auto-generated method stub
		
	}
}