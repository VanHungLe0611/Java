package library;

public class Member extends Person {

	private static int nextID = 0;
	private int memberID;

	@SuppressWarnings("static-access")
	public Member(String firstName, String surname) {
		super(firstName, surname);
		this.setNextID(this.getNextID() + 1);
	}

	public int getMemberID() {
		return this.memberID;
		
	}

	public static int getNextID() {
		return nextID;
	}

	public static void setNextID(int nextID) {
		Member.nextID = nextID;
	}

}
