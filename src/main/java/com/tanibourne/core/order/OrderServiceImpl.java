package com.tanibourne.core.order;

import com.tanibourne.core.discount.DiscountPolicy;
import com.tanibourne.core.discount.FixDiscountPolicy;
import com.tanibourne.core.member.Member;
import com.tanibourne.core.member.MemberRepository;
import com.tanibourne.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
