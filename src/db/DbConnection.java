package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private  static DbConnection dbConnection;
    
    public Connection connection;

    private DbConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ijse_library","root", "abcd1234");
    }

    public static DbConnection getInstance() throws ClassNotFoundException, SQLException{
        if (dbConnection == null){
            dbConnection = new DbConnection();
        }

        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
