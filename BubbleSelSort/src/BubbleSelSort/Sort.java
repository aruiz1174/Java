package BubbleSelSort;
/**
 * 
 * @author Anibal Ruiz
 * Help from: Tony Ruiz, and GeeksForGeeks website.
 * 
 * Sort list of objects using Bubble and selection sort,
 *  and a swap method to keep things simple.
 * 
 *
 * @param <E>
 */

public class Sort<E extends Comparable<E>> 
{
	
	/**
	 * BubbleSort - compare the first two values and change positions if the second one is less than the first one,
	 * keep comparing until you go through all the array.
	 * @param array
	 */
	@SuppressWarnings("unchecked")
	void BubbleSort(Comparable<E> array[]) 
	{
		//int u = 0;
		boolean done = true;
		for(int i = 0; i < array.length - 1 - i && done == true; i++)
		{
			done = false;
			for(int j = 0; j < array.length - 1; j++)
			{
				if((array[j].compareTo((E) array[j + 1])) > 0)
				{
					
					Swap(array, j, j+1);
					//System.out.println(array[j]);
					done = true;
				}
				//u++;
				//System.out.println(u);
			}
			
			//if(done == false) //Optimize, if the list is already sorted, it won't enter in the if statement.
			//	return;
			//System.out.println(u);
		}
		
	}
	
	
	/**
	 * SekectionSort - find the minimum value in the array and put it in the beginning, 
	 * then keep looking for the minimum again and put i the next spot until you reach the last value.
	 * @param array
	 */
	@SuppressWarnings("unchecked")
	void SelectionSort(Comparable<E> array[])
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			//find minimum
			int min = i;
			for(int j = i + 1; j < array.length; j++)
			{
				if((array[j].compareTo((E) array[min])) < 0)
					min = j;
				
				//Swap(array, min, i);
			}
			Swap(array, min, i); //the swap shoul not be in the inner loop
		}
		
		
	}


	/**
	 * Swap the Values in the array 
	 * @param array
	 * @param i
	 * @param j
	 */
	void Swap(Comparable<E>[] array, int i, int j) 
	{

		Comparable<E> temp = (Comparable<E>) array[i];
		array[i] = array[j];
		array[j] = temp;

	}
}
