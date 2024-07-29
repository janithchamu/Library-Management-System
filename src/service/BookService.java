package service;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Book;
import repository.BookRepository;



public class BookService {

    private BookRepository bookRepository;
    public BookService(){
      bookRepository = new BookRepository();
    }

    public boolean addBook(Book book) throws ClassNotFoundException, SQLException {
       return bookRepository.addBook(book);
    }

	public ArrayList<Book> loadTable() throws ClassNotFoundException, SQLException {
		return bookRepository.loadTable();
	}

    public boolean deleteBookById(String bookId) throws ClassNotFoundException, SQLException {
       return bookRepository.deleteBookById(bookId);
    }

    public boolean updateBook(Book book) throws ClassNotFoundException, SQLException {
      return bookRepository.updateBook(book);
    }
    
}
