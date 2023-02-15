package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity.animals;
import Entity.machine;

public class AnimauxService {
 
	
	public static void main (String[]args) { 
		System.out.println(getAnimauxByID(2));
		
		
		
		
		for(animals a : getAllanimals()) {
		System.out.println(a);
		System.out.println(a.getFarm());
	}
	}

	public static  animals getAnimauxByID(int id) {
		EntityManagerFactory emf =null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("my-jpa-conf");
			em=emf.createEntityManager();
			return em.find(animals.class, id);
		}finally {
			if(emf!=null)emf.close();
			if(em!=null)emf.close();
		}
		
	}
	public static List<animals> getAllanimals(){
		EntityManagerFactory emf=null;
	     EntityManager em =null;
	     
		try {
			emf=Persistence.createEntityManagerFactory("my-jpa-conf");
			em=emf.createEntityManager();
		    return em.createQuery("From animals",animals.class).getResultList();
		    
		}finally {
			if (emf!=null) emf.close();
			if (em!=null) emf.close();
			}
	}
	}

