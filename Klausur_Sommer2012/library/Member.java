package library;

public class Member extends Person {

	private static int nextID = 1;
	private int memberID;

	public Member(String firstName, String surname) {
		super(firstName, surname);
		nextID = nextID + 1;
	}

	public int getMemberID() {
		return memberID;
	}

}
