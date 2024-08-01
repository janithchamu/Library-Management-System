package controller.userController;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class UserSignin {

    @FXML
    private AnchorPane root;
    
    @FXML
    void btnManageBarrowingOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/MainBarrowingBooks.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
 
        stage.setTitle("New Transaction");
        stage.show();
    }

    @FXML
    void btnManageBookCatergoriesOnAction(ActionEvent event) throws IOException  {

        URL source2 = getClass().getResource("/View/ManageBooksCatergory.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("Book Catergories");
        stage.show();
    }

    @FXML
    void btnManageBooksOnAction(ActionEvent event) throws IOException {
       System.out.println("click on manage books");
       URL source2 = getClass().getResource("/View/ManageBooks.fxml");
       Parent root = FXMLLoader.load(source2);
       //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
       Stage stage = new Stage();
       stage.setScene(new Scene(root));

       stage.setTitle("Books");
       stage.show();
    }

    @FXML
    void btnManageMembersOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/ManageMembers.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
 
        stage.setTitle("Members");
        stage.show();
    }
}
