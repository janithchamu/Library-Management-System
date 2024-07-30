package dto;

public class BookDtoRes {
    private String bookId;
    private String bookName;
    private String  bookDescription;
    private String author;
    private String catergory;
    
    public BookDtoRes() {
    }
    
    
    public BookDtoRes(String bookId, String bookName, String bookDescription, String author, String catergory) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.author = author;
        this.catergory = catergory;
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

    public String getCatergory() {
        return catergory;
    }

    public void setCatergory(String catergory) {
        this.catergory = catergory;
    }


    
    
}
