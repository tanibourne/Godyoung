package com.tanibourne.core;

import com.tanibourne.core.member.Grade;
import com.tanibourne.core.member.Member;
import com.tanibourne.core.member.MemberService;
import com.tanibourne.core.member.MemberServiceImpl;

import static com.tanibourne.core.member.Grade.VIP;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("findmember = " + findmember.getName());
        System.out.println("member = " + member.getName());

    }
}
