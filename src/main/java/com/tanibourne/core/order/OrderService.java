package com.tanibourne.core.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int ItemPrice);
}
