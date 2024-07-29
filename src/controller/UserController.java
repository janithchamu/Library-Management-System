package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import dto.UserSignInDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.UserService;


public class UserController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;
    
    private UserService userService;

    public  UserController(){
        userService = new UserService();
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
       UserSignInDto userSignInDto = new UserSignInDto(txtUserName.getText(), txtPassword.getText());
       int res = userService.userSignIn(userSignInDto);
       
       switch (res) {
        case 1:
           // new Alert(Alert.AlertType.CONFIRMATION,"Welcome To IJSE Library!").show();
            URL source3 = getClass().getResource("/View/signIn.fxml");
            Parent root = FXMLLoader.load(source3);
            //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            stage.setTitle("Welcome");
            stage.show();

           
            break;
        case 2:
            new Alert(Alert.AlertType.ERROR,"INCORRECT PASSWORD OR USERNAME!").show();
            break;
        default:
            new Alert(Alert.AlertType.ERROR,"YOU NEED TO SIGNUP FIRST!").show();
            break;
       }

      System.out.println("click sign in");
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/signUp.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("Library of IJSE");
        stage.show();
    }


    public void test(){
        System.out.println("i am here");
    }
}
