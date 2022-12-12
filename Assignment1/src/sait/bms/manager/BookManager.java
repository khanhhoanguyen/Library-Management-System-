package sait.bms.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import sait.bms.problemdomain.*;
/**
 * Assignment 1 - Books
 * 
 * @author Hoa Nguyen 
 * @author Miguel Mulingbayan
 *
 *	The bookManager Class contains all the methods that will work with the book.txt data
 */

public class BookManager {
	private Scanner in;
	private ArrayList<Book> books;
	
	/**
	 * The bookManager method will load the books from the books.txt file and shows the display menu	
	 * 
	 * @throws FileNotFoundException
	 */
	public BookManager() throws FileNotFoundException {
		in = new Scanner(System.in);
		books = new ArrayList<>();
		loadBooksFromFile();
		displayMenu();
		
	}//BookManager
	
	/**
	 * The load books method will gather the data from the books.txt file and turn them into objects
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	private void loadBooksFromFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/books.txt"));
		
		/**
		 * This loop will scan the whole document and place the constant data in the masterBook constructor
		 * 
		 * Constant Data
		 * 
		 * @param isbn The book's ISBN Number
		 * @param callNumber The book's Call Number
		 * @param available The amount of the book's availability
		 * @param total The total amount of the Book
		 * @param title The book's title
		 * 
		 */
		while(in.hasNext())
		{
			String line = in.nextLine();
			//System.out.println(line);
			String []fields = line.split(";");
			
			long isbn = Long.parseLong(fields[0]);
			String callNumber = fields[1];
			int available = Integer.parseInt(fields[2]);
			long total = Long.parseLong(fields[3]);
			String title = fields[4];
			
			/**
			 * This value reads the final digit of the ISBN to check what kind of book the object is to turn book to the 
			 * proper object using specific constructors
			 * 
			 * @param lastDigit The last digit of the book's ISBN Number
			 * 
			 * Specific Data
			 * 
			 * + Children's Book +
			 * @param authors Value for authors
			 * @param format Value for the type of format
			 * 
			 * + Cook Book +
			 * @param publisher Value for publisher
			 * @param diet Value for the type of diet
			 * 
			 * + Paperback +
			 * @param authors Value for authors
			 * @param yearOfRelease Value for year of release
			 * @param genre Value for type of genre
			 * 
			 * + Periodicals +
			 * @param frequency Value for type of frequency
			 * 
			 */
			long lastDigit = isbn%10;
			
			// Children's Book Constructor
			if(lastDigit == 0 || lastDigit == 1)
			{
				String authors = fields[5];
				String format = fields[6];
				books.add(new ChildrensBook(isbn, callNumber, available, total, title, authors, format));
			}
			
			// Cook Book Constructor
			else if (lastDigit == 2 || lastDigit == 3)
			{
				String publisher = fields[5];
				String diet = fields[6];
				books.add(new Cookbook(isbn, callNumber, available, total, title, publisher, diet));
			}
			
			// Paperbook Constructor
			else if (lastDigit == 4 || lastDigit == 5 || lastDigit == 6 || lastDigit == 7)
			{
				String authors = fields[5];
				long yearOfRelease = Long.parseLong(fields[6]);
				String genre = fields[7];
				books.add(new Paperback(isbn, callNumber, available, total, title, authors, yearOfRelease, genre));
			}
			
			// Periodical Constructor
			else if(lastDigit == 8 || lastDigit == 9)
			{
				String frequency = fields[5];
				books.add(new Periodical(isbn, callNumber, available, total, title, frequency));
			}
			//System.out.println(books);
		}
		in.close();
		
	}// loadBooksFromFile Method

	/**
	 * This method shows the menu of the possible actions that can be done in the program
	 * 
	 * @throws FileNotFoundException
	 */
	private void displayMenu() throws FileNotFoundException {
		/**
		 * The option is based on which action we want to do in the program
		 * 
		 * @param option Our choice of action
		 * 
		 */
		int option = 0;

		/**
		 * This statement will base our option in which action to execute
		 * 
		 * 1 - Checkouts book
		 * 2 - Find books by title
		 * 3 - Display books by type
		 * 4 - Shows random books
		 * 5 - Saves and exit
		 * 
		 */
		while (option != 5) {

			System.out.println("Welcome in ABC Company: How May We Assist You?");
			System.out.println("1\tCheckout Book");
			System.out.println("2\tFind Books by Title");
			System.out.println("3\tDisplay Books by Title");
			System.out.println("4\tProduce Random Books by Type");
			System.out.println("5\tSave & Exit");

			System.out.print("\nEnter option: ");
			option = this.in.nextInt();

			switch (option) {
				case 1: {
					checkoutBook(books);
					break;
				}
				case 2: {
					findBookByTitle();
					break;
				}
				case 3: {
					displayBookByType();
					break;
				}
				case 4: {
					produceRandomBookList(books);
					break;
				}
				case 5: {
					saveBook();
					System.exit(0);
				}
				default: {
					System.out.println("Invalid option!");
					break;
				}
			}
		}
	}//displayMenu Method

	/**
	 * This method gets the current data of the books and saves the updated data to the books.txt
	 * 
	 * @throws FileNotFoundException
	 */
	private void saveBook() throws FileNotFoundException {
		try (PrintWriter bookChanges = new PrintWriter("res/books.txt")) {
			
			//This advance loop will go through all the books
			for (Book a : books) {
				
				//This checks for Children's Books
				if (a instanceof ChildrensBook) {
					ChildrensBook chbk = (ChildrensBook) a;
					bookChanges.println(String.format("%d;%s;%d;%d;%s;%s;%s", chbk.isbn, chbk.callNumber, chbk.available, chbk.getTotal(), chbk.getTitle(), chbk.getAuthors(), chbk.getFormat()));
				}
				
				//This checks for Cook Books
				if (a instanceof Cookbook) {
					Cookbook ckbk = (Cookbook) a;
					bookChanges.println(String.format("%d;%s;%d;%d;%s;%s;%s", ckbk.isbn, ckbk.callNumber, ckbk.available, ckbk.getTotal(), ckbk.getTitle(), ckbk.getPublisher(), ckbk.getDiet()));
				}
				
				//This checks for Paperbacks
				if (a instanceof Paperback) {
					Paperback ppbk = (Paperback) a;
					bookChanges.println(String.format("%d;%s;%d;%d;%s;%s;%d;%s", ppbk.isbn, ppbk.callNumber, ppbk.available, ppbk.getTotal(), ppbk.getTitle(), ppbk.getAuthors(), ppbk.getYearOfRelease(), ppbk.getGenre()));
				}			
				
				//This checks for Periodicals
				if (a instanceof Periodical) {
					Periodical period = (Periodical) a;
					bookChanges.println(String.format("%d;%s;%d;%d;%s;%s", period.isbn, period.callNumber, period.available, period.getTotal(), period.getTitle(), period.getFrequency()));
				}		
			}
		}	
	}//saveBooks Method

	/**
	 * This method checkouts a book using the ISBN number
	 * 
	 * @param books Uses the Array List of books
	 * @param mathingIndex Used to compare the ISBN Number
	 * 
	 */
	private void checkoutBook(ArrayList<Book> books) {
		
		System.out.print("Enter ISBN of book: ");
		long inputISBN = in.nextLong();
		
		int matchingIndex = -1;

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).isbn == inputISBN) {
				matchingIndex = i;
				break;
			}
		}

		//If the ISBN Number doesn't match any of the books
		if (matchingIndex == -1) {
			System.out.println("\nSorry, we dont have that book\n");
			return;
			
		} else {
			
			//If the ISBN Number matches a Periodical
			if (books.get(matchingIndex).isbn%10 == 8 || books.get(matchingIndex).isbn%10 == 9 ) {
				System.out.println("\nSorry, you cant check out a Periodical\n");
				return;
			}
			
			//If the ISBN Number matches a book but has ran out of availability
			if (books.get(matchingIndex).available == 0) {
				System.out.println("\nThe book \"" + books.get(matchingIndex).title + "\" has no avaliable copies left in store");
				return;
			} 
			
			//If the ISBN Number matches an available book
			if (books.get(matchingIndex).available != 0) {
				System.out.println("\nThe book \"" + books.get(matchingIndex).title + "\" has been checked out.");
				System.out.printf("%s%s\n", "It can be located using a call number: ", books.get(matchingIndex).callNumber);
				books.get(matchingIndex).available--;
				return;
			} 
		}
	}//checkoutBook Method

	/**
	 * This method is used to check book titles based on user input
	 *
	 */
	private void findBookByTitle() {
		/**
		 * Values
		 * 
		 * @param bookFound The amount of books with the same letters on the user input
		 * @param inputTitle The user input
		 * @param findTitle Checks the title of books
		 */
		int bookFound = 0;
		System.out.print("Enter title to search for: ");
		String inputTitle = in.next().toLowerCase();
		
		//This statement checks every book and compares the title and user input
		for (int i = 0; i < books.size(); i++)
		{
			String findTitle = books.get(i).title.toLowerCase();
			
			if(findTitle.contains(inputTitle) == true)
			{
				bookFound++;
				System.out.println(books.get(i));
			}
		}
		
		//If no book is found
		if(bookFound == 0)
		{
			System.out.println("Sorry we can not find that book");
		}
	}//findBookByTitle Method

	/**
	 * This method shows the books by type
	 * 
	 * @param inputType The user input which chooses what kind of book to check
	 * @param inputFormat The user input which chooses the format of the book
	 * @param inputDiet The user input which chooses the diet of the book
	 * @param inputGenre The user input which chooses the genre of the book
	 * @param inputFrequency The user input which chooses the frequency of the book
	 * 
	 */
	private void displayBookByType() {
		
		System.out.println("#\tType");
		System.out.println("1\tChildren's Books");
		System.out.println("2\tCookbooks");
		System.out.println("3\tPaperbacks");
		System.out.println("4\tPeriodicals");
		System.out.println();
		System.out.print("Enter type of book: ");
		int inputType = in.nextInt();
		
		//Children's Book
		if (inputType == 1) {
			System.out.print("Enter a Format (P for Picture book, E for Early Readers, C for Chapter book): ");
			String inputFormat = in.next().toUpperCase();
			for (int i = 0; i<books.size();i++)
			{
				if(books.get(i) instanceof ChildrensBook)
				{
					ChildrensBook childBook = (ChildrensBook) books.get(i);
					if (inputFormat.equals(childBook.getFormat()))
					{
						System.out.println(childBook);
					}
				}
			}
		} 
		
		//Cook Book
		if (inputType == 2) {
			System.out.print("Enter a Diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, N for None): "); 
			String inputDiet = in.next().toUpperCase();
			for (int i = 0; i<books.size();i++)
			{
				if(books.get(i) instanceof Cookbook)
				{
					Cookbook cookBook = (Cookbook) books.get(i);
					if (inputDiet.equals(cookBook.getDiet()))
					{
						System.out.println(cookBook);
					}
				}
			}
		} 
		
		//Paperback
		if (inputType == 3) {
			System.out.print("Enter a Genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, S for  Science Fiction): "); 
			String inputGenre = in.next().toUpperCase();
			for (int i = 0; i<books.size();i++)
			{
				if(books.get(i) instanceof Paperback)
				{
					Paperback paper = (Paperback) books.get(i);
					if (inputGenre.equals(paper.getGenre()))
					{
						System.out.println(paper);
					}
				}
			}
		} 
		
		//Periodicals
		if (inputType == 4) {
			System.out.print("Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
			String inputFrequency = in.next().toUpperCase();
			for (int i = 0; i<books.size();i++)
			{
				if(books.get(i) instanceof Periodical)
				{
					Periodical peri = (Periodical) books.get(i);
					if (inputFrequency.equals(peri.getFrequency()))
					{
						System.out.println(peri);
					}
				}
			}
		}	
	}//displayBookByType Method

	/**
	 * This method will produce a number of random books
	 * 
	 * @param books Uses the books ArrayList
	 * @param random Makes a random object
	 * @param numRanBooks The number of books the user chooses
	 * @param ranIndex Uses the random to choose a random number throughout the Array List
	 */
	private void produceRandomBookList(ArrayList<Book> books) {

		//Creates a random value for the index based on the Array List size
		Random random = new Random();

		//User chooses how many random books will be displayed
		System.out.print("Enter number of books: ");
		int numRanBooks = in.nextInt();

		for (int k = 0; k < numRanBooks; k++) {
			int ranIndex = random.nextInt(books.size());
			System.out.println(books.get(ranIndex));
		}
	}	
}
