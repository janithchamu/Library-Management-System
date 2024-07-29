package tm;

import javafx.scene.control.Button;

public class BookTm {
    private String BookId;
    private String BookName;
    private String Description;
    private String Author;
    private Button btnDelete;

    

    public BookTm(String bookId, String bookName, String description, String author, Button btnDelete) {
        BookId = bookId;
        BookName = bookName;
        Description = description;
        Author = author;
        this.btnDelete = btnDelete;
    }
    public BookTm() {
    }
    public String getBookId() {
        return BookId;
    }
    public void setBookId(String bookId) {
        BookId = bookId;
    }
    public String getBookName() {
        return BookName;
    }
    public void setBookName(String bookName) {
        BookName = bookName;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    
}
