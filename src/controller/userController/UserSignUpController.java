package controller.userController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean checkNullTextFields(List<TextField> list){

        for(TextField textField : list){
            if(textField.getText() == null || textField.getText().trim().isEmpty()){
                return false;
            }
        }
        return true;
    }

    @FXML
    void btnBacktoSignInOnAction(ActionEvent event) {
        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }


    @FXML
    void btnContinueOnAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        List<TextField> list = new ArrayList<>();
        list.add(txtName);
        list.add(txtAddress);
        list.add(txtContactNo);
        list.add(txtNicNo);
        list.add(txtUserName);
        list.add(txtPassword);

        if(checkNullTextFields(list)){
            UserSignUpDto newUser = new UserSignUpDto(txtName.getText(), txtNicNo.getText(), txtContactNo.getText(), txtAddress.getText(), txtUserName.getText(),txtPassword.getText());
            int result = userService.userSignUpService(newUser);
    
    
            if(result>0){new Alert(Alert.AlertType.CONFIRMATION,"YOU ARE ADDED TO THE SYSYTEM !").show();
              clear();
            }
            else{
                
                new Alert(Alert.AlertType.ERROR,"FAILE TO ADD !").show();
            }

        }else{
            new Alert(Alert.AlertType.ERROR,"Please Fill All Records").show();
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

        System.out.println("click on singn up");
    }

    public void clear(){
        txtName.setText("");
        txtNicNo.setText("");
        txtContactNo.setText("");
        txtAddress.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
    }
    
}
