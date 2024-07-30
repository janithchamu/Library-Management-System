package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import db.DbConnection;
import dto.BookDto;
import dto.BookDtoRes;
import entity.Book;

public class BookRepository {

    public boolean addBook(BookDto bookDto) throws ClassNotFoundException, SQLException {
      PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO books VALUES(?,?,?,?,?)");
      statement.setString(1, bookDto.getBookId());
      statement.setString(2, bookDto.getBookName());
      statement.setString(3, bookDto.getBookDescription());
      statement.setString(4, bookDto.getAuthor());
      statement.setString(5, bookDto.getCatergoryId());

     return statement.executeUpdate()>0 ? true :false;
    }

    public ArrayList<BookDtoRes> loadTable() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT b.bookId, b.bookName, b.bookDescription, b.author, c.catergory FROM books b LEFT JOIN book_catergories c ON b.catergoryId=c.catergoryId");
       // statement.setString(1,catergoryId );
        ResultSet resultSet = statement.executeQuery();
        ArrayList<BookDtoRes> list = new ArrayList<>();

        while(resultSet.next()){
            BookDtoRes bookDtoRes = new BookDtoRes(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5)
            );
            list.add(bookDtoRes);
        }
        return list;
    }

    public boolean deleteBookById(String bookId) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM books WHERE bookId = ?");
     statement.setString(1, bookId);

     return statement.executeUpdate()>0 ? true:false;
    }

    public boolean updateBook(BookDto bookDto) throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE books SET bookName = ?, bookDescription = ?, author = ?, catergoryID = ? WHERE bookId = ?");
       statement.setString(1, bookDto.getBookName());
       statement.setString(2, bookDto.getBookDescription());
       statement.setString(3, bookDto.getAuthor());
       statement.setString(4, bookDto.getCatergoryId());
       statement.setString(5, bookDto.getBookId());
       

       return statement.executeUpdate()>0 ? true:false;
    }
    
}
