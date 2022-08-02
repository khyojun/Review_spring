package com.example.demo_practice;


import com.example.demo_practice.repository.JdbcMemberRepository;
import com.example.demo_practice.repository.MemberRepository;
import com.example.demo_practice.repository.MemoryMemberRepository;
import com.example.demo_practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }



}
