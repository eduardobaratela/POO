import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DicionarioTest {
	
	private Dicionario<Integer, Integer> d;

	@Before
	public void setUp() throws Exception {
		d = new Dicionario<Integer, Integer>();
		d.add(0, 20);
		d.add(1, 40);
		d.add(2, 60);
	}
	
	@After
	public void tearDown() {
		d = null;
	}

	@Test
	public void testAdd(){
		assertEquals(d.getValor(0), (Integer)20);
	}

	@Test
	public void testGetValor() {
		assertEquals(d.getValor(1), (Integer) 40);
	}

	@Test
	public void testContainsValue() {
		assertTrue(d.containsValue(20));
	}

	@Test
	public void testContainsKey() {
		assertEquals(d.containsKey(1), true);
	}

}
