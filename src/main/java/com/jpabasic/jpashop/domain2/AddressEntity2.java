package com.jpabasic.jpashop.domain2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity2 {

	@Id
	@GeneratedValue
	private Long id;

	private Address2 address;

	public AddressEntity2() {}
	
	public AddressEntity2(String city, String street, String zipcode) {
		this.address = new Address2(city, street, zipcode);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address2 getAddress() {
		return address;
	}

	public void setAddress(Address2 address) {
		this.address = address;
	}

}
