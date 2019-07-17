package library;

public class Book implements Comparable<Book> {

	private Person author;
	private String title;
	private Member member;

	public Book(Person author, String title) {
		this.author = author;
		this.title = title;
	}

	public Person getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public int compareTo(Book o) {
		if (this.author.getSurname().equals(o.author.getSurname())) {
			if (this.author.getFirstName().equals(o.author.getFirstName())) {
				if (this.getTitle().equals(o.getTitle())) {
					return 0;
				} else {
					if (this.getTitle().compareTo(o.getTitle()) < 0) {
						return -1;
					} else if (this.getTitle().compareTo(o.getTitle()) > 0) {
						return 1;
					} else
						return 0;
				}

			} else {
				if (this.author.getFirstName().compareTo(o.author.getFirstName()) < 0) {
					return -1;
				} else if (this.author.getFirstName().compareTo(o.author.getFirstName()) > 0) {
					return 1;
				} else
					return 0;

			}

		} else {
			if (this.author.getSurname().compareTo(o.author.getSurname()) < 0) {
				return -1;
			} else if (this.author.getSurname().compareTo(o.author.getSurname()) > 0) {
				return 1;
			} else
				return 0;
		}
	}

}
