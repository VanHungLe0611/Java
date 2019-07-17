package familyTree;

import java.util.ArrayList;

public class FamilyTree {

	private ArrayList<FamilyMember> familyMembers = new ArrayList<FamilyMember>();

	public FamilyTree() {
		super();
	}

	public FamilyMember createPerson(String firstName, String surname, int birthYear, boolean isMale) {
		FamilyMember familyMember = new FamilyMember(firstName, surname, birthYear, isMale);
		familyMembers.add(familyMember);
		return familyMember;
	}

	public FamilyMember findPerson(String firstName, String surname, int birthYear) {
		for (FamilyMember familyMember : familyMembers) {
			if (familyMember.getSurname().equals(surname) && familyMember.getFirstName().equals(firstName)
					&& (familyMember.getBirthYear() == birthYear)) {
				return familyMember;
			}

		}
		return null;
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = familyMembers.size() - 1; i >= 0; i--) {
			string += familyMembers.get(i) + "\n";

		}
		return String.format("Family Tree:\n------------\n%s", string);
	}

}