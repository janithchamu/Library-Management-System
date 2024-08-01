package repository;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbConnection;
import entity.Barrowing;
import entity.Book;
import entity.Member;

public class NewBarrowingRepository {

    public Member searchMember(String memberId) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM members WHERE memberId = ?");
        statement.setString(1, memberId);
        ResultSet resultSet = statement.executeQuery();
        Member member = new Member();
         if(resultSet.next()) {
             member.setMemberId(memberId);
             member.setMemberName(resultSet.getString(2));
             member.setMemberAddress(resultSet.getString(3));
             member.setMemberContact(resultSet.getString(4));
             member.setMemberNIC(resultSet.getString(5));

        }
        else{
            member = null;
        }
        return member;
    }

    public Book searchBook(String bookId) throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM books WHERE bookId = ?");
       statement.setString(1, bookId);
       ResultSet resultSet = statement.executeQuery();
       Book book = new Book();
       if(resultSet.next()){
           book.setBookId(bookId);
           book.setAuthor(resultSet.getString(4));
           book.setBookDescription(resultSet.getString(3));
           book.setBookName(resultSet.getString(2));
       }
       else{
         book = null;
       }
       return book;

    }

    public boolean newBookBarrowing(Barrowing bookBarrowing) throws ClassNotFoundException, SQLException {
      PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO barrowingbook(memberId, bookId, barrowDate, dueDate, retainDate) VALUES(?,?,?,?,?)");
      statement.setString(1, bookBarrowing.getMemberId());
      statement.setString(2, bookBarrowing.getBookId());
      statement.setDate(3,Date.valueOf(bookBarrowing.getBarrowDate()));
      statement.setDate(4, Date.valueOf(bookBarrowing.getDueDate()));
      statement.setDate(5, Date.valueOf(bookBarrowing.getReturnDate()));

      return statement.executeUpdate() > 0 ? true:false;
    }
    
}
