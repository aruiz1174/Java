package BubbleSelSort;
/**
 * 
 * @author Anibal Ruiz
 *
 */

public class Person implements Comparable<Person>
{
	private String firstName;
	private String lastName;
	private int id;
	
	/**
	 * Parameterized Constructor: object that has first, last name and email.
	 * @param firstName
	 * @param lName
	 * @param id
	 */
	public Person(String firstName, String lName, int id) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lName;
		this.id = id;
	}


	/**
	 * 
	 * @return the first name.
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * set the first name of a person.
	 * @param firstName
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	

	/**
	 * 
	 * @return the last name.
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * set the last name of a person.
	 * @param lastName
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return the id.
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * set a new id for a person.
	 * @param email
	 */
	public void setEmail(int id) 
	{
		this.id = id;
	}
	
	
	/**
	 * toString: display first name, last name and email.
	 */
	public String toString() 
	{
		return "Person [first Name = " + firstName + ", last Name = " + lastName + ", Id = " + id + "]";
	}


	/**
	 * compare the Id, if the result is 0, then the Id's are equal.
	 */
	public int compareTo(Person o) {
	
		int result = id - o.id;
		return result;
	}
	

}

