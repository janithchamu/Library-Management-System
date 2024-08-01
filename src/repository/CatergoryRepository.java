package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;
import entity.Catergory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import tm.CatergoryTm;

public class CatergoryRepository {

    public boolean addBookCatergory(Catergory catergory) throws ClassNotFoundException, SQLException {
        PreparedStatement statment = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO Book_Catergories VALUES(?,?,?)");
        statment.setString(1, catergory.getCatergoryId());
        statment.setString(2, catergory.getCatergoryName());
        statment.setString(3, catergory.getDescription());

         return (statment.executeUpdate()>0 ? true:false);
    }

    public ArrayList<Catergory> loadTable() throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Book_Catergories");
        ResultSet catergorySet = statement.executeQuery();
        ArrayList<Catergory> List = new ArrayList<>();

        while (catergorySet.next()) {
                Catergory catergory = new Catergory(
                    catergorySet.getString(1),
                    catergorySet.getString(2),
                    catergorySet.getString(3)
                );

                List.add(catergory);             
        }

        return List;

    }

    public boolean deleteCatergoryById(String catergoryId) throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM Book_Catergories WHERE catergoryId = ? ");
       statement.setString(1,catergoryId);
       return statement.executeUpdate() > 0 ? true : false;
    }

    public boolean updateCatergory(Catergory catergory) throws ClassNotFoundException, SQLException {
     PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE Book_Catergories SET catergory = ?, catergory_discrption = ? WHERE catergoryId = ?");
     statement.setString(1, catergory.getCatergoryName());
     statement.setString(2, catergory.getDescription());
     statement.setString(3, catergory.getCatergoryId());


     return statement.executeUpdate()>0 ? true:false;
     
    }
    
}
