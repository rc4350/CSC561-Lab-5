package environment;
import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;
/**
 * Test Environment class
 * @author Ryan Campbell
 *
 */
public class TestEnvironment {

	
	
	//lab 1-2 tests
	@Test
	public void testInitialize() {
		Environment myenv = new Environment(1,1);
		assertNotNull(myenv);
	}
	@Test
	public void testAddCell()
	{
		Environment myenv = new Environment(2, 3);
		LifeForm bob = new MockLifeForm("Bob", 40);
		boolean success;
		success = myenv.addLifeForm(bob, 0, 1);
		assertTrue(success);
		assertEquals(bob, myenv.getLifeForm(0, 1));
	}
	@Test
	public void testRemove()
	{
		Environment myenv = new Environment(2,3);
		LifeForm bob = new MockLifeForm("Bob", 40);
		myenv.addLifeForm(bob, 0, 1);
		boolean success;
		success = myenv.removeLifeForm(0,1);
		assertTrue(success);
	}
	@Test
	public void testBound()
	{
		Environment myenv = new Environment(1,1);
		LifeForm bob = new MockLifeForm("Bob", 40);
		boolean success;
		success = myenv.addLifeForm(bob, 0, 1);
		assertFalse(success);
		
		success = myenv.removeLifeForm(0, 1);
		assertFalse(success);
		
	}
}
