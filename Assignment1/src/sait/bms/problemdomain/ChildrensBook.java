package sait.bms.problemdomain;

/**
 * The Children's book sub class of the book object
 * 
 * @author Hoa Nguyen 
 * @author Miguel Mulingbayan
 *
 * @param authors The book's authors
 * @param format The book's format
 * 
 */
public class ChildrensBook extends Book {
	String authors;
	String format;

	/**
	 * The default constructor
	 * 
	 */
	public ChildrensBook() {
		super();
	}

	/**
	 * The constructor for the Children's Book
	 * 
	 * @param isbn
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param authors
	 * @param format
	 */
	public ChildrensBook(long isbn, String callNumber, int available, long total, String title, String authors,
			String format) {
		super(isbn, callNumber, available, total, title);

		this.authors = authors;
		this.format = format;
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
	 * Gets the Format of the Book
	 * 
	 * @return format
	 */
	public String getFormat() {
		return format;
	}
	
	/**
	 * Sets the Format of the Book
	 * 
	 * @param format
	 */
	public void setFormat(String format) {
		this.format = format;
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
		if (this.format.equals("P")) {
			bookType = "Picture Book";
		} else if (this.format.equals("E")) {
			bookType = "Early Readers";
		} else if (this.format.equals("C")) {
			bookType = "Chapter Book";
		} else {
			bookType = this.format;
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
		return String.format("%s\n%s\n%s\n%s\n%s\n%-18s%s\n%-18s%s\n", IBSNForm, callNumForm, availForm, totalForm,
				titleForm, "Authors: ", getAuthors(), "Format: ", getBookType());
	}

}
