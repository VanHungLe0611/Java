package library;

import java.util.ArrayList;
import java.util.Collections;

public class Library {
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<Book> books = new ArrayList<Book>();

	public void addMember(Member member) {
		int count = 0;
		for (Member member1 : members) {
			if (member1.equals(member)) {
				count++;
			}
		}
		if (count == 0) {
			members.add(member);
		}
	}

	public void addBook(Book book) {
		int count = 0;
		for (Book book1 : books) {
			if (book1.equals(book)) {
				count++;
			}
		}
		if (count == 0) {
			book.setMember(null);
			books.add(book);
		}
	}

	public Book lendBook(Member member, Person author, String title) {
		Book bookLend = new Book(author, title);
		int count = 0;
		for (int i = 0; i < books.size(); i++) {
			if (bookLend.getAuthor().getFirstName().equals(books.get(i).getAuthor().getFirstName())
					&& bookLend.getAuthor().getSurname().equals(books.get(i).getAuthor().getSurname())
					&& bookLend.getTitle().equals(books.get(i).getTitle())) {
				bookLend = books.get(i);
				bookLend.setMember(member);
				count++;
			}
		}
		if (count == 1) {
			return bookLend;
		} else
			return null;
	}

	public void returnBook(Book book) {
		if (!books.isEmpty()) {
			books.remove(book);
			book.setMember(null);
		}

	}

	public String toString() {
		Collections.sort(books);
		String string = "Books:\n";
		for (Book book : books) {
			string += book.getAuthor().getSurname() + ", " + book.getAuthor().getFirstName() + ": " + book.getTitle()
					+ "\n";
		}
		return string;
	}

}
