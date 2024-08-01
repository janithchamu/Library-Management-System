package service;

import java.sql.SQLException;
import java.time.LocalDate;

import dto.BarrowingDto;
import dto.FineDto;
import entity.Barrowing;
import repository.RetainRepository;

public class RetainService {
    private RetainRepository retainRepository;

    public RetainService(){
        retainRepository = new RetainRepository();
    }

    public BarrowingDto loadRecord(String memberId, String bookId) throws ClassNotFoundException, SQLException {
       return retainRepository.loadRecord(memberId, bookId);
    }

    public boolean addFine(FineDto fineDto) throws ClassNotFoundException, SQLException {
       return retainRepository.addFine(fineDto);
    }

    public boolean updateTransaction(Integer transactionId, LocalDate returnDate) throws ClassNotFoundException, SQLException {
       return retainRepository.updateTransaction(transactionId, returnDate);
    }
    
}
