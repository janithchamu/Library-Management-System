package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbConnection;
import dto.UserSignInDto;
import dto.UserSignUpDto;

public class UserRepository {

    private Connection connection;

    public int findUser(UserSignInDto userSignInDto) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM users WHERE userName = ?");

        statement.setString(1, userSignInDto.getUserName());

        ResultSet result = statement.executeQuery();

        if(result.next()){
            if(result.getString("password").equals(userSignInDto.getPassword())){
                return 1;
            }
            else{
                return 2;
            }
        }
        else{
            return 0;
        }
    }

    public int save(UserSignUpDto newUser) throws SQLException, ClassNotFoundException {
     try {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO users(name, nicNo, contact, address, userName, password) VALUES(?,?,?,?,?,?)");

        statement.setString(1, newUser.getName());
        statement.setString(2, newUser.getNicNo());
        statement.setString(3, newUser.getContactNo());
        statement.setString(4, newUser.getAddress());
        statement.setString(5, newUser.getUserName());
        statement.setString(6, newUser.getPassword());
        return statement.executeUpdate() ;

     } catch (Exception e) {
        e.printStackTrace();
     }
    return 0;
    }
    
}
