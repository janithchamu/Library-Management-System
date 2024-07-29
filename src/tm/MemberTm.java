package tm;

import javafx.scene.control.Button;

public class MemberTm {
    private String memberId;
    private String memberName;
    private String memberAddress;
    private String memberContact;
    private String memberNIC;
    private Button btnDelete;

    
    
    public MemberTm(String memberId, String memberName, String memberAddress, String memberContact, String memberNIC,
            Button btnDelete) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberContact = memberContact;
        this.memberNIC = memberNIC;
        this.btnDelete = btnDelete;
    }
    public MemberTm() {
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberAddress() {
        return memberAddress;
    }
    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }
    public String getMemberContact() {
        return memberContact;
    }
    public void setMemberContact(String memberContact) {
        this.memberContact = memberContact;
    }
    public String getMemberNIC() {
        return memberNIC;
    }
    public void setMemberNIC(String memberNIC) {
        this.memberNIC = memberNIC;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
    
    
    
}
