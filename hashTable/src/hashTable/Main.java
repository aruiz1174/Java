package hashTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Title: Application class
 * @author Anibal Ruiz (Help: Tony Ruiz)
 *Description: You will need to add a main class and read data from
 * the csv file and put it into the hashtable.
 */
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner scan;
		SimpleHashTable<LastName, Person> hash = new SimpleHashTable<LastName, Person>();
		
		try 
		{
			scan = new Scanner(new File("MOCK_DATA.csv"));
			scan.nextLine();
			while(scan.hasNextLine())
			{
				//csv COMMA SEPARATION
				
				String newLine = scan.nextLine();
				String split[] = newLine.split(",");
				
				String fName = split[0];
				LastName lName = new LastName(split[1]);
				String email = split[2];
				
				Person person = new Person(fName, lName, email);
				
				hash.put(lName, person);
			}
		} 
		catch (FileNotFoundException ex) 
		{
			
			System.out.println(ex.getMessage());
		}
		
		System.out.println(hash);
		
		
		
		/**
		 * now, test the get method with a person in the list, and one person who is
		 *  not in the list.
		 */
		
		LastName last = new LastName("Trapp");
	//	hash.get(last);
		
		//test the get method with a right last name
		System.out.println("Get Trapp's information: " + hash.get(last));
		
		try
		{
			LastName last2 = new LastName("Ruiz");
			System.out.println("Get Ruiz's information: " + hash.get(last2));
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("Last name -Ruiz- not found.");
		}
		
		
	
		
	}

}
