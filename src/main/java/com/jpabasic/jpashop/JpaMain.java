package com.jpabasic.jpashop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpabasic.jpashop.domain2.Item2;
import com.jpabasic.jpashop.domain2.Member2;
import com.jpabasic.jpashop.domain2.Movie;
import com.jpabasic.jpashop.domain2.Team;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			Movie movie = new Movie();
			movie.setDirector("aaaa");
			movie.setActor("bbbb");
			movie.setName("바람과함께사라지다.");
			movie.setPrice(10000);
			
			em.persist(movie);
			
			em.flush();
			em.clear();
			
//			Movie findMovie = em.find(Movie.class, movie.getId());
//			System.out.println("findMovie = " + findMovie);
			
			Item2 item = em.find(Item2.class, movie.getId());
			System.out.println("item = " + item);
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
