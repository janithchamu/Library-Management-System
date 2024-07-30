package dto;

public class BookDto {

    private String bookId;
    private String bookName;
    private String  bookDescription;
    private String author;
    private String catergoryId;

    public BookDto() {
    }

    public BookDto(String bookId, String bookName, String bookDescription, String author, String catergoryId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.author = author;
        this.catergoryId = catergoryId;
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

    public String getCatergoryId() {
        return catergoryId;
    }

    public void setCatergoryId(String catergoryId) {
        this.catergoryId = catergoryId;
    }


     
    
    
}
