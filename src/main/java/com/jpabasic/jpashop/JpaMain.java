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
			
			Member2 member1 = new Member2();
			member1.setUsername("member1");
			em.persist(member1);
			
			em.flush();
			em.clear();
			
			Member2 refMember = em.getReference(Member2.class, member1.getId());
			System.out.println("refMember = " + refMember.getClass());
			Hibernate.initialize(refMember);//프록시 강제초기화
			
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
