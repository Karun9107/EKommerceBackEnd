package com.ekommerce.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekommerce.dao.CustomerRepository;
import com.ekommerce.dto.Purchase;
import com.ekommerce.dto.PurchaseResponse;
import com.ekommerce.model.Customer;
import com.ekommerce.model.Order;

@Service
public class CheckoutServiceImpl implements CheckoutService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		// getting order info from purchase request object
		Order order = purchase.getOrder();	
		
		// setting unique tracking number for order
		order.setOrderTrackingNumber(generateOrderTrackingNumber());
		
		//adding order items to order
		purchase.getOrderItems().forEach(orderItem -> order.addOrderItem(orderItem));
		
		//populate order with shipping and billing address
		order.addAddress(purchase.getShippingAddress(), purchase.getBillingAddress());
		
		//link customer with the order
		Customer customer = purchase.getCustomer();
		customer.addOrder(order);
		
		//save customer information with order details
		customerRepository.save(customer);
		
		//return unique order tracking id
		return new PurchaseResponse(order.getOrderTrackingNumber());
	}

	private String generateOrderTrackingNumber() {	
		return UUID.randomUUID().toString();
	}

}
