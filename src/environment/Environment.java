package environment;

import lifeform.LifeForm;

/**
 * Holds 2D array of cells
 * and can add or remove lifeforms from cells 
 * @author Ryan Campbell
 *
 */
public class Environment {
	private Cell cell[][];  
	private int myrow;
	private int mycol;
	
	
	/**
	 * 
	 * @param row the number of rows
	 * @param col the number of columns
	 */
	public Environment(int row, int col) {
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
		{
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
			return cell[rerow][recol].removeLifeForm();
	}
}
