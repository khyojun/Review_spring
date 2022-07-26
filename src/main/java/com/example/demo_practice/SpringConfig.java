package com.example.demo_practice;


import com.example.demo_practice.repository.MemberRepository;
import com.example.demo_practice.repository.MemoryMemberRepository;
import com.example.demo_practice.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }



}
