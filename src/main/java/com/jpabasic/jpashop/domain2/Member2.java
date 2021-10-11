package com.jpabasic.jpashop.domain2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Member2 extends BaseEntity2 {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

//	@Column(name = "TEAM_ID")
//	private Long teamId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	// 기간
	@Embedded
	private Period workPeriod;

	// 주소
	@Embedded
	private Address2 homeAddress;

	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
	@Column(name = "FOOD_NAME")
	private Set<String> favoriteFoods = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MEMBER_ID")
	private List<AddressEntity2> addressHistory = new ArrayList<>();
	
//	@ElementCollection
//	@CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
//	private List<Address> addressHistory = new ArrayList<>();


//	// 주소
//	@Embedded
//	@AttributeOverrides({
//        @AttributeOverride(name="city", 
//        		column=@Column(name = "WORK_CITY")),
//        @AttributeOverride(name="street", 
//        		column=@Column(name = "WORK_STREET")),
//        @AttributeOverride(name="zipcode", 
//        		column=@Column(name = "WORK_ZIPCODE"))
//	})
//	private Address workAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Period getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Address2 getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address2 homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Set<String> getFavoriteFoods() {
		return favoriteFoods;
	}

	public void setFavoriteFoods(Set<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}

	public List<AddressEntity2> getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(List<AddressEntity2> addressHistory) {
		this.addressHistory = addressHistory;
	}

//	public List<Address> getAddressHistory() {
//		return addressHistory;
//	}
//
//	public void setAddressHistory(List<Address> addressHistory) {
//		this.addressHistory = addressHistory;
//	}

}
