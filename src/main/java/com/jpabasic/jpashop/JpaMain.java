package com.jpabasic.jpashop;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import com.jpabasic.jpashop.domain.Book;
import com.jpabasic.jpashop.domain.Member;
import com.jpabasic.jpashop.domain2.Item2;
import com.jpabasic.jpashop.domain2.Member2;
import com.jpabasic.jpashop.domain2.Movie2;
import com.jpabasic.jpashop.domain2.Team;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Team teamB = new Team();
			teamB.setName("teamB");
			em.persist(teamB);
			
			Member2 member1 = new Member2();
			member1.setUsername("member1");
			member1.setTeam(team);
			em.persist(member1);
			
			Member2 member2 = new Member2();
			member2.setUsername("member2");
			member2.setTeam(teamB);
			em.persist(member2);
			
			em.flush();
			em.clear();
			
//			Member2 m = em.find(Member2.class, member1.getId());
			List<Member2> members = em.createQuery("select m from Member2 m join fetch m.team", Member2.class)
					.getResultList();
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
