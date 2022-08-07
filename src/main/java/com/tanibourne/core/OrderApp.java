package com.tanibourne.core;

import com.tanibourne.core.member.Grade;
import com.tanibourne.core.member.Member;
import com.tanibourne.core.member.MemberService;
import com.tanibourne.core.member.MemberServiceImpl;
import com.tanibourne.core.order.Order;
import com.tanibourne.core.order.OrderService;
import com.tanibourne.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"MemberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
