package environment;

import lifeform.LifeForm;

/**
 * holds a LifeForm
 * @author Ryan Campbell
 *
 */
public class Cell {
	private LifeForm myLifeForm;
	public Cell()
	{
		myLifeForm = null;
	}
	/**
	 * 
	 * @return the LifeForm in this Cell
	 */
	public LifeForm getLifeForm() {
		// TODO Auto-generated method stub
		return myLifeForm;
	}
/**
 * 
 * Tries to add the LifeForm to the Cell. Will not add if
 * a LifeForm is already present.
 * @return true if the LifeForm was added to the Cell, false otherwise.
 */
	public boolean addLifeForm(LifeForm entity)
	{
		// TODO Auto-generated method stub
		if(myLifeForm == null) //checks that Life Form doesn't exist
		{
			myLifeForm = entity; //adds LifeForm
			return true;
		}
		else		//do not add if LifeForm already exists
			return false;
	}
public boolean removeLifeForm()
{
	// TODO Auto-generated method stub
	if(myLifeForm != null)
	{
		myLifeForm = null;
		return true;
	}
	else
	return false;
}

}
