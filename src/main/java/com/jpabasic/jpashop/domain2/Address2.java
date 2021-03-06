package com.jpabasic.jpashop.domain2;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Address2 {

	// 주소
	private String city;
	private String street;
	private String zipcode;

	public Address2() {
	}

	public Address2(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Address2 address = (Address2) o;
		return Objects.equals(city , address.city) &&
				Objects.equals(street, address.street) &&
				Objects.equals(zipcode, address.zipcode);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(city, street, zipcode);
	}

}
