
/** Title: ArrayOrderedList Class
 *
 * Description: Represents an array implementation of an ordered list.
 *    Provides basic array functionality, including the ability
 *    to add elements to the list. Get the item at a specific location by performing binary search
 *    in case the array contains it. 
 */
public class ArrayOrderedList<E extends Comparable<E>> extends ArrayList<E> implements OrderedListADT<E>
{
	/**
	 * default constructor -- 
	 * creates an empty list using the default capacity.
	 */
	public ArrayOrderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 * @param initialCapacity the initial size of the list as specified by the user
	 */
	public ArrayOrderedList (int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * add --
	 * adds the specified Comparable item to this list, keeping
	 * the items in sorted order. The size of the list should be expanded when full.
	 * @param newItem a reference to the new item to be added to the list  
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public void add(E item)
	{
		Comparable<E> temp = (Comparable<E>)item;

		if (size() == contents.length)
			expandCapacity();

		int index = 0;
		while (index < count && temp.compareTo(contents[index]) > 0)
			index++;

		for (int i = count; i > index; i--)
		{
			contents[i] = contents[i-1];
		}
		contents[index] = item;
		count++;
	}
	
	public E getElement(int index) {
		return contents[index];
	}

	/**
	 * find --
	 * overrides the find method in the parent class, ArrayList. The efficiency of this 
	 * method is improved by terminating the linear search once you have gone beyond the
	 * position where the item might be found.  
	 * @param target a reference to the item to locate
	 * @return the index of the specified target if it is found; -1 if it
	 * is not found
	 */
	@SuppressWarnings("unchecked")
	protected int find(E target)
	{
		Comparable<E> temp = (Comparable<E>) target;
		int i = 0;


		while (i < count && temp.compareTo(contents[i]) > 0)
		{
			if (contents[i].equals(target))
				return i;
			i++;
		}
		if (i >= count)
			throw new ElementNotFoundException("element is not in the list");
		return i;
	}

	/**
	 * binSearch --
	 * locates and returns the target from the list if it is found
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @return a reference to the item from the list if found
	 * @throws an EmptyListException if the list is empty
	 * @throws an ElementNotFoundException if the target is not found
	 */
	@SuppressWarnings("unchecked")
	public E binSearch(E target)
	{
		int first = 0;
		int last = count - 1;
		int midPoint = (first + last) / 2;
		Comparable<E> temp = (Comparable<E>) target;


		while (first <= last)
		{
			if(temp.compareTo(contents[midPoint]) == 0)
			{
				return contents[midPoint];

			} 

			if(temp.compareTo(contents[midPoint]) < 0)
			{
				last = midPoint - 1;
				midPoint = (first + last ) / 2;
			}
			else //(temp.compareTo(contents[midPoint]) > 0);
			{
				first = midPoint + 1;
				midPoint = (first + last ) / 2;

			}
		}
		throw new ElementNotFoundException("element not in the list");

	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}



