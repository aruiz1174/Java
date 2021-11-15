
/**
 * Title: EmptyList Class
 * Description: Checked Exception: This class contains the parameterized constructor responsible for 
 * 				displaying a message if a catch block is executed in any of the cases when checking if the
 * 				array contains any elements.
 * @author Tony Ruiz
 *
 */

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException{

	public EmptyListException(String message)
	{
		super(message);

	}

}
