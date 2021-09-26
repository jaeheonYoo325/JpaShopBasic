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
			member.setTeam(team);
			em.persist(member);
			
			em.flush();
			em.clear();
			
			Member_T findMember = em.find(Member_T.class, member.getId());
			List<Member_T> members = findMember.getTeam().getMembers();
			
			for(Member_T m : members) {
				System.out.println("m = " + m.getUsername());
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
