package com.ekommerce.service;

import com.ekommerce.dto.Purchase;
import com.ekommerce.dto.PurchaseResponse;

public interface CheckoutService {
	PurchaseResponse placeOrder(Purchase purchase);
}
