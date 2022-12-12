package Librarian;

import java.util.Date;
import java.util.Vector;

public class Library extends Librarian{
	private String qualityOfBook;
	private int amountOfBook;
	private Date termOfReturning;
	private Vector<Book> book;
	
	public Library(String qualityOfBook, int amountOfBook, Date termOfReturning, Vector<Book> book) {
		super();
		this.qualityOfBook = qualityOfBook;
		this.amountOfBook = amountOfBook;
		this.termOfReturning = termOfReturning;
		this.book = book;
	}
	public String getQualityOfBook() {
		return qualityOfBook;
	}
	public void setQualityOfBook(String qualityOfBook) {
		this.qualityOfBook = qualityOfBook;
	}
	public int getAmountOfBook() {
		return amountOfBook;
	}
	public void setAmountOfBook(int amountOfBook) {
		this.amountOfBook = amountOfBook;
	}
	public Date getTermOfReturning() {
		return termOfReturning;
	}
	public void setTermOfReturning(Date termOfReturning) {
		this.termOfReturning = termOfReturning;
	}
	public Vector<Book> getBook() {
		return book;
	}
	public void setBook(Vector<Book> book) {
		this.book = book;
	}
	
	
}
