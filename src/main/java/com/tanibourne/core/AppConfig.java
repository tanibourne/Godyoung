package com.tanibourne.core;

import com.tanibourne.core.discount.DiscountPolicy;
import com.tanibourne.core.discount.FixDiscountPolicy;
import com.tanibourne.core.discount.RateDiscountPolicy;
import com.tanibourne.core.member.MemberRepository;
import com.tanibourne.core.member.MemberService;
import com.tanibourne.core.member.MemberServiceImpl;
import com.tanibourne.core.member.MemoryMemberRepository;
import com.tanibourne.core.order.OrderService;
import com.tanibourne.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(getMemberRepository());
    }
    @Bean
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
