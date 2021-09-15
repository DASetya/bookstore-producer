package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Member;

import java.util.List;

public interface MemberService {
    public Member addmMember(Member member);
    public Member getmMemberById(String id);
    public List<Member> getAllMember();
    public Member updateMember(Member member);
    public void deleteMember(String id);
}
