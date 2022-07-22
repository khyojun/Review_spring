package com.example.demo_practice.service;

import com.example.demo_practice.domain.Member;
import com.example.demo_practice.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach()
    {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }



    @Test
    void 회원가입() {
        //given
        Member member= new Member();
        member.setName("hello");

        Member member2= new Member();
        member2.setName("hello");




        //when
        Long saveId= memberService.join(member);



        //then
        Member findMember=memberService.findOneMember(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member= new Member();
        member.setName("hello");

        Member member2= new Member();
        member2.setName("hello");

        //when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는회원입니다.");


//        try {
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는회원입니다.");
//        }





        //then

    }


    @Test
    void findMembers() {

    }

    @Test
    void findOneMember() {

    }
}