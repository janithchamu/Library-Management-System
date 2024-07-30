package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.BookDto;
import dto.BookDtoRes;
import entity.Book;
import repository.BookRepository;



public class BookService {

    private BookRepository bookRepository;
    public BookService(){
      bookRepository = new BookRepository();
    }

    public boolean addBook(BookDto bookDto) throws ClassNotFoundException, SQLException {
       return bookRepository.addBook(bookDto);
    }

	public ArrayList<BookDtoRes> loadTable() throws ClassNotFoundException, SQLException {
		return bookRepository.loadTable();
	}

    public boolean deleteBookById(String bookId) throws ClassNotFoundException, SQLException {
       return bookRepository.deleteBookById(bookId);
    }

    public boolean updateBook(BookDto bookDto) throws ClassNotFoundException, SQLException {
      return bookRepository.updateBook(bookDto);
    }
    
}
