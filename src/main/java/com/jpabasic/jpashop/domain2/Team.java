package com.jpabasic.jpashop.domain2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team extends BaseEntity2 {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;

	@OneToMany(mappedBy = "team")
	private List<Member2> members = new ArrayList<>();

	public void addMember(Member2 member) {
		member.setTeam(this);
		members.add(member);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member2> getMembers() {
		return members;
	}

	public void setMembers(List<Member2> members) {
		this.members = members;
	}

}
