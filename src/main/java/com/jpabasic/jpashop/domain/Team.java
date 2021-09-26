package com.jpabasic.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;

	@OneToMany(mappedBy = "team")
	private List<Member_T> members = new ArrayList<>();

	public void addMember(Member_T member) {
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

	public List<Member_T> getMembers() {
		return members;
	}

	public void setMembers(List<Member_T> members) {
		this.members = members;
	}

}
