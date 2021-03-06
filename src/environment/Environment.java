package environment;

import exceptions.MyNewException;
import lifeform.LifeForm;
import weapon.Pistol;
import weapon.Weapon;

/**
 * Holds 2D array of cells
 * and can add or remove lifeforms from cells 
 * @author Ryan Campbell
 *
 */
public class Environment 
{
	private static Environment theWorld;
	private Cell cell[][];  
	private int myrow;
	private int mycol;
	
	
	/**
	 * 
	 * @param row the number of rows
	 * @param col the number of columns
	 */
	private Environment(int row, int col) {
		//save number of rows and columns for bounds checks
		myrow = row; 
		mycol = col;
		cell = new Cell[row][col]; //initialize cell[][]
		for(int i = 0; i <row; i++)
		{
			for (int j = 0; j<col; j++)
				cell[i][j] = new Cell();
		}
		
	}
	/**
	 * initializes theWorld
	 * @param height
	 * @param width
	 * @throws MyNewException
	 */
	public static void initialize(int height, int width) throws MyNewException
	{
		if(theWorld == null)
		{
			theWorld = new Environment(height, width);
		}
		else
		{
			throw new MyNewException();
		}
	}
	/**
	 * 
	 * @return theWorld
	 */
	public static Environment getInstanceOf()
	{
		return theWorld;
	}
	/**
	 * resets environment for testing purposes
	 */
	protected static void reset()
	{
		theWorld = null;
	}
	
	/**
	 * 
	 * @param gcrow row index
	 * @param gccol column index
	 * @return LifeForm in cell at index
	 */
	public LifeForm getLifeForm(int gcrow, int gccol)
	{
		if(gcrow >= myrow || gccol >= mycol)
		{
			System.out.println("index out of bounds");
			return null;
		}
		else
			return cell[gcrow][gccol].getLifeForm();
	}
	/**
	 * adds lifeform to cell
	 * @param adlife lifeform to add
	 * @param adrow row index
	 * @param adcol column index
	 * @return true if successfully added, false if not
	 */
	public boolean addLifeForm(LifeForm adlife, int adrow, int adcol) {
		// TODO Auto-generated method stub
		if (adrow >= myrow || adcol >=mycol) //check that bounds are correct
		{
			return false;
		}
		else
		{	adlife.setLocation(adrow, adcol);
			return cell[adrow][adcol].addLifeForm(adlife);
		}
	}
	/**
	 * removes life form from cell
	 * @param rerow row index
	 * @param recol column index
	 * @return return true if lifeform was removed from cell
	 */
	public boolean removeLifeForm(int rerow, int recol) {
		// TODO Auto-generated method stub
		if (rerow >= myrow || recol >=mycol) //check bounds
		{
			return false;
		}
		else
			cell[rerow][recol].getLifeForm().setLocation(0, 0);
			return cell[rerow][recol].removeLifeForm();
	}
	/**
	 * get cell method for testing
	 */
	protected Cell getCell(int row, int col)
	{
		return cell[row][col];
	}
	/**
	 * adds a weapon to the cell if able
	 * @param wpn weapon to add
	 * @param row row of cell
	 * @param col column of cell
	 * @return false if out of bounds or unable to add weapon to cell
	 */
	public boolean addWeapon(Weapon wpn, int row, int col)
	{
		if (row >= myrow || col >=mycol) //check that bounds are correct
		{
			return false;
		}
		else
			return cell[row][col].addWeapon(wpn);
		
	}
	/**
	 * removes weapon from the cell if able
	 * @param wpn to remove
	 * @param row row of cell
	 * @param col column of cell
	 * @return returns false if out of bounds or unable to remove weapon
	 */
	public boolean removeWeapon(Weapon wpn, int row, int col)
	{
		if (row >= myrow || col >=mycol) //check that bounds are correct
		{
			return false;
		}
		else
			return cell[row][col].removeWeapon(wpn);
	}
	/**
	 * gets distance between two lifeforms
	 * @param lifeFormOne First Life Form
	 * @param lifeFormTwo Second Life Form
	 * @return distance between them
	 */
	public int getDistance(LifeForm lifeFormOne, LifeForm lifeFormTwo)
	{
		int oneLocation[];
		int twoLocation[];
		oneLocation = lifeFormOne.getLocation();
		twoLocation = lifeFormTwo.getLocation();
		if(oneLocation[0] == twoLocation[0])
		{
			int distance = (oneLocation[1] - twoLocation[1])*5;
			distance = Math.abs(distance);
			return distance;
		}
		else if (oneLocation[1] == twoLocation[1])
		{
			int distance = (oneLocation[0] - twoLocation[0])*5;
			distance = Math.abs(distance);
			return distance;
		}
		else
		{
			int x, y, distance;
			x =Math.abs((oneLocation[0] - twoLocation[0])*5);
			y =Math.abs((oneLocation[1] - twoLocation[1])*5);
			distance = (int) Math.sqrt((x*x)+(y*y));
			return distance;
			
		}
		
	}
}
