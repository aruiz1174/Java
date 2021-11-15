package heap;


/*
 * CSC 230 Lab 6
 * Student author: Anibal Ruiz, N00866307
 * 
 * 
 * Help from (person/websites etc) : GeeksForGeeks
 *                                   Tony Ruiz
 * 
 */
public class Heap 
{


	private int[] a;
	private int numOfItems;


	public Heap() 
	{
		a = new int[10];
		numOfItems = 0;
	}

	// return index of i's left child according to formula given in class
	private int left(int i) 
	{
		return 2 * i + 1;
		
	}

	// return index of i's right child according to formula given in class
	private int right(int i) 
	{
		return 2 * (i + 1);
		
	}

	// return index of i's parent according to formula given in class
	private int parent(int i) 
	{
		return (i - 1) / 2;
		
	}

	private void resize() 
	{
		int [] b = new int[a.length * 2];

		System.arraycopy(a, 0, b, 0, numOfItems);

		a = b;
	}

	public boolean add(int x) 
	{

		if (numOfItems + 1 > a.length) 
			resize();

		// add item at numOfItems and increment numOfItems by 1
		a[numOfItems] = x;
		
		numOfItems++;
		// call to rearrange tree starting from item just added
		heapifyUp(numOfItems - 1);

		return true;
	}

	/*
	 * this method takes in an index which is index of current item that was just added.
	 * While you haven't reached root keep checking if the parent of item is larger than
	 * item at i. If it is then swap item with its parent, if not then stop checking.
	 * Remember root is at position 0 and you have a parent method
	 */
	private void heapifyUp(int i) 
	{
		int temp = a[i];
		int j = i;
		while(i > 0 && temp < a[j])
		{
			swap(i, parent(j));
			j--;
		}
	}

	private void swap(int i, int j) 
	{
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}

	public int remove() {
		int x = a[0];

		// place item from end of list to root then decrement numOfItems by 1
		a[0] = a[numOfItems - 1];
		numOfItems--;

		// call to rearrange tree starting from root
		heapifyDown(0);

		

		return x;
	}

	/* this method takes in an index which is index of item that was just put in at the tree's root
	 * after removing the root item.
	 * 
	 * check this item's children one at a time. Record position of lowest child item. Then swap 
	 * with that child. Keep going until you don't have any more children.
	 * Remember that you may not have children or you may not have a right child.
	 */

	private void heapifyDown(int i) 
	{
		int minChild;
		if(left(i) < numOfItems && a[left(i)] < a[i])
		{
			minChild = left(i);
		}
		else
			minChild = i;
		
		if(right(i) < numOfItems && a[right(i)] < a[minChild])
			minChild = right(i);
		
		if(minChild != i)
		{
			swap(i, minChild);
			heapifyDown(minChild); //recursion until minChild is at top
		}
		
        
	}

	/**
	 * 
	 * @return
	 */
	public int size() 
	{
		return numOfItems;
	}

	
	public static void main(String[] args)
	{

		int a[] = {10, 5, 2, 30, 1, 0}; // starting test, you should test with more than this

		Heap h = new Heap();

		for(int i = 0; i < a.length; i++)
			h.add(a[i]);


		System.out.println();

		int size = h.size();


		for(int i = 0; i < size; i++)
			System.out.println(h.remove());

		// above should print 1 2 3

	}




}
