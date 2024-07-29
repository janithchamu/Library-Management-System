package controller;

import java.sql.SQLException;
import java.util.ArrayList;

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

    private BookService bookService;

    public BooksController(){
         bookService = new BookService();
    }

    public void initialize() throws ClassNotFoundException, SQLException{
        colBookID.setCellValueFactory(new PropertyValueFactory<>("BookId"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
        getAllRecords();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
         Book book = new Book(
            txtBookId.getText(),
            txtBookName.getText(),
            txtDescription.getText(),
            txtAuthor.getText()
         );
        boolean isAdd =  bookService.addBook(book);
        if(isAdd){
           new Alert(Alert.AlertType.CONFIRMATION,"Added Succesfully !").show();
           clearTexts();
        }else{
            new Alert(Alert.AlertType.ERROR,"Fail to Add !").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        Book book = new Book(
            txtBookId.getText(),
            txtBookName.getText(),
            txtDescription.getText(),
            txtAuthor.getText()
         );
        boolean isUpdate = bookService.updateBook(book);
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
         ArrayList<Book> List = bookService.loadTable();
        ObservableList<BookTm> bookList = FXCollections.observableArrayList();

        for(Book book : List){
             Button deleteButton = new Button("Delete");
             BookTm bookTm = new BookTm(
                book.getBookId(),
                book.getBookName(),
                book.getBookDescription(),
                book.getAuthor(),
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
    }

    public void clearTexts(){
        txtAuthor.setText("");
        txtBookId.setText("");
        txtBookName.setText("");
        txtDescription.setText("");
        
    }
}
