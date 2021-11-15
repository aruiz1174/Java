import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Person implements Comparable<Person> {
	private String name, birthday;
	private int id;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthdayGenerator();
	}
	public void setBday(String birthday) {
		this.birthday = birthday;
	}

	public Person(String name, int id) {
		this.name = name;
		this.setId(id);
		birthday = birthdayGenerator();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Generates a random day of the year (1 - 366) and converts it into a date.
	 * Ex. Day generated is 34, this method converts it into 02/03/2020.
	 */
	@SuppressWarnings("deprecation")
	public String birthdayGenerator() {
		String str;
		int day, month;
		Random ran = new Random();

		int dayOfYear = ran.nextInt(367) + 1;

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

		month = calendar.getTime().getMonth() + 1;
		day = calendar.getTime().getDay() + 1;
		str = month + " " + day;

		return str;
	}

	/**
	 * This method is called when a new person is created and then its birthday is compared
	 * to people already in the array.
	 */
	public boolean compareElements(ArrayList<ArrayOrderedList<Person>> array) {
		int length = array.size();
		if (length > 1) {
				ArrayOrderedList<Person> innerArray = array.get(this.getBirthday().indexOf(0, 1));
				int innerLength = innerArray.size();
				for (int j = 0; j < innerLength; j++) {
					for (int k = j + 1; k < innerLength; k++) {
						if (innerArray.getElement(j).equals(innerArray.getElement(k))) {
							System.out.println(innerArray.getElement(j).toString() + "\n" + innerArray.getElement(k).toString());
							return true;
						}
					}
				}
		}
		return false;
	}

		/**
		 * This method changes the format of the "month".
		 * Ex. 02 - February.
		 */
		public void monthChanger(Person aPerson) {
			String month, day;

			month = aPerson.getBirthday().substring(0, 1);
			day = aPerson.getBirthday().substring(2);
			switch(month) {
			case "1":
				aPerson.setBday("January" + " " + day);
				break;
			case "2":
				aPerson.setBday("February" + " " + day);
				break;
			case "3":
				aPerson.setBday("March" + " " + day);
				break;
			case "4":
				aPerson.setBday("April" + " " + day);
				break;
			case "5":
				aPerson.setBday("May" + " " + day);
				break;
			case "6":
				aPerson.setBday("June" + " " + day);
				break;
			case "7":
				aPerson.setBday("July" + " " + day);
				break;
			case "8":
				aPerson.setBday("August" + " " + day);
				break;
			case "9":
				aPerson.setBday("September" + " " + day);
				break;
			case "10":
				aPerson.setBday("Octuber" + " " + day);
				break;
			case "11":
				aPerson.setBday("November" + " " + day);
				break;
			case "12":
				aPerson.setBday("December" + " " + day);
				break;
			}
		}

	@Override
	public String toString() {
		return id + ". " + name + " " + birthday;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return birthday.compareTo(o.birthday);
	}



}
