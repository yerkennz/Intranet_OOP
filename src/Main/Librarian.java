package Main;

import java.util.Date;
import java.util.Vector;

import Enums.Genre;

public class Librarian extends Employee{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Vector<Book> allBook;
	
	public Librarian(String name, String surname, String id, Date birthDay,String phoneNumber, String email,
			int workExperience) {
		super(name,surname,id,birthDay,phoneNumber,email,workExperience);
		allBook = new Vector<Book>();
	}
	/*
	 * using this method librarian can see information about student
	 */
	public String showInfo() {
		return "Name: "+this.getName()+"\nSurname: "+this.getSurname()+
				"\nEmail: "+this.getEmail();
	}
	/*
	 * librarian using this method adds book for library
	 */
	public void addBook(Genre genre, String title, String author,String id, int year) {
        Book bk = new Book(genre,author,title, id, year);
        allBook.add(bk);
    }
	/*
	 * librarian using this method removes book from library
	 */
    public void removeBook(String id) {
        for (Book bk : allBook) {
            if(bk.getId().equals(id)) {
                allBook.remove(bk);
            }
        }
    }
}
