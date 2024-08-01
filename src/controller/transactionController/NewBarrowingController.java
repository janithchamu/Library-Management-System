package controller.transactionController;

import java.sql.SQLException;
import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;

import entity.Barrowing;
import entity.Book;
import entity.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import service.NewBarrowingService;

public class NewBarrowingController {
    @FXML
    private JFXButton btnBarrow;

    @FXML
    private JFXButton btnSearchBook;

    @FXML
    private JFXButton btnSearchMember;
    
    @FXML
    private DatePicker dpBarrowDate;

    @FXML
    private DatePicker dpDueDate;

    @FXML
    private AnchorPane root;

    @FXML
    private TextArea txtBookDetails;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextArea txtMemberDetails;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtTransBookId;

    @FXML
    private TextField txtTransMemberId;

    private NewBarrowingService newBarrowingService;

    public NewBarrowingController(){
        newBarrowingService = new NewBarrowingService();
    }

    public void initialize(){
        txtTransBookId.setEditable(false);
        txtTransMemberId.setEditable(false);
        dpBarrowDate.setValue(LocalDate.now());
    }

    @FXML
    void btnSearchBookOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        btnBarrow.setDisable(false);
        btnSearchBook.setDisable(false);
       String bookId = txtBookId.getText();

       if(txtBookId.getText() != null && !txtBookId.getText().trim().isEmpty()){
            txtTransBookId.setText(bookId);
        
            Book book = newBarrowingService.searchBook(bookId);
            if(book != null){
               txtBookDetails.setText(book.toString());
            }
            else{
                txtBookDetails.setText("No Book Record");
                btnBarrow.setDisable(true);
                
    
            }
       }
       else{
        new Alert(Alert.AlertType.ERROR,"Please Enter Book ID").show();
       }


       
       

    }

    @FXML
    void btnSearchMemberOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        btnBarrow.setDisable(false);
        btnSearchBook.setDisable(false);
         String memberId = txtMemberId.getText();
        if(txtMemberId.getText() != null && !txtMemberId.getText().trim().isEmpty()){
            txtTransMemberId.setText(memberId);
            Member member = newBarrowingService.searchMember(memberId);
            if(member != null){
               txtMemberDetails.setText(member.toString());
            }
            else{
               txtMemberDetails.setText("No Member Record");
               btnBarrow.setDisable(true);
               btnSearchBook.setDisable(true);
            }
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Please Enter Member ID").show();
        }

         
         
    }

    @FXML
    void btnBarrowOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(dpDueDate.getValue() != null){
            Barrowing bookBarrowing = new Barrowing(
                txtMemberId.getText(),
                txtBookId.getText(),
                dpBarrowDate.getValue(),
                dpDueDate.getValue(),
                dpDueDate.getValue(),
                true
    
            );
    
            boolean res = newBarrowingService.newBookBarrowing(bookBarrowing);
            if(res){
                new Alert(Alert.AlertType.CONFIRMATION,"Succesfully !").show();
                clearTexts();
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Fail to Record !").show();
            }
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Pleace Pick Due Date !").show();
        }

    }

    private void clearTexts() {
        txtBookDetails.setText("");
        txtBookId.setText("");
        txtMemberDetails.setText("");
        txtMemberId.setText("");
        txtTransBookId.setText("");
        txtTransMemberId.setText("");
        dpBarrowDate.setValue(null);
        dpDueDate.setValue(null);
    }
}
