package Main;

import java.util.Objects;

import Enums.Genre;

public class Book {
	
	private Genre genre;
	private String author;
	private String title;
	private String id;
	private int year;
	
	public Book(Genre genre, String author, String title,String id, int year) {
		this.genre = genre;
		this.author = author;
		this.title = title;
		this.year = year;
		this.id = id;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
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
	public int hashCode() {
		return Objects.hash(author, genre, title, year);
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && genre == other.genre && Objects.equals(title, other.title)
				&& year == other.year;
	}

	@Override
	public String toString() {
		return "Book [genre=" + genre + ", author=" + author + ", title=" + title + ", year=" + year + "]";
	}
	
	
}
