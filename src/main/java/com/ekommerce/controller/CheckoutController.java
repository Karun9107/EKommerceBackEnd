package com.ekommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekommerce.dto.Purchase;
import com.ekommerce.dto.PurchaseResponse;
import com.ekommerce.service.CheckoutService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	@Autowired
	private CheckoutService checkoutService;
	
	@PostMapping("/purchase")
	public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody Purchase purchase) {
		return new ResponseEntity<PurchaseResponse>(checkoutService.placeOrder(purchase), HttpStatus.OK);
	}
	

}
