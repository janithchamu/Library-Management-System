package service;

import java.sql.SQLException;

import entity.Barrowing;
import entity.Book;
import entity.Member;
import repository.NewBarrowingRepository;

public class NewBarrowingService {

    private NewBarrowingRepository newBarrowingRepository;

    public NewBarrowingService(){
        newBarrowingRepository = new NewBarrowingRepository();
    }

    public Member searchMember(String memberId) throws ClassNotFoundException, SQLException {
        return newBarrowingRepository.searchMember(memberId);
    }

    public Book searchBook(String bookId) throws ClassNotFoundException, SQLException {
       return newBarrowingRepository.searchBook(bookId);
    }

    public boolean newBookBarrowing(Barrowing bookBarrowing) throws ClassNotFoundException, SQLException {
      return newBarrowingRepository.newBookBarrowing(bookBarrowing);
    }
    
}
