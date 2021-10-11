package com.jpabasic.jpashop;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import com.jpabasic.jpashop.domain.Book;
import com.jpabasic.jpashop.domain.Member;
import com.jpabasic.jpashop.domain2.Address;
import com.jpabasic.jpashop.domain2.AddressEntity;
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
			member.setUsername("member1");
			member.setHomeAddress(new Address("homeCity", "street", "10000"));
			
			member.getFavoriteFoods().add("치킨");
			member.getFavoriteFoods().add("족발");
			member.getFavoriteFoods().add("피자");
			
			member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
			member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
			
			em.persist(member);
			
			em.flush();
			em.clear();
			
			System.out.println("====================== START ======================");
			Member2 findMember = em.find(Member2.class, member.getId());
			
			//homeCity -> newCity
			Address a = findMember.getHomeAddress();
			findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
			
			//치킨 -> 한식
			findMember.getFavoriteFoods().remove("치킨");
			findMember.getFavoriteFoods().add("한식");
			
//			findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
//			findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));
			
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
