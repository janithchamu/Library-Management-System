package controller.memberController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.MemberService;
import tm.CatergoryTm;
import tm.MemberTm;

public class MembersController {

    @FXML
    private TableColumn<MemberTm, String> colAddress;

    @FXML
    private TableColumn<MemberTm, String> colContact;

    @FXML
    private TableColumn<MemberTm, String> colDelete;

    @FXML
    private TableColumn<MemberTm, String> colId;

    @FXML
    private TableColumn<MemberTm, String> colNIC;

    @FXML
    private TableColumn<MemberTm, String> colName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<MemberTm> tblMembers;

    @FXML
    private TextField txtMemberAddress;

    @FXML
    private TextField txtMemberContact;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtMemberNIC;

    @FXML
    private TextField txtMemberName;
   
    private MemberService memberService;

    public MembersController(){
        memberService = new MemberService();
    }

    public void initialize() throws ClassNotFoundException, SQLException{
       colId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
       colName.setCellValueFactory(new PropertyValueFactory<>("memberName"));
       colAddress.setCellValueFactory(new PropertyValueFactory<>("memberAddress"));
       colContact.setCellValueFactory(new PropertyValueFactory<>("memberContact"));
       colNIC.setCellValueFactory(new PropertyValueFactory<>("memberNIC"));
       colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
       getAllRecords();
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
    void btnAddOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        List<TextField> list = new ArrayList<>();
        list.add(txtMemberAddress);
        list.add(txtMemberContact);
        list.add(txtMemberID);
        list.add(txtMemberNIC);
        list.add(txtMemberName);
        if(checkNullTextFields(list)){
            Member member = new Member(
                txtMemberID.getText(),
                txtMemberName.getText(),
                txtMemberAddress.getText(),
                txtMemberContact.getText(),
                txtMemberNIC.getText()
            );
            boolean res = memberService.addMember(member);
            if(res){
                new Alert(Alert.AlertType.CONFIRMATION,"Added Succesfully !").show();
                 clearTexts();
             }else{
                 new Alert(Alert.AlertType.ERROR,"Fail to Add !").show();
             }
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Please Complete All Fields").show();
        }
    


    }

    private void clearTexts() {
        txtMemberAddress.setText("");
        txtMemberContact.setText("");
        txtMemberID.setText("");
        txtMemberNIC.setText("");
        txtMemberName.setText("");
    }

    @FXML
    void btnLoadTableOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
       
          getAllRecords();

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        Member member = new Member(
            txtMemberID.getText(),
            txtMemberName.getText(),
            txtMemberAddress.getText(),
            txtMemberContact.getText(),
            txtMemberNIC.getText()
        );
       boolean isUpdate =  memberService.updateMember(member);
       if(isUpdate){
        new Alert(Alert.AlertType.CONFIRMATION,"Updae Succesfully !").show();
        clearTexts();
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Fail to Add !").show();
        }
        getAllRecords();

    }

    public void getAllRecords() throws ClassNotFoundException, SQLException{
        ArrayList<Member> List = memberService.loadTable();
        ObservableList<MemberTm> memberList = FXCollections.observableArrayList();
        for(Member member : List){
            Button deleteButton = new Button("Delete");
            MemberTm memberTm = new MemberTm(
                member.getMemberId(),
                member.getMemberName(),
                member.getMemberAddress(),
                member.getMemberContact(),
                member.getMemberNIC(),
                deleteButton
            );
            memberList.add(memberTm);
            deleteButton.setOnAction(event -> {

                memberList.remove(memberTm);
                boolean isDeleted;
                try {
                    isDeleted = memberService.deleteMemberById(memberTm.getMemberId());
                    if(isDeleted == false){
                        new Alert(Alert.AlertType.ERROR,"Failed To Delete Data!").show();
                    }
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


              });
        }
        tblMembers.setItems(memberList);
        tblMembers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtMemberID.setText(newValue.getMemberId());
                txtMemberName.setText(newValue.getMemberName());
                txtMemberAddress.setText(newValue.getMemberAddress());
                txtMemberContact.setText(newValue.getMemberContact());
                txtMemberNIC.setText(newValue.getMemberNIC());
            }
        });
    }
}
