package library;

public class Person {
	private String firstName;
	private String surname;

	public Person(String firstName, String surname) {
		super();
		this.firstName = firstName;
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return String.format("%s %s", getFirstName(), getSurname());
	}

}
