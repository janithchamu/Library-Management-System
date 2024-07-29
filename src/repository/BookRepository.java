package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import db.DbConnection;
import entity.Book;

public class BookRepository {

    public boolean addBook(Book book) throws ClassNotFoundException, SQLException {
      PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO books VALUES(?,?,?,?)");
      statement.setString(1, book.getBookId());
      statement.setString(2, book.getBookName());
      statement.setString(3, book.getBookDescription());
      statement.setString(4, book.getAuthor());

     return statement.executeUpdate()>0 ? true :false;
    }

    public ArrayList<Book> loadTable() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM books");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Book> list = new ArrayList<>();

        while(resultSet.next()){
            Book book = new Book(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4)
            );
            list.add(book);
        }
        return list;
    }

    public boolean deleteBookById(String bookId) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM books WHERE bookId = ?");
     statement.setString(1, bookId);

     return statement.executeUpdate()>0 ? true:false;
    }

    public boolean updateBook(Book book) throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE books SET bookName = ?, bookDescription = ?, author = ? WHERE bookId = ?");
       statement.setString(1, book.getBookName());
       statement.setString(2, book.getBookDescription());
       statement.setString(3, book.getAuthor());
       statement.setString(4, book.getBookId());

       return statement.executeUpdate()>0 ? true:false;
    }
    
}
