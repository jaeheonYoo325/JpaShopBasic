package com.jpabasic.jpashop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpabasic.jpashop.domain.Member_T;
import com.jpabasic.jpashop.domain.Team;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			//저장
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member_T member = new Member_T();
			member.setUsername("member1");
			em.persist(member);
			
			team.addMember(member);
			
			em.flush();
			em.clear();
			
			Team findTeam = em.find(Team.class, team.getId()); //1차 캐시
			List<Member_T> members = findTeam.getMembers();
			
			System.out.println("=======================");
			for(Member_T m : members) {
				System.out.println("m = " + m.getUsername());
			}
			System.out.println("=======================");
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
