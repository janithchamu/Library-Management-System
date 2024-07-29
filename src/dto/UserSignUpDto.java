package dto;

public class UserSignUpDto {

    private String name;
    private String nicNo;
    private String contactNo;
    private String address;
    private String userName;
    private String password;
    

    public UserSignUpDto(String name, String nicNo, String contactNo, String address, String userName,
            String password) {
        this.name = name;
        this.nicNo = nicNo;
        this.contactNo = contactNo;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }
    public UserSignUpDto() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNicNo() {
        return nicNo;
    }
    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    

    
}
