

import java.util.Date;
import java.util.Vector;

public class Book extends Library{
	
	private int cost;
	private Genre genre;
	private int numberOfDuplicates;
	private String author;
	private String title;
	private int year;
	
	public Book(qualityOfBook qualityOfBook, int amountOfBook, Date termOfReturning, Vector<Book> book,
			int cost, Genre genre, int numberOfDuplicates, String author, String title, int year) {
		super(qualityOfBook, amountOfBook, termOfReturning, book);
		this.cost = cost;
		this.genre = genre;
		this.numberOfDuplicates = numberOfDuplicates;
		this.author = author;
		this.title = title;
		this.year = year;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getNumberOfDuplicates() {
		return numberOfDuplicates;
	}

	public void setNumberOfDuplicates(int numberOfDuplicates) {
		this.numberOfDuplicates = numberOfDuplicates;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [cost=" + cost + ", genre=" + genre + ", numberOfDuplicates=" + numberOfDuplicates + ", author="
				+ author + ", title=" + title + ", year=" + year + "]";
	}
	
	
}
