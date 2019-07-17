package familyTree;

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

	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person another = (Person) obj;
			if (this.firstName.equals(another.firstName) && this.surname.equals(another.surname)) {
				return true;
			}
		}
		return false;

	}

}
