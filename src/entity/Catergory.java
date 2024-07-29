package entity;

public class Catergory {

    private String catergoryId;
    private String catergoryName;
    private String catergoryDescription;

    public Catergory(String catergoryId, String catergoryName, String catergoryDescription) {
        this.catergoryId = catergoryId;
        this.catergoryName = catergoryName;
        this.catergoryDescription = catergoryDescription;
    }
    public Catergory() {
    }
    public String getCatergoryId() {
        return catergoryId;
    }
    public void setCatergoryId(String catergoryId) {
        this.catergoryId = catergoryId;
    }
    public String getCatergoryName() {
        return catergoryName;
    }
    public void setCatergoryName(String catergoryName) {
        this.catergoryName = catergoryName;
    }
    public String getDescription() {
        return catergoryDescription;
    }
    public void setDescription(String catergoryDescription) {
        this.catergoryDescription = catergoryDescription;
    }

    
    
}
