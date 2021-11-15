package hashTable;
/**
 * 
 * @author Anibal Ruiz (Help:Tony Ruiz and GeeksforGeeks website)
 *
 * Description: simply hold the last name of the person, will also have accessors,
 *  mutators, and have a hashCode method in it
 */
public class LastName 
{

	private String lastName;
	

	/**
	 * parameterized constructor: object that has a last name.
	 * @param last
	 */
	public LastName(String last)
	{
		super();
		lastName = last;
	}
	
	
	/**
	 * 
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * set the lastName with another last name.
	 * @param last
	 */
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	/**
	 * use the code we discussed in class to find a spot for every name.
	 * VALUE*31^n - i
	 */
	public int hashCode()
	{
		int i;
		int hash = 0;
		int len = lastName.length();
		//while(i < len+1)
		for(i = 1; i < len +1; i++)
		{
			//use Value * 31^(n - i)
			hash += (int)(((int)lastName.charAt(i-1)) * Math.pow(31, (len-i)));
			//i++;
		}
		return Math.abs(hash);
	}

	/**
	 * toString method
	 */
	public String toString() 
	{
		return lastName;
	}
}
