package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.entity.Member;
import com.enigma.bookshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member){
        return memberService.addmMember(member);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable String id){
        return memberService.getmMemberById(id);
    }

    @GetMapping
    public List<Member> getAllMember(){
        return memberService.getAllMember();
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member){
        return memberService.updateMember(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable String id){
        memberService.deleteMember(id);
    }
}
