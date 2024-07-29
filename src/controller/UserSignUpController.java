package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import dto.UserSignUpDto;
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

public class UserSignUpController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNicNo;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    private UserService userService;

    // private Stage stage;

    public UserSignUpController(){
        userService = new UserService();
        // this.stage = stage;
    }

    @FXML
    void btnBacktoSignInOnAction(ActionEvent event) {
        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }


    @FXML
    void btnContinueOnAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        UserSignUpDto newUser = new UserSignUpDto(txtName.getText(), txtNicNo.getText(), txtContactNo.getText(), txtAddress.getText(), txtUserName.getText(),txtPassword.getText());
        int result = userService.userSignUpService(newUser);


        if(result>0){new Alert(Alert.AlertType.CONFIRMATION,"YOU ARE ADDED TO THE SYSYTEM !").show();
        }
        else{
            
            new Alert(Alert.AlertType.ERROR,"FAILE TO ADD !").show();
        }
        
        
        
        // switch (result) {
        //     case 1:
        //         new Alert(Alert.AlertType.CONFIRMATION,"YOU ARE ADDED TO THE SYSYTEM !").show();
        //         break;
        //     case 0:
        //         new Alert(Alert.AlertType.CONFIRMATION,"FAILE TO ADD !").show();
        //         break;
        
        //     default:
        //         break;
        // }\
        txtName.setText("");
        txtNicNo.setText("");
        txtContactNo.setText("");
        txtAddress.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        System.out.println("click on singn up");
    }
    
}
