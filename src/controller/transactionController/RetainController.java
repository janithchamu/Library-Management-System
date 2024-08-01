package controller.transactionController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.jfoenix.controls.JFXButton;

import dto.BarrowingDto;
import dto.FineDto;
import entity.Barrowing;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import service.RetainService;

public class RetainController {

    
    @FXML
    private JFXButton btnAddFine;

    @FXML
    private JFXButton btnComplete;

    @FXML
    private JFXButton btnLoadFine;

    @FXML
    private JFXButton btnNoFine;
    @FXML
    private ChoiceBox<String> cbStatus;

    @FXML
    private ChoiceBox<String> cbPaid;;

    @FXML
    private DatePicker dpReatin;

    @FXML
    private Label lblRetain;

    @FXML
    private Label lblStatus;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBarrowDate;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtDueDate;

    @FXML
    private TextField txtFinAmount;

    @FXML
    private TextField txtFineDate;

    @FXML
    private TextArea txtFineFeild;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtSearchBookId;

    @FXML
    private TextField txtSearchMemberId;

    @FXML
    private TextField txtTransactionId;

    @FXML
    private Label lblError;

    @FXML
    private Label lblError2;


    private RetainService retainService;

    public RetainController(){
        retainService = new RetainService();
    }

    public void initialize(){
        ObservableList<String> choices = FXCollections.observableArrayList("Yes", "No");
        cbStatus.setItems(choices);
        cbStatus.setValue("Yes");

        cbPaid.setItems(choices);
        cbPaid.setValue("Yes");
        txtMemberId.setEditable(false);
        txtBookId.setEditable(false);
        txtBarrowDate.setEditable(false);
        txtDueDate.setEditable(false);
        txtFineFeild.setEditable(false);
        btnComplete.setDisable(true);
        dpReatin.setValue(LocalDate.now());
    }
    
    @FXML
    void btnLoadRecordOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {

        lblError.setText("");
        lblError2.setText("");
       if(txtSearchMemberId.getText() == null || txtSearchMemberId.getText().trim().isEmpty()){
           lblError.setText("Enter MemberID");
           lblError.setStyle("-fx-text-fill: red;");
       }
       else if(txtSearchBookId.getText() == null || txtSearchBookId.getText().trim().isEmpty() ){
        lblError2.setText("Enter BookID");
        lblError2.setStyle("-fx-text-fill: red;");
       }
       else{

                txtMemberId.setText("");
                txtBookId.setText("");
                txtBarrowDate.setText("");
                txtDueDate.setText("");
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            BarrowingDto bookBarrowed = retainService.loadRecord(txtSearchMemberId.getText(), txtSearchBookId.getText());
            if(bookBarrowed != null){
                    dpReatin.setValue(LocalDate.now());
                    lblStatus.setText("AVAILABLE");
                    lblStatus.setStyle("-fx-text-fill: blue;");
                    txtMemberId.setText(bookBarrowed.getMemberId());
                    txtBookId.setText(bookBarrowed.getBookId());
                    txtBarrowDate.setText((bookBarrowed.getBarrowDate()).format(formatter));
                    txtDueDate.setText((bookBarrowed.getDueDate()).format(formatter));
                    cbStatus.setValue(bookBarrowed.isStatus() ? "Yes":"No");
                    lblRetain.setText(bookBarrowed.isStatus() ? "Book was retained":" Not Retain Yet ");
                    lblRetain.setStyle(bookBarrowed.isStatus() ?  "-fx-text-fill: blue;":"-fx-text-fill: red;");
                    if(bookBarrowed.isStatus()){
                        dpReatin.setValue(bookBarrowed.getReturnDate());
                        new Alert(Alert.AlertType.CONFIRMATION,"Book already retained on "+dpReatin.getValue()).show();
                    }

            }
            else{
                lblStatus.setText("NOT AVAILABLE");
                lblStatus.setStyle("-fx-text-fill: red;");
                lblRetain.setText("Book already retaiied or No Record saved");
                lblRetain.setStyle("-fx-text-fill: blue;");
            }

        }


       
    }


