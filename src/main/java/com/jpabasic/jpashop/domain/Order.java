package com.jpabasic.jpashop.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	
	@Column(name = "MEMBER_ID")
	private Long memberId;
	
	private LocalDateTime orderDate; //ORDER_DATE, order_date
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
}
