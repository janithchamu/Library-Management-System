package dto;

import java.time.LocalDate;

public class BarrowingDto {
        private Integer transactionId;
    private String memberId;
    private String bookId;
    private LocalDate barrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean status;

    public BarrowingDto() {
    }

    
    public BarrowingDto(Integer transactionId, String memberId, String bookId, LocalDate barrowDate, LocalDate dueDate,
            LocalDate returnDate, boolean status) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.barrowDate = barrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }


    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBarrowDate() {
        return barrowDate;
    }

    public void setBarrowDate(LocalDate barrowDate) {
        this.barrowDate = barrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
