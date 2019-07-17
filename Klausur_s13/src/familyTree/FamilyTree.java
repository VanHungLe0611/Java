package familyTree;

import java.util.ArrayList;

public class FamilyTree{
	private ArrayList<FamilyMember> familyMembers = new ArrayList<FamilyMember>();

	public FamilyTree() {
		super();
	}
	
	public FamilyMember createPerson (String firstName, String surName, int birthYear, boolean isMale) {
		FamilyMember familyMember = new FamilyMember(firstName, surName, birthYear, isMale);
	    familyMembers.add(familyMember);
		return familyMember;
	}
	
	public FamilyMember findPerson(String firstName, String surName, int birthYear) {
		FamilyMember familyMember = new FamilyMember(null, null, 0, false);
		for (int i = 0 ; i < familyMembers.size() ; i++) {
			if(familyMembers.get(i).getFirstName().equals(firstName) && familyMembers.get(i).getSurname().equals(surName) && (familyMembers.get(i).getBirthYear() == birthYear)){
				familyMember = familyMembers.get(i);
				return familyMember;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String string = "";
		for (int i = familyMembers.size()-1; i >= 0; i--) {
			string += familyMembers.get(i) + "\n";
			
		}
		return String.format("Family Tree:\n------------\n%s", string);
	}
}
