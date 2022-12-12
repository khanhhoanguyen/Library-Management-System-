package sait.bms.application;

import java.io.FileNotFoundException;

import sait.bms.manager.BookManager;

/**
 * This method runs the BookManager class
 * 
 * @author Hoa Nguyen 
 * @author Miguel Mulingbayan
 *
 */
public class BookDriver {

	public static void main(String[] args) throws FileNotFoundException {
		new BookManager();
	}

}
