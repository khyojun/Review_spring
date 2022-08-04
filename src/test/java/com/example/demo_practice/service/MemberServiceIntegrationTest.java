package com.example.demo_practice.service;

import com.example.demo_practice.domain.Member;
import com.example.demo_practice.repository.MemberRepository;
import com.example.demo_practice.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;




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