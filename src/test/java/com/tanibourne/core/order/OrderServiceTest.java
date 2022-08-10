package com.tanibourne.core.order;

import com.tanibourne.core.AppConfig;
import com.tanibourne.core.member.Grade;
import com.tanibourne.core.member.Member;
import com.tanibourne.core.member.MemberService;
import com.tanibourne.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    //    MemberService memberService = new MemberServiceImpl(memberRepository);
//    OrderService orderService = new OrderServiceImpl();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

    }


    @Test
    void createOrder() {
        //given // 뭐가 주어졌는지 데이터
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

//        grade vip면 천원할인인가?

        //when
        Order order = orderService.createOrder(memberId, "Itme", 10000);


        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}
