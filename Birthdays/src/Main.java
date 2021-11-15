import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		ArrayList<ArrayOrderedList<Person>> array = new ArrayList<ArrayOrderedList<Person>>(12);
		ArrayOrderedList<Person> monthArray = new ArrayOrderedList<Person>(10); //
		
		for (int i = 0; i < 12; i++)
			 array.add(monthArray);
		
		Person aPerson;
		boolean none = true;
		File file = new File("Names.txt");
		Scanner sc = new Scanner(file);
		int i = 1;
		
		while(none) {
			aPerson = new Person(sc.nextLine(), i);
		//	if (array.get(aPerson.getBirthday().charAt(2)) == null)
		//			array.add(monthArray);
		//	monthArray.add(aPerson); //
			//array[(Integer.parseInt(aPerson.getBirthday().substring(0, 2)] = monthArray;
			array.get(Integer.parseInt(aPerson.getBirthday().substring(0, 2))).add(aPerson);
		
			if(aPerson.getBirthday().equals(monthArray.first().getBirthday()))
				none = false;
			//none = aPerson.compareElements(monthArray);
			i++;
		}
		System.out.println("\n" + array.size() + 
				" people were needed to get two matching birthdays");
		int length = array.size();
		for (int j = 0; j < length; j++) {
			System.out.println(array.get(j).toString());
		}
		sc.close();
	}

}
