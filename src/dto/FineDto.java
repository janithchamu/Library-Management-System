package dto;

import java.time.LocalDate;

public class FineDto {
    private Integer transactionId;
    private LocalDate fineDate;
    private double fine;
    private boolean paid;
   

    public FineDto() {
    }
    public FineDto(Integer transactionId, LocalDate fineDate, double fine, boolean paid) {
        this.transactionId = transactionId;
        this.fineDate = fineDate;
        this.fine = fine;
        this.paid = paid;
    }
    public Integer getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
    public LocalDate getFineDate() {
        return fineDate;
    }
    public void setFineDate(LocalDate fineDate) {
        this.fineDate = fineDate;
    }
    public double getFine() {
        return fine;
    }
    public void setFine(double fine) {
        this.fine = fine;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    @Override
    public String toString() {
        return "FineDto [transactionId=" + transactionId + ", fineDate=" + fineDate + ", fine=" + fine + ", paid="
                + paid + "]";
    }

    
    
    
}
