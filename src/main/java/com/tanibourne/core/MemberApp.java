package com.tanibourne.core;

import com.tanibourne.core.member.Member;
import com.tanibourne.core.member.MemberService;
import com.tanibourne.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.tanibourne.core.member.Grade.VIP;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig  = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl(memberRepository);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
       MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("findmember = " + findmember.getName());
        System.out.println("member = " + member.getName());

    }
}
