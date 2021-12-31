package com.ekommerce.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_item")
@Getter
@Setter
public class OrderItem {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private int quantity;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="product_id")
	private Long productId;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	Order order;
	
}
