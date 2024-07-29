package tm;

import javafx.scene.control.Button;

public class CatergoryTm {

    private String Cat_ID;
    private String Cat_Name;
    private String Description;
    private Button btnDelete;
   
    

    public CatergoryTm(String cat_ID, String cat_Name, String description, Button btnDelete) {
        Cat_ID = cat_ID;
        Cat_Name = cat_Name;
        Description = description;
        this.btnDelete = btnDelete;
    }

    
    public CatergoryTm() {
    }


    public String getCat_ID() {
        return Cat_ID;
    }
    public void setCat_ID(String cat_ID) {
        Cat_ID = cat_ID;
    }
    public String getCat_Name() {
        return Cat_Name;
    }
    public void setCat_Name(String cat_Name) {
        Cat_Name = cat_Name;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    

    
}