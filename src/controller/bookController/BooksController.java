package controller.bookController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookDto;
import dto.BookDtoRes;
import entity.Book;
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
import service.BookService;
import tm.BookTm;


public class BooksController {
    
    @FXML
    private TableColumn<BookTm, String> colAuthor;

    @FXML
    private TableColumn<BookTm, String> colBookID;

    @FXML
    private TableColumn<BookTm, String> colBookName;

    @FXML
    private TableColumn<BookTm, Button> colDelete;

    @FXML
    private TableColumn<BookTm, String> colDescription;

    @FXML
    private TableColumn<BookTm, String> colCatergory;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<BookTm> tblBook;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtCatergory;


    private BookService bookService;

    public BooksController(){
         bookService = new BookService();
    }

    public void initialize() throws ClassNotFoundException, SQLException{
        colBookID.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colCatergory.setCellValueFactory(new PropertyValueFactory<>("Catergory"));
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
        list.add(txtBookId);
        list.add(txtBookName);
        list.add(txtAuthor);
        list.add(txtCatergory);


        if(checkNullTextFields(list) && txtDescription.getText() != null && !txtDescription.getText().trim().isEmpty()){
            BookDto bookDto = new BookDto(
                txtBookId.getText(),
                txtBookName.getText(),
                txtDescription.getText(),
                txtAuthor.getText(),
                txtCatergory.getText()
             );
            boolean isAdd =  bookService.addBook(bookDto);
            if(isAdd){
               new Alert(Alert.AlertType.CONFIRMATION,"Added Succesfully !").show();
               clearTexts();
            }else{
                new Alert(Alert.AlertType.ERROR,"Fail to Add !").show();
            }
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Please Complete All records").show();
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        BookDto bookDto = new BookDto(
            txtBookId.getText(),
            txtBookName.getText(),
            txtDescription.getText(),
            txtAuthor.getText(),
            txtCatergory.getText()
         );
        boolean isUpdate = bookService.updateBook(bookDto);
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Updae Succesfully !").show();
            clearTexts();
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Fail to Add !").show();
        }
        getAllRecords();
    }

    @FXML
    void btnLoadTableOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        getAllRecords();
    }

    public void getAllRecords() throws ClassNotFoundException, SQLException{
        ArrayList<BookDtoRes> List = bookService.loadTable();
        ObservableList<BookTm> bookList = FXCollections.observableArrayList();

        for(BookDtoRes book : List){
             Button deleteButton = new Button("Delete");
             BookTm bookTm = new BookTm(
                book.getBookId(),
                book.getBookName(),
                book.getBookDescription(),
                book.getAuthor(),
                book.getCatergory(),
                deleteButton
             );
             bookList.add(bookTm);

             deleteButton.setOnAction(event -> {

                bookList.remove(bookTm);
                boolean isDeleted;
                try {
                    isDeleted = bookService.deleteBookById(bookTm.getBookId());
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
        tblBook.setItems(bookList);
        tblBook.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadBookData(newValue);
            }
        });

    }

    private void loadBookData(BookTm newValue) {
         txtBookId.setText(newValue.getBookId());
         txtBookName.setText(newValue.getBookName());
         txtDescription.setText(newValue.getDescription());
         txtAuthor.setText(newValue.getAuthor());
         txtCatergory.setText(null);
    }

    public void clearTexts(){
        txtAuthor.setText("");
        txtBookId.setText("");
        txtBookName.setText("");
        txtDescription.setText("");
        txtCatergory.setText("");
        
    }
}
