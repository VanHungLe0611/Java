package familyTree;

import java.util.ArrayList;

public class FamilyMember extends Person implements Comparable<FamilyMember> {

	private int birthYear;
	private boolean isMale;

	private FamilyMember mother;
	private FamilyMember father;
	private ArrayList<FamilyMember> children = new ArrayList<FamilyMember>();

	public FamilyMember(String firstName, String surName, int birthYear, boolean isMale) {
		super(firstName, surName);
		this.birthYear = birthYear;
		this.isMale = isMale;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public FamilyMember getMother() {
		return mother;
	}

	public FamilyMember getFather() {
		return father;
	}

	public FamilyMember[] getChildren() {
		FamilyMember[] childrenArray = new FamilyMember[children.size()];
		for (int i = 0; i < children.size(); i++) {
			childrenArray[i] = children.get(i);
		}
		return childrenArray;

	}

	public void setMother(FamilyMember mother) {
		this.mother = mother;
		FamilyMember child = new FamilyMember(this.getFirstName(), this.getSurname(), this.getBirthYear(), this.isMale);
		this.mother.addChild(child);

	}

	public void setFather(FamilyMember father) {
		this.father = father;
		FamilyMember child = new FamilyMember(this.getFirstName(), this.getSurname(), this.getBirthYear(), this.isMale);
		this.father.addChild(child);
	}

	public void addChild(FamilyMember child) {
		int count = 0;

		for (FamilyMember familyMember : children) {
			if (familyMember.equals(child)) {
				count++;
			}
		}
		if (count == 0) {
			children.add(child);
			if (child.mother == null) {
				child.mother = new FamilyMember(this.getFirstName(), this.getSurname(), this.getBirthYear(),
						this.isMale);
			} else {
				child.father = new FamilyMember(this.getFirstName(), this.getSurname(), this.getBirthYear(),
						this.isMale);
			}
		}

	}

	public boolean equals(Object obj) {
		if (obj instanceof FamilyMember) {
			FamilyMember other = (FamilyMember) obj;
			if (this.getFirstName().equals(other.getFirstName()) && this.getSurname().equals(other.getSurname())
					&& this.getBirthYear() == other.birthYear && this.isMale == other.isMale) {
				return true;
			}
		}
		return false;

	}

	public int compareTo(FamilyMember other) {
		if (this.getFirstName().equals(other.getFirstName())) {
			if (this.getSurname().equals(other.getSurname())) {
				if (this.getBirthYear() == other.getBirthYear()) {
					return 0;
				} else {
					if (this.getBirthYear() - other.getBirthYear() < 0) {
						return -1;
					} else if (this.getBirthYear() - other.getBirthYear() > 0) {
						return 1;
					} else {
						return 0;
					}
				}
			} else {
				if (this.getSurname().compareTo(other.getSurname()) < 0) {
					return -1;
				} else if (this.getSurname().compareTo(other.getSurname()) > 0) {
					return 1;
				} else
					return 0;
			}

		} else {
			if (this.getFirstName().compareTo(other.getFirstName()) < 0) {
				return -1;
			} else if (this.getFirstName().compareTo(other.getFirstName()) > 0) {
				return 1;
			} else
				return 0;
		}	
	}
	
	@Override
	public String toString() {
		String string = "\n  ->";
		for (FamilyMember familyMember : children) {
			string += " " + familyMember.getFirstName()+ " " + familyMember.getSurname() + ",";
		}
		string = string.substring(0, string.length() - 1);
		if (children.isEmpty()) {
			return String.format("%s, %s (*%d)", this.getSurname(), this.getFirstName(), this.getBirthYear());
		}
		else return String.format("%s, %s (*%d)%s", this.getSurname(), this.getFirstName(), this.getBirthYear(),string);
		
	}


}
