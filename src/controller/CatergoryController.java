package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import db.DbConnection;
import entity.Catergory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.CatergoryService;
import service.UserService;
import tm.CatergoryTm;

public class CatergoryController {

    @FXML
    private AnchorPane root;
    @FXML
    private TableColumn<CatergoryTm, String> colDecription;

    @FXML
    private TableColumn<CatergoryTm, String> colId;

    @FXML
    private TableColumn<CatergoryTm, String> colName;

    @FXML
    private TableColumn<CatergoryTm, Button> coldelete;

    @FXML
    private TableView<CatergoryTm> tblCatergories;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    private CatergoryService catergoryService;

    public CatergoryController(){
          catergoryService = new CatergoryService();

    }

    public void initialize() throws ClassNotFoundException, SQLException{
        colId.setCellValueFactory(new PropertyValueFactory<>("Cat_ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Cat_Name"));
        colDecription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        coldelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
        getAllRecords();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        Catergory catergory = new Catergory(
            txtId.getText(),
            txtName.getText(),
            txtDescription.getText()
        );

        int res = catergoryService.addBookCatergory(catergory);
     
        if(res>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Catergory added Successfuly!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"FAILE TO ADD CATERGORY !").show();
        }
        getAllRecords();

        txtId.setText("");
        txtName.setText("");
        txtDescription.setText("");
       


    }

    @FXML
    void btnReloadOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
          getAllRecords();
    }

    public void getAllRecords() throws ClassNotFoundException, SQLException{
        
        ArrayList<Catergory> List = catergoryService.loadTable();
        ObservableList<CatergoryTm> catergoryList = FXCollections.observableArrayList();

        for(Catergory catergory : List){
             Button deleteButton = new Button("Delete");
             CatergoryTm catergoryTm = new CatergoryTm(
                catergory.getCatergoryId(),
                catergory.getCatergoryName(),
                catergory.getDescription(),
                deleteButton
             );
             catergoryList.add(catergoryTm);

             deleteButton.setOnAction(event -> {

                catergoryList.remove(catergoryTm);
                boolean isDeleted;
                try {
                    isDeleted = catergoryService.deleteCatergoryById(catergory.getCatergoryId());
                    if(isDeleted == false){
                        new Alert(Alert.AlertType.ERROR,"Failed To Delete Data!").show();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    
                    e.printStackTrace();
                }

              });
        }

        tblCatergories.setItems(catergoryList);
        tblCatergories.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadCatergoryData(newValue);
            }
        });

    }

    private void loadCatergoryData(CatergoryTm newValue) {
         txtId.setText(newValue.getCat_ID());
         txtName.setText(newValue.getCat_Name());
         txtDescription.setText(newValue.getDescription());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
      Catergory catergory = new Catergory(
        txtId.getText(),
        txtName.getText(),
        txtDescription.getText()
      );

     boolean res =  catergoryService.updateCatergory(catergory);
     if(res){new Alert(Alert.AlertType.CONFIRMATION,"Updated!").show();
        
     }else{
        new Alert(Alert.AlertType.ERROR,"Failed To Update").show();
     }
     getAllRecords();
    }

}