    @FXML
    void btnNoFineOnActioon(ActionEvent event) throws ClassNotFoundException, SQLException {
        BarrowingDto bookBarrowed = retainService.loadRecord(txtSearchMemberId.getText(), txtSearchBookId.getText());
        boolean res = retainService.updateTransaction(bookBarrowed.getTransactionId(),bookBarrowed.getReturnDate());
        if(res){
            new Alert(Alert.AlertType.CONFIRMATION,"Retain Book successfully").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Fail to Complete").show();
        }


    }

    @FXML
    void btnRetainCompleteOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        BarrowingDto bookBarrowed = retainService.loadRecord(txtSearchMemberId.getText(), txtSearchBookId.getText());
        boolean res = retainService.updateTransaction(bookBarrowed.getTransactionId(),bookBarrowed.getReturnDate());
        if(res){
            new Alert(Alert.AlertType.CONFIRMATION,"Retain Book successfully").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Fail to Complete").show();
        }

    }

    @FXML
    void btnAddFineOnAction(ActionEvent event) throws ClassNotFoundException, SQLException  {
        btnComplete.setDisable(false);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BarrowingDto bookBarrowed = retainService.loadRecord(txtSearchMemberId.getText(), txtSearchBookId.getText());
        FineDto fineDto = new FineDto(
            bookBarrowed.getTransactionId(),
            dpReatin.getValue(),
            Double.parseDouble(txtFinAmount.getText()),
            (cbPaid.getValue()).equals("No") ? false:true
        );
        boolean res = retainService.addFine(fineDto);
        if(res){
            new Alert(Alert.AlertType.CONFIRMATION,"Paid successfully").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Fail !").show();
        }
      
    }

    @FXML
    void btnCheckFineOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
      BarrowingDto bookBarrowed = retainService.loadRecord(txtSearchMemberId.getText(), txtSearchBookId.getText());
      
      int dayDiffrence = Period.between(bookBarrowed.getBarrowDate(),dpReatin.getValue()).getDays();
      if(dayDiffrence > 14){
        Double fine =(dayDiffrence -14) * 25.00;
        txtFineFeild.setText("Member got almost "+dayDiffrence+" days to retain the book.\nMembers' Fine = Rs "+fine);
        txtFineFeild.setStyle("-fx-text-fill: red;");
        btnNoFine.setDisable(true);
        btnLoadFine.setDisable(false);
        btnAddFine.setDisable(false);
        cbPaid.setDisable(false);
      }
      else{
        txtFineFeild.setText("Member retained the book within "+dayDiffrence+" days. No Fine !!!");
        txtFineFeild.setStyle("-fx-text-fill: black;");
        btnLoadFine.setDisable(true);
        btnAddFine.setDisable(true);
        btnComplete.setDisable(true);
        cbPaid.setDisable(true);
        btnNoFine.setDisable(false);

      }
      
    }

    @FXML
    void btnLoadFineOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        BarrowingDto bookBarrowed = retainService.loadRecord(txtSearchMemberId.getText(), txtSearchBookId.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int dayDiffrence = Period.between(bookBarrowed.getBarrowDate(),dpReatin.getValue()).getDays();
        if(dayDiffrence > 14){
            txtTransactionId.setText(bookBarrowed.getTransactionId()+"");
            txtFineDate.setText(dpReatin.getValue().format(formatter));
            
            Double fine =(dayDiffrence -14) * 25.00;
            txtFinAmount.setText(fine+"");
        }else{
            txtTransactionId.setText(bookBarrowed.getTransactionId()+"");
            txtFineDate.setText(dpReatin.getValue().format(formatter));
            
            Double fine = 0.0;
            txtFinAmount.setText(fine+"");
        }

        
    }

    
}
