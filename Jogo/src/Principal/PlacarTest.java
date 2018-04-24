package Principal;

import static org.junit.Assert.assertEquals; 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlacarTest {
	
	private Placar pl;

	@Before
	public void setUp() throws Exception {
		pl = new Placar();
	}
	
	@After
	public void tearDown() {
		pl = null;
	}
	
	
	@Test
	public void test1() {
		Placar pl = new Placar();
		pl.add(1, new int[] {1, 2, 3, 4, 5} );
		pl.add(2, new int[] {1, 2, 3, 4, 5} );
		pl.add(3, new int[] {1, 2, 3, 4, 5} );
		pl.add(4, new int[] {1, 2, 3, 4, 5} );
		pl.add(5, new int[] {1, 2, 3, 4, 5} );
		pl.add(6, new int[] {2, 2, 3, 4, 2} );
		pl.add(7, new int[] {1, 1, 3, 4, 1} );
		pl.add(8, new int[] {1, 2, 3, 4, 5} );
		pl.add(9, new int[] {1, 1, 1, 1, 5} );
		pl.add(10, new int[] {1, 2, 3, 4, 5} );
		int k = pl.getScore();
		assertEquals(65, k);
	}
	
	@Test
	public void test2() {
		Placar pl = new Placar();
		pl.add(1, new int[] {2, 3, 4, 5, 2} );
		pl.add(2, new int[] {3, 3, 3, 5, 5} );
		pl.add(3, new int[] {6, 5, 5, 6, 6} );
		pl.add(4, new int[] {2, 2, 3, 2, 3} );
		pl.add(5, new int[] {3, 3, 3, 4, 4} );
		pl.add(6, new int[] {4, 4, 3, 3, 3} );
		pl.add(7, new int[] {2, 2, 1, 2, 1} );
		pl.add(8, new int[] {3, 2, 4, 5, 6} );
		pl.add(9, new int[] {4, 4, 4, 5, 4} );
		pl.add(10, new int[] {2, 3, 4, 5, 6} );
		int k = pl.getScore();
		assertEquals(65, k);
	}
	
	@Test
	public void test3() {
		Placar pl = new Placar();
		pl.add(1, new int[] {2, 3, 4, 5, 2} );
		pl.add(2, new int[] {3, 3, 3, 5, 5} );
		pl.add(3, new int[] {6, 5, 5, 6, 6} );
		pl.add(4, new int[] {2, 2, 3, 2, 3} );
		pl.add(5, new int[] {3, 3, 3, 4, 4} );
		pl.add(6, new int[] {4, 4, 3, 3, 3} );
		pl.add(7, new int[] {1, 2, 1, 2, 4} );
		pl.add(8, new int[] {3, 3, 4, 5, 4} );
		pl.add(9, new int[] {5, 5, 4, 5, 5} );
		pl.add(11, new int[] {2, 3, 4, 5, 6} );
		int k = pl.getScore();
		assertEquals(30, k);
	}
	
	@Test
	public void test4() {
		Placar pl = new Placar();
		pl.add(1, new int[] {2, 3, 4, 5, 2} );
		pl.add(2, new int[] {3, 3, 3, 5, 5} );
		pl.add(3, new int[] {6, 5, 5, 6, 6} );
		pl.add(4, new int[] {2, 2, 3, 2, 3} );
		pl.add(5, new int[] {3, 3, 3, 4, 4} );
		pl.add(6, new int[] {4, 4, 3, 3, 3} );
		pl.add(7, new int[] {3, 3, 2, 3, 2} );
		pl.add(8, new int[] {3, 3, 4, 5, 4} );
		pl.add(9, new int[] {5, 4, 5, 5, 5} );
		pl.add(11, new int[] {2, 3, 4, 5, 6} );
		int k = pl.getScore();
		assertEquals(45, k);
	}
	
	@Test
	public void test5() {
		Placar pl = new Placar();
		pl.add(1, new int[] {2, 3, 4, 5, 2} );
		pl.add(2, new int[] {3, 3, 3, 5, 5} );
		pl.add(3, new int[] {6, 5, 5, 6, 6} );
		pl.add(4, new int[] {2, 2, 3, 2, 3} );
		pl.add(5, new int[] {3, 3, 3, 4, 4} );
		pl.add(6, new int[] {4, 4, 3, 3, 3} );
		pl.add(7, new int[] {4, 4, 3, 3, 4} );
		pl.add(8, new int[] {3, 3, 4, 5, 4} );
		pl.add(9, new int[] {4, 5, 5, 5, 5} );
		pl.add(11, new int[] {2, 3, 4, 5, 6} );
		int k = pl.getScore();
		assertEquals(45, k);
	}
	
	@Test
	public void test6() {
		Placar pl = new Placar();
		pl.add(1, new int[] {2, 3, 4, 5, 2} );
		pl.add(2, new int[] {3, 3, 3, 5, 5} );
		pl.add(3, new int[] {6, 5, 5, 6, 6} );
		pl.add(4, new int[] {2, 2, 3, 2, 3} );
		pl.add(5, new int[] {3, 3, 3, 4, 4} );
		pl.add(6, new int[] {4, 4, 3, 3, 3} );
		pl.add(7, new int[] {5, 4, 5, 4, 5} );
		pl.add(11, new int[] {3, 3, 4, 5, 4} );
		pl.add(9, new int[] {5, 5, 5, 5, 5} );
		pl.add(10, new int[] {5, 5, 5, 5, 5} );
		int k = pl.getScore();
		assertEquals(55, k);
	}
	
	@Test
	public void test7() {
		Placar pl = new Placar();
		pl.add(1, new int[] {2, 3, 4, 5, 2} );
		pl.add(2, new int[] {3, 3, 3, 5, 5} );
		pl.add(3, new int[] {6, 5, 5, 6, 6} );
		pl.add(4, new int[] {2, 2, 3, 2, 3} );
		pl.add(5, new int[] {3, 3, 3, 5, 5} );
		pl.add(6, new int[] {4, 4, 3, 3, 3} );
		pl.add(7, new int[] {6, 1, 6, 2, 6} );
		pl.add(11, new int[] {3, 3, 4, 5, 4} );
		pl.add(9, new int[] {5, 5, 5, 5, 5} );
		pl.add(10, new int[] {5, 5, 5, 5, 5} );
		int k = pl.getScore();
		assertEquals(50, k);
	}

	@Test
	public void testGetScoreVazio(){
		int k = pl.getScore();
		assertEquals(0, k);
	}

	@Test
	public void testToStringCheia() {
		String resp = new String();
		
		Placar pl = new Placar();
		pl.add(1, new int[] {1, 2, 3, 4, 5} );
		pl.add(2, new int[] {1, 2, 3, 4, 5} );
		pl.add(3, new int[] {1, 2, 3, 4, 5} );
		pl.add(4, new int[] {1, 2, 3, 4, 5} );
		pl.add(5, new int[] {1, 2, 3, 4, 5} );
		pl.add(6, new int[] {2, 2, 3, 4, 6} );
		pl.add(7, new int[] {2, 2, 3, 3, 2} );
		pl.add(8, new int[] {1, 2, 3, 4, 5} );
		pl.add(9, new int[] {1, 1, 1, 1, 5} );
		pl.add(10, new int[] {1, 1, 1, 1, 1} );
		
		resp += ("   " + pl.resultado[0] + "   |");
		resp += ("  " + pl.resultado[6] + "   |");
		resp += ("  " + pl.resultado[3] + "   |");
		resp += ("\n------------------------\n");
		resp += ("   " + pl.resultado[1] + "   |");
		resp += ("  " + pl.resultado[7] + "   |");
		resp += ("  " + pl.resultado[4] + "   |");
		resp += ("\n------------------------\n");
		resp += ("  " + pl.resultado[2] + "   |");
		resp += ("  " + pl.resultado[8] + "   |");
		resp += ("  " + pl.resultado[5] + "   |");
		resp +=("\n------------------------\n");	
		resp += ("       |"  + "  " + pl.resultado[9] + "   " +  "|   ");
		resp +=("\n       x-------x        \n");
		
		assertEquals(pl.toString(), resp);
	}
	
	@Test
	public void toStringVazio() {
		String resp = new String();
		
		resp +=("  (1)  |");
		resp += ("  (7)  |");
		resp += ("  (4)  |");
		
		resp += ("\n------------------------\n");
		
		resp +=("  (2)  |");
		resp +=("  (8)  |");
		resp +=("  (5)  |");
		
		resp += ("\n------------------------\n");
		
		resp += ("  (3)  |");
		resp += ("  (9)  |");
		resp += ("  (6)  |");
		
		resp +=("\n------------------------\n");
		
		resp += ("       |  (10) |         ");
		
		resp +=("\n       x-------x        \n");
		
		assertEquals(pl.toString(), resp);
	}

}
