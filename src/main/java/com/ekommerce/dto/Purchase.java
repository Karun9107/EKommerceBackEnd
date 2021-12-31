package com.ekommerce.dto;

import java.util.Set;

import com.ekommerce.model.Address;
import com.ekommerce.model.Customer;
import com.ekommerce.model.Order;
import com.ekommerce.model.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Purchase {
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
}
