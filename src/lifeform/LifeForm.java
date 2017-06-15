package lifeform;

import gameplay.SimpleTimer;
import gameplay.TimeObserver;
import gameplay.Timer;
import weapon.Weapon;


/**
 * 
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form
 *@author Ryan Campbell, Deema Alrashdan
 */
public class LifeForm implements TimeObserver
{
	protected String myName;
	protected int currentLifePoints;
	protected int attackPoints;
	protected Timer tracker;
	protected int round;
    protected Weapon baseWeapon;
	
	/**
	 * pickUpWeapon
	 * Life form pickup a weapon if doesn't have a weapon
	 * @param wp the weapon to pickup
	 */
	public void pickUpWeapon(Weapon wp)
	{
		if(baseWeapon == null)
		{
			baseWeapon = wp;
		}
	}
	
	/**
	 * dropWeapon
	 * Life form drop the weapon 
	 */
	public void dropWeapon()
	{
		baseWeapon = null;
	}
	
	/**
	 * create an instance
	 * 
	 * @param name the name of the life form
	 * @param points the current starting life points of the life form
	 * @param ap 
	 */
	public LifeForm(String name, int hp) 
	{
		// TODO Auto-generated constructor stub
		myName = name;
		currentLifePoints = hp;
		if(currentLifePoints < 0)
		{
			currentLifePoints = 0;
		}
	}
	public LifeForm(String name, int hp, int ap)
	{
		this(name, hp);
		attackPoints = ap;
	}
	/**
	 * 
	 * @return the name of the life form.
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return myName;
	}
	/**
	 * 
	 * @return the amount of current life points the life form has.
	 */
	public int getCurrentLifePoints() {
		// TODO Auto-generated method stub
		return currentLifePoints;
	}
	/**
	 * reduces current life points by the damage amount
	 * @param damage amount to reduce current life points
	 */
	public void takeHit(int damage)
	{
		currentLifePoints -= damage;
		if (currentLifePoints < 0)
		{
			currentLifePoints = 0;
		}
	}
	/**
	 * attack method for when weapon is equipped
	 * @param distance distance between attacking and receiving lifeforms
	 * @return damage value of weapon
	 */
	public int attack(int distance)
	{
		if (currentLifePoints == 0)
		{
			return 0;
		}
		// TODO Auto-generated method stub
		else if (baseWeapon == null)
			return attackPoints;
		else
		{
			return baseWeapon.damage(distance);
		}
	}
	/**
	 * attack method for no weapon
	 * @return lifeForm's  attack strength
	 */
	public int attack()
	{
		if (currentLifePoints == 0)
		{
			return 0;
		}
		// TODO Auto-generated method stub
		else 
			return attackPoints;
	}
	protected void setAttackPoints(int sap)
	{
		attackPoints = sap;
	}
	public void addTimer(SimpleTimer timr)
	{
		tracker = timr;
		
	}
	@Override
	public void updateTime(int time)
	{
		round = tracker.getRound();
		
	}
}

