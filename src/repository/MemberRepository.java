package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbConnection;
import entity.Member;

public class MemberRepository {

    public boolean addMember(Member member) throws ClassNotFoundException, SQLException {
       PreparedStatement statement =DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO members VALUES(?,?,?,?,?)");
       statement.setString(1, member.getMemberId());
       statement.setString(2, member.getMemberName());
       statement.setString(3, member.getMemberAddress());
       statement.setString(4, member.getMemberContact());
       statement.setString(5, member.getMemberNIC());

       return statement.executeUpdate() >0 ? true : false ;
    }

    public ArrayList<Member> loadTable() throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM members");
       ResultSet resultSet = statement.executeQuery();
       ArrayList<Member> List = new ArrayList<>();
       while(resultSet.next()){
            Member member = new Member(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5)
            );
            List.add(member);      
       }
       return List;
    }

    public boolean deleteMemberById(String memberId) throws ClassNotFoundException, SQLException {
       PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM members WHERE memberId = ?");
       statement.setString(1, memberId);
       return statement.executeUpdate()>0 ? true :false;
    }

    public boolean updateMember(Member member) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE members SET memberName = ?, memberAddress = ?, memberContact = ?, memberNIC = ? WHERE memberId = ?");
        statement.setString(1, member.getMemberName());
        statement.setString(2,member.getMemberAddress());
        statement.setString(3,member.getMemberContact());
        statement.setString(4, member.getMemberNIC());
        statement.setString(5,member.getMemberId());

        return statement.executeUpdate() > 0 ? true:false;
    }
    
}
