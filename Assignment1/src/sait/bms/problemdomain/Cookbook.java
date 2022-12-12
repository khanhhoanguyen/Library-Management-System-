package sait.bms.problemdomain;

/**
 * The Cook Book sub class of the book object
 * 
 * @author Hoa Nguyen 
 * @author Miguel Mulingbayan
 *
 * @param publisher The book's publisher
 * @param diet The book's Diet
 * 
 */
public class Cookbook extends Book {
	String publisher;
	String diet;

	/**
	 * The default constructor
	 * 
	 */
	public Cookbook() {
		super();
	}

	/**
	 * The constructor for cook books
	 * 
	 * @param isbn
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param publisher
	 * @param diet
	 */
	public Cookbook(long isbn, String callNumber, int available, long total, String title, String publisher,
			String diet) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
		this.publisher = publisher;
		this.diet = diet;
	}

	/**
	 * Gets the Publisher of the Book
	 * 
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Sets the Publisher of the Book
	 * 
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Gets the Diet of the Book
	 * 
	 * @return Diet
	 */
	public String getDiet() {
		return diet;
	}

	/**
	 * Sets the Diet of the Book
	 * 
	 * @param diet
	 */
	public void setDiet(String diet) {
		this.diet = diet;
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
		if (this.diet.equals("D")) {
			bookType = "Diabetic";
		} else if (this.diet.equals("V")) {
			bookType = "Vegeterian";
		} else if (this.diet.equals("G")) {
			bookType = "Gluten-Free";
		} else if (this.diet.equals("I")) {
			bookType = "International";
		} else if (this.diet.equals("N")) {
			bookType = "None";
		} else {
			bookType = this.diet;
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
				titleForm, "Publisher: ", getPublisher(), "Diet: ", getBookType());
	}

}
