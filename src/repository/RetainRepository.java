package repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.cj.xdevapi.PreparableStatement;

import db.DbConnection;
import dto.BarrowingDto;
import dto.FineDto;
import entity.Barrowing;

public class RetainRepository {

    public BarrowingDto loadRecord(String memberId, String bookId) throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM barrowingbook WHERE memberId = ? AND bookId = ? AND statusRetain = false");
       statement.setString(1, memberId);
       statement.setString(2, bookId);

       ResultSet resultSet = statement.executeQuery();

       if(resultSet.next()){
            BarrowingDto bookBarrow = new BarrowingDto(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getObject(4,LocalDate.class),
                resultSet.getObject(5,LocalDate.class),
                resultSet.getObject(6,LocalDate.class),
                resultSet.getBoolean(7)
            );
            return bookBarrow;
       }else{
        return null;
       }
    
       
    }

    public boolean addFine(FineDto fineDto) throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO fines(transactionId, fineAmount, fineDate, paid) VALUES(?,?,?,?)");
       statement.setInt(1, fineDto.getTransactionId());
       statement.setDate(3, Date.valueOf(fineDto.getFineDate()));
       statement.setDouble(2, fineDto.getFine());
       statement.setBoolean(4,fineDto.isPaid());

       return statement.executeUpdate() > 0 ? true:false;
    }

    public boolean updateTransaction(Integer transactionId, LocalDate returnDate) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE barrowingbook SET retainDate = ?, statusRetain = ? WHERE transactionId = ?");
        statement.setDate(1, Date.valueOf(returnDate));
        statement.setByte(2, (byte) 1);
        statement.setInt(3,transactionId);

        return statement.executeUpdate()>0 ? true:false;
    }
    
}
