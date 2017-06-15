package environment;
import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;
/**
 * tests functionality of Cell class
 * @author Ryan Campbell
 *
 */
public class TestCell {

	//lab 1-2 tests
	@Test
	public void testInitialization() 
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
	}

	@Test
	public void testSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		LifeForm fred = new MockLifeForm("Fred", 40);
		Cell cell = new Cell();
		//the cell is empty so this should work
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());
		//the cell is not empty so this should fail.
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}
	
	@Test
	public void testRemoveLifeForm()
	{
		Cell c = new Cell();
		LifeForm bob = new MockLifeForm("Bob", 40);
		c.addLifeForm(bob);
		boolean check = c.removeLifeForm();
		assertTrue(check);
	}
}
