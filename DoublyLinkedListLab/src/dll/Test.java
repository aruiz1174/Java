package dll;
import java.util.NoSuchElementException;

public class Test 
{

	public static void main(String[] args) 
	{
		//long start = System.currentTimeMillis();
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		
		dll.addToRear(10);
		dll.addToRear(20);
		dll.addToRear(30);
		
		
		while(dll.size() > 0)
			System.out.println("removing from front " + dll.removeFromRear());
				
		try{
			dll.removeFromFront();
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("error removing from front " + ex.getMessage());
		}
			
		dll.addToFront(10);
		dll.addToFront(20);
		dll.addToFront(30);
		
	
		
		System.out.println(dll);
		System.out.println("Item at position 2 is " + dll.get(2));
		
		
		System.out.println("Reverse is :");
	    System.out.println(dll.reverseString());
		
		System.out.println(dll);
		
		dll.removeFromRear();
		
		System.out.println(dll);
		
		System.out.println("Getting item at pos 1: " + dll.get(1));
		
		try{
			System.out.println("Getting item at pos 4: " + dll.get(4));
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("error: " + ex.getMessage());
		}
		
		
		System.out.println("\n***********************************************\nLAB 2:\n");
		
		dll.addToFront(10);
		dll.addToFront(20);
		dll.addToFront(30);
		
		System.out.println("print the double linked list Not using iterator:\n" + dll);
		
		System.out.println("Now, using iterator:");
		
		for (Integer i : dll) 
		{
			System.out.println(i); 
		}
		//long end = System.currentTimeMillis();
		//System.out.println(end-start);
		
	}

}
