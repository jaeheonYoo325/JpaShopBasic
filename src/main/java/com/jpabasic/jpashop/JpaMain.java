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
import com.jpabasic.jpashop.domain2.Address;
import com.jpabasic.jpashop.domain2.Child;
import com.jpabasic.jpashop.domain2.Item2;
import com.jpabasic.jpashop.domain2.Member2;
import com.jpabasic.jpashop.domain2.Movie2;
import com.jpabasic.jpashop.domain2.Parent;
import com.jpabasic.jpashop.domain2.Period;
import com.jpabasic.jpashop.domain2.Team;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			Member2 member = new Member2();
			member.setUsername("hello");
			member.setHomeAddress(new Address("city","street","10000"));
			member.setWorkPeriod(new Period());
			
			em.persist(member);
			
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
