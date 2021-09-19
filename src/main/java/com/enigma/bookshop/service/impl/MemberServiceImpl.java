package com.enigma.bookshop.service.impl;

import com.enigma.bookshop.constant.ResponseMessage;
import com.enigma.bookshop.entity.Member;
import com.enigma.bookshop.exception.DataNotFoundException;
import com.enigma.bookshop.repository.MemberRepository;
import com.enigma.bookshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member addmMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getmMemberById(String id) {
        verify(id);
        return memberRepository.findById(id).get();
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(Member member) {
        verify(member.getId());
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String id) {
        verify(id);
        memberRepository.deleteById(id);
    }

    private void verify(String id){
        if(!memberRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "members", id);
            throw new DataNotFoundException(message);
        }
    }
}
