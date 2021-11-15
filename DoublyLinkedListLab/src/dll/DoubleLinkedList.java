package dll;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Title: Doubly Linked List:  contains an extra pointer, 
 * typically called previous pointer, together with next pointer 
 * and data which are there in singly linked list.
 * 
 * @author Anibal Ruiz N00866307
 * help by: Tony Ruiz
 * #ID: N00866307
 * Concepts Retrieved from "Data Structure & algorithms" 6th edition by Michael T. Goodrich.
 * 
 * @param <E>
 */

public class DoubleLinkedList<E> implements Iterable<E>
{	
	
	@SuppressWarnings("hiding")
	class Node<E> 
	{
		/**
		 * A representation of a node (element) in an XML document. 
		 * This interface extends the standard DOM Node interface with 
		 * methods for getting and setting the value of a node, f
		 * or getting and setting the parent of a node, and for removing a node.
		 * 
		 * @author Anibal Ruiz
		 *
		 */
		
		private E data;

		private Node<E> next;
		private Node<E> prev;
		
		/**
		 * default constructor
		 */
		public Node()
		{
			data = null;
			next = null;
			prev = null;
		}
		
		/**
		 * Parameterized constructor
		 * @param data the value
		 * @param next 
		 */
		public Node(E data, Node<E> next) 
		{
			this.data = data;
			this.next = next;
			this.prev = null;
		}
		
		/**
		 * getData - get the data of the node.
		 * @return the value of data.
		 */
		public E getData() 
		{
			return data;
		}
		
		public Node<E> getNext()
		{
			return next;
		}

		public String toString()
		{
			return data.toString();
		}
	}
	
	/**
	 * 
	 * Inner class for the double Linked list that Implements iterators.
	 * If the next object exist, continuing iterating, and return the object.
	 * 
	 */
	@SuppressWarnings("hiding")
	private class DoubleLinkedListIterator implements Iterator<E>
	{
		private Node<E> currentNode = front;

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 */
		public boolean hasNext() 
		{
			return (currentNode != null);
		}
		

		/**
		 *  Returns the next element in the iteration. If there are no
		 *  more elements in this iteration, a NoSuchElementException is thrown.
		 */
		public E next() 
		{
			if (currentNode == null)
		         throw new NoSuchElementException();

		      E result = currentNode.data;
		      currentNode = currentNode.next;
		      return result;
		}

	}

	
	/**
	 * return the iterator class
	 */
	public Iterator<E> iterator() 
	{
		return new DoubleLinkedListIterator();
	}
	
	private Node<E> front;
	private Node<E> rear;
	private int size;


	/**
	 * size method - Returns the number of elements in this list.
	 * @return the size of the doubly linked list
	 */
	public int size() 
	{
		return size;
	}


	/**
	 * addToRear method - add a new node to the rear of the list
	 * @param data the data to be added in the new node
	 */
	public void addToRear(E data) 
	{
		//create the new node
		Node<E> n = new Node<E>(data, null);
		
		//special case
		if(size == 0)
		{
			rear = front = n;
			//size++;
		}
		
		else
		{
			n.prev = rear;
			rear.next = n;
			rear = n;
			
			//size++;
		}
		size++;
			
	}

	/**
	 * addToFront - add a new node to the rear of the list, 
	 * Inserts the specified element at the beginning of this list.
	 * @param data the data to be added in the new node.
	 */
	public void addToFront(E data) 
	{
		//create the new node
		Node<E> n = new Node<E>(data, front);
		
		if(size == 0)
		{
			front = rear = n;
			//size++;
		}
		
		else
		{
			front.prev = n;
			front = n;
			//size++;
		}
	
		size++;
	}
	
	
	// should throw NoSuchElementException if it can't remove
	/**
	 * removeFromRear method - remove the node in the rear.
	 * @return a node containing the data of rear.
	 */
	public E removeFromRear() 
	{
		//check for any exeption
		if(size == 0)
			throw new NoSuchElementException();
		
		E temp = rear.data;
		
		//special case
		if(size == 1)
		{
			
			rear = null;
			front =rear;
		}
		else
		{
			
			rear = rear.prev;
			rear.next = null;
		}
		size--;



		return temp;


	}
	
	// should throw NoSuchElementException if it can't remove
	/**
	 * removeFromFront method - remove the node in the front.
	 * @return a node containing the data of front.
	 */
	public E removeFromFront() 
	{
		//check any exception
		if(size == 0)
			throw new NoSuchElementException();

		E temp = front.data;
		
		//special case
		if(size == 1)
		{
			front = null;
			rear = front;
		}
		else
		{
			front = front.next;
			front.prev = null;
		}
		size--;



		return temp;

	
	}
	
	// takes in 0 based position, should throw NoSuchElementException if it can't remove
	//CODE BASED ON MY LinkedList from CSC130
	/**
	 * get method - this method search for a specified data in a specific position.
	 * @param pos the position to search.
	 * @return the data in that position.
	 * 
	 * CODE IMPLEMENTED IN MY CSCS130 course
	 */
	public E get(int pos)
	{
		//check for any exception
		if(pos < 0 || pos >= size)
			throw new NoSuchElementException();
		
		//create a node that point to front
		Node<E> trav = front;
		//when the position is found, the for loop stops.
		for(int i = 0; i < pos; i++)
		{
			trav = trav.next;
		}
		return trav.data;

	}

	/**
	 * return the state of the doubly linked list
	 * @author -Anibal Ruiz. help from: Tony Ruiz 
	 */
	public String toString() 
	{
		StringBuilder str = new StringBuilder();
		Node<E> current = front;
		for(int i = 0; i < size; i++)
		{
			str.append(current.data);
			str.append(" \n");
			current = current.next;
		}
		return str.toString();
	}

	
	/**
	 * reverseString - reverse the list.
	 * @return a string representing the data in reverse order.
	 * @author -Anibal Ruiz. help from: Tony Ruiz 
	 */
	public String reverseString()
	{

		//print elements from rear to front
		StringBuilder str = new StringBuilder();
		Node<E> current = rear;
		for(int i = size-1; i >= 0; i--)
		{
			str.append(current.data + " \n");
			current = current.prev;
		}
		return str.toString();
        
	
	}
}
	
	
	
	