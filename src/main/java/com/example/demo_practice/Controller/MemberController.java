package com.example.demo_practice.Controller;

import com.example.demo_practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class MemberController {
    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

}
