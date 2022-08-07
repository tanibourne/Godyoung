package com.tanibourne.core.order;

import com.tanibourne.core.member.Grade;
import com.tanibourne.core.member.Member;
import com.tanibourne.core.member.MemberService;
import com.tanibourne.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "Itme", 10000);


        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);





    }
}
