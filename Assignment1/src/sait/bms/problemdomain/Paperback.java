package sait.bms.problemdomain;

/**
 * The paperback sub class of the book object
 * 
 * @author Hoa Nguyen 
 * @author Miguel Mulingbayan
 *
 * @param authors The book's authors
 * @param yearOfRelease The book's year of release
 * @param genre The book's genre
 * 
 */
public class Paperback extends Book {
	String authors;
	long yearOfRelease;
	String genre;

	/**
	 * The default constructor
	 * 
	 */
	public Paperback() {
		super();
	}

	/**
	 * The constructor for Periodicals
	 * 
	 * @param isbn
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param authors
	 * @param yearOfRelease
	 * @param genre
	 */
	public Paperback(long isbn, String callNumber, int available, long total, String title, String authors,
			long yearOfRelease, String genre) {
		super(isbn, callNumber, available, total, title);
		
		this.authors = authors;
		this.yearOfRelease = yearOfRelease;
		this.genre = genre;
	}

	/**
	 * Gets the Authors of the Book
	 * 
	 * @return authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Sets the Authors of the Book
	 * 
	 * @param authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Gets the Year of the Book
	 * 
	 * @return the year that the book was released
	 */
	public long getYearOfRelease() {
		return yearOfRelease;
	}

	/**
	 * Sets the Year of the Book
	 * 
	 * @param yearOfRelease
	 */
	public void setYearOfRelease(long yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	/**
	 * Gets the Genre of the Book
	 * 
	 * @return genre of the book
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the Genre of the Book
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * These values set the format of the toString of the book
	 * 
	 * Format Values
	 * @param IBSNForm The ISBN Format
	 * @param callNumForm The Call Number Format
	 * @param availForm The amount of the book's availability
	 * @param totalForm The total amount of the Book
	 * @param titleForm The book's title
	 * @param bookType Gets the type of book
	 * 
	 */

	//Gets the type of book
	public String getBookType() {
		String bookType = "";
		if (this.genre.equals("A")) {
			bookType = "Adventure";
		} else if (this.genre.equals("D")) {
			bookType = "Drama";
		} else if (this.genre.equals("E")) {
			bookType = "Education";
		} else if (this.genre.equals("C")) {
			bookType = "Classic";
		} else if (this.genre.equals("F")) {
			bookType = "Fantasy";
		} else if (this.genre.equals("S")) {
			bookType = "Science Fiction";
		} else {
			bookType = this.genre;
		}
		return bookType;
	}
	
	String IBSNForm = String.format("%-18s%d", "ISBN: ", isbn);
	String callNumForm = String.format("%-18s%s", "Call Number: ", callNumber);
	String availForm = String.format("%-18s%d", "Available: ", available);
	String totalForm = String.format("%-18s%d", "Total: ", total);
	String titleForm = String.format("%-18s%s", "Title: ", title);

	@Override
	public String toString() {
		return String.format("%s\n%s\n%s\n%s\n%s\n%-18s%s\n%-18s%d\n%-18s%s\n", IBSNForm, callNumForm, availForm,
				totalForm, titleForm, "Authors: ", getAuthors(), "Year: ", getYearOfRelease(), "Genre: ", getBookType());
	}

}
