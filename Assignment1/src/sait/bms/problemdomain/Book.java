package sait.bms.problemdomain;

/**
 * The master class of the book object
 * 
 * @author Hoa Nguyen 
 * @author Miguel Mulingbayan
 *
 * @param isbn The book's ISBN Number
 * @param callNumber The book's Call Number
 * @param available The amount of the book's availability
 * @param total The total amount of the Book
 * @param title The book's title
 * 
 */
public class Book {

	public long isbn;
	public String callNumber;
	public int available;
	long total;
	public String title;

	/**
	 * The default constructor
	 * 
	 */
	public Book() {
		super();
	}

	/**
	 * The book constructor
	 * 
	 * @param isbn
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * 
	 */
	public Book(long isbn, String callNumber, int available, long total, String title) {
		super();
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	/**
	 * Gets the ISBN Number of the Book
	 * 
	 * @return ISBN
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Sets the ISBN Number of the Book
	 * 
	 * @param isbn
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the Call Number of the Book
	 * 
	 * @return call number
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * Sets the Call Number of the Book
	 * 
	 * @param callNumber
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * Gets the Available Number of the Book
	 * 
	 * @return the number of available books
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Sets the Available Number of the Book
	 * 
	 * @param available
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * Get the Total Number of the Book
	 * 
	 * @return the number of total books
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * Sets the Total Number of the Book
	 * 
	 * @param total
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * Gets the Title of the Book
	 * 
	 * @return the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the Title of the Book
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", callNumber=" + callNumber + ", available=" + available + ", total=" + total
				+ ", title=" + title + "]";
	}

}
