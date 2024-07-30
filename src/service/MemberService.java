package service;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Member;
import repository.MemberRepository;


public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(){
        memberRepository = new MemberRepository();
    }

    public boolean addMember(Member member) throws ClassNotFoundException, SQLException {
       return memberRepository.addMember(member);
    }

    public ArrayList<Member> loadTable() throws ClassNotFoundException, SQLException {
      return memberRepository.loadTable();
    }

    public boolean deleteMemberById(String memberId) throws ClassNotFoundException, SQLException {
        return memberRepository.deleteMemberById(memberId);
    }

    public boolean updateMember(Member member) throws ClassNotFoundException, SQLException {
      return memberRepository.updateMember(member);
    }
    
}
