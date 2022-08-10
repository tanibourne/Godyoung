package com.tanibourne.core.member;

import com.tanibourne.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }



//    MemberService memberService = new MemberServiceImpl(memberRepository);

    @Test
    void join() {
        //given 주어진 값들이

        Member member = new Member(1L, "memberQ", Grade.VIP);

        //when 어떤 상황에서
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 어떤 결과가 나오는가?
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
