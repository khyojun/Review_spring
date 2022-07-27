package com.example.demo_practice.service;

import com.example.demo_practice.domain.Member;
import com.example.demo_practice.repository.MemberRepository;
import com.example.demo_practice.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {




    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){// DI
        this.memberRepository = memberRepository;
    }


    public long join(Member member) {

        // 중복회원 조회
        ValidateDuplicate(member);

        memberRepository.save(member);
        return member.getId();

    }

    private void ValidateDuplicate(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는회원입니다.");
        });

    }
    public List<Member> findMembers () {
        return memberRepository.findAll();
    }


    public Optional<Member> findOneMember(Long memberId){
        return memberRepository.findById(memberId);

    }
}
