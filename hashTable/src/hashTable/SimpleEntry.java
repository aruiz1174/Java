package hashTable;

import java.util.Map;
/**
 * 
 * @author Anibal Ruiz (Help:Tony Ruiz and GeeksforGeeks website, and /home/cheung/teaching/web/323/Syllabus/Map/Progs/Goodrich
 * 
 * 
 * An Entry maintaining a key and a value. The value may be changed using the setValue method.
 *  This class facilitates the process of building custom map implementations. 
 *
 * @param <K>
 * @param <V>
 */

public class SimpleEntry<K, V> implements Map.Entry<K, V> 
{
	
	// declare two instance vars:
	// key of type K
	// value of type V
	private K key;
	private V value;
	
	
	
	// parameterized constructor, you know what to do
	public SimpleEntry(K key, V value) 
	{
		this.key = key;
		this.value = value;
		
	}
	
	/**
	 * return the key value.
	 */
	public K getKey() 
	{
		return key;
		
	}
	
	/**
	 * return the value
	 */
	public V getValue() 
	{
		return value;
	}
	
	/**
	 * this must set the value to newValue but return the old value
	 */
	public V setValue(V newValue) 
	{
		V current = value;
		value = newValue;
		return current;
	}

	
}