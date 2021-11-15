
/**
 * Title: ElementNotFound Class
 * Description: Checked Exception: This class contains the parameterized constructor responsible for 
 * 				displaying a message if a catch block is executed in any of the cases when checking if the
 * 				array contains a certain element in the main application.
 * @author Tony Ruiz
 *
 */

@SuppressWarnings("serial")
public class ElementNotFoundException extends RuntimeException{ 

	public ElementNotFoundException(String message)
	{
		super(message);

	}


}
