package service;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Catergory;
import repository.CatergoryRepository;

public class CatergoryService {

    private CatergoryRepository catergoryRepository;

    public CatergoryService(){
       catergoryRepository = new CatergoryRepository();
    }

    public boolean addBookCatergory(Catergory catergory) throws ClassNotFoundException, SQLException {
       return (catergoryRepository.addBookCatergory(catergory));
    }

    public ArrayList<Catergory> loadTable() throws ClassNotFoundException, SQLException {
       return catergoryRepository.loadTable();
    }

    public boolean deleteCatergoryById(String catergoryId) throws ClassNotFoundException, SQLException {
      return catergoryRepository.deleteCatergoryById(catergoryId);
    }

    public boolean updateCatergory(Catergory catergory) throws ClassNotFoundException, SQLException {
        return catergoryRepository.updateCatergory(catergory);
    }
    
}
