package hashTable;

import java.util.NoSuchElementException;
/**
 * 
 * @author Anibal Ruiz (Help:Tony Ruiz and GeeksforGeeks website)
 * And notes for class. /home/cheung/teaching/web/323/Syllabus/Map/Progs/Goodrich
 * 
 * This class implements a hash table, which maps keys to values.
 *  Any non-null object can be used as a key or as a value.
 *  To successfully store and retrieve objects from a hashtable,
 *  the objects used as keys must implement the hashCode method
 *
 * @param <K>
 * @param <V>
 */
public class SimpleHashTable<K, V> 
{
	
	/**
	 *  instance vars:
	 *   an array of SimpleEntry called hashtable, use generics on declaration
	 */
	private SimpleEntry<K, V> hashtable[];
	

	
	/**
	 * default constructor, instantiate the array to size 5
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashTable() 
	{
		// when instantiating array you don't need generics
		hashtable = new SimpleEntry[5];
		
	}
	
	/**
	 * call hashCode method of key, compress value, then store key, value (SimpleEntry) at that position
	 *  up to you if you want to overwrite or not
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) 
	{
		int hashT = key.hashCode() % hashtable.length;
		SimpleEntry<K, V> newEntry = new SimpleEntry<K, V>(key, value);
		hashtable[hashT] = newEntry; //overwrite
		
	}
	
	/**
	 * return Value based on key or throw NoSuchElementException if it doesn't exist 
	 * @param key
	 * @return
	 */
	public V get(K key) 
	{
	
		int hash = key.hashCode() % hashtable.length;
		if((hashtable[hash] != null) && (hashtable[hash].getKey().toString().equals(key.toString())))
			return hashtable[hash].getValue();
		else
			throw new NoSuchElementException("No such element.");
		
	}
	
	/**
	 * get the person's info using the StringBuilder
	 */
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < hashtable.length; i++)
		{
			if(hashtable[i] != null)
			{
				str.append(hashtable[i].getValue());
				str.append("\n");
			}
		}
		return str.toString();
	}
	
	
	

}
