package hashTable;
/**
 * 
 * @author Anibal Ruiz
 *
 */
public class Person 
{
	private String firstName;
	private LastName lastName;
	private String email;
	
	/**
	 * Parameterized Constructor: object that has first, last name and email.
	 * @param firstName
	 * @param lName
	 * @param email
	 */
	public Person(String firstName, LastName lName, String email) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lName;
		this.email = email;
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
	public LastName getLastName() 
	{
		return lastName;
	}

	/**
	 * set the last name of a person.
	 * @param lastName
	 */
	public void setLastName(LastName lastName) 
	{
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return the email.
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * set a new email for a person.
	 * @param email
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
	/**
	 * toString: display first name, last name and email.
	 */
	public String toString() 
	{
		return "Person [first Name = " + firstName + ", last Name = " + lastName + ", email = " + email + "]";
	}
	

}
