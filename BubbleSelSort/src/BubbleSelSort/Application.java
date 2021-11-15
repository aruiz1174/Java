package BubbleSelSort;
/**
 * 
 * @author Anibal Ruiz
 * 
 * Test the sort methods implemented in the sort class.
 * create objects for persons and put them in an array, then sort the list
 * based on the id.
 *
 */

public class Application 
/**
 * 
 */
{
	public static void main(String[] args)
	{
		
		Sort<Person> sort = new Sort<Person>();
		
		Person per1 = new Person("Anibal", "Ruiz", 2);
		Person per2 = new Person("Tony", "Bonilla", 1);
		Person per3 = new Person("Jenny", "Marti", 4);
		Person per4 = new Person("Wilmer", "jime", 3);
		Person per5 = new Person("Edward", "John", 7);
		Person per6 = new Person("Billy", "Rodriguez", 6);
		Person per7 = new Person("Karla", "Stark", 5);
		Person per8 = new Person("Sam", "Lannister", 8);
		
		Person[] person = {per1, per2, per3, per4, per5, per6, per7, per8};
		
		System.out.println("Display the list of persons:\n");
		for(Person p : person)
			System.out.println(p);
		
		sort.BubbleSort(person);
		//sort.SelectionSort(person);
		
		System.out.println("\nList sorted based on the Id after the Bubble Sort:\n");
		
		for(Person p : person)
			System.out.println(p);
		
		
		
		System.out.println("\n**********************************************************\n");
		
		
		
		
		Person[] person2 = {per1, per2, per3, per4, per5, per6, per7, per8};
		
		System.out.println("Display the list of persons again:\n");
		
		for(Person p : person2)
			System.out.println(p);
		
		sort.SelectionSort(person2);
		
		System.out.println("\nList sorted based on the Id after the Selection Sort:\n");
		
		for(Person p : person2)
			System.out.println(p);
	}

}
