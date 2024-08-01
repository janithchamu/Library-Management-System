package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WelcomeController {

    
    @FXML
    private AnchorPane root;

    @FXML
    private TextArea txtBarrowing;

    @FXML
    private TextArea txtBooks;

    @FXML
    private TextArea txtCatergory;

    @FXML
    private TextArea txtMain;

    @FXML
    private TextArea txtMembers;

    @FXML
    private TextArea txtRetain;

    public void initialize(){
        txtBarrowing.setEditable(false);
        txtBooks.setEditable(false);
        txtCatergory.setEditable(false);
        txtMain.setEditable(false);
        txtMembers.setEditable(false);
        txtRetain.setEditable(false);
    }

    @FXML
    void btnBarrowingOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/NewBarrowingBook.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("Manage Barrowing");
        stage.show();
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/ManageBooks.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("Manage Books");
        stage.show();
    }

    @FXML
    void btnCatergoriesOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/ManageBooksCatergory.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("Manage Book Catergories");
        stage.show();
    }

    @FXML
    void btnMembersOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/ManageMembers.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("Manage Members");
        stage.show();
    }

    @FXML
    void btnRetaiinOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/RetainBook.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("Manage Books Retaing");
        stage.show();
    }
    
}
