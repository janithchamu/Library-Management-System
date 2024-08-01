package entity;

import javafx.scene.control.Button;

public class Book {
    private String bookId;
    private String bookName;
    private String  bookDescription;
    private String author;
    
    
    
    @Override
    public String toString() {
        return "Book ID = " + bookId + "\nBook Name = " + bookName + "\nBook Description = " + bookDescription
                + "\nAuthor = " + author;
    }
    public Book() {
    }
    public Book(String bookId, String bookName, String bookDescription, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.author = author;
      
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookDescription() {
        return bookDescription;
    }
    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }



    
  
    
}
