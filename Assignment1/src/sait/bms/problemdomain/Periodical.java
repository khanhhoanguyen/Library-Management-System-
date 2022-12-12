package sait.bms.problemdomain;

/**
 * The periodical book sub class of the book object
 * 
 * @author Hoa Nguyen 
 * @author Miguel Mulingbayan
 *
 * @param frequency The book's Frequency
 * 
 */
public class Periodical extends Book {
	String frequency;

	/**
	 * The default constructor
	 * 
	 */
	public Periodical() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * The constructor for periodicals
	 * 
	 * @param isbn
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param frequency
	 */
	public Periodical(long isbn, String callNumber, int available, long total, String title, String frequency) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
		this.frequency = frequency;
	}

	/**
	 * Gets the frequency of the Book
	 * 
	 * @return frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * Sets the frequency of the Book
	 * 
	 * @param frequency
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
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
		if (this.frequency.equals("D")) {
			bookType = "Daily";
		} else if (this.frequency.equals("W")) {
			bookType = "Weekly";
		} else if (this.frequency.equals("M")) {
			bookType = "Monthly";
		} else if (this.frequency.equals("B")) {
			bookType = "Bi-Monthly";
		} else if (this.frequency.equals("Q")) {
			bookType = "Quarterly";
		} else {
			bookType = this.frequency;
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
		return String.format("%s\n%s\n%s\n%s\n%s\n%-18s%s\n", IBSNForm, callNumForm, availForm, totalForm, titleForm,
				"Frequency: ", getBookType());
	}

}
