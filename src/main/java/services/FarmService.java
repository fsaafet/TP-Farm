package services;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity.Farm;


public class FarmService {
	public static void main(String[] args ) {
	System.out.println(getFarmByID(1) );
	for (Farm F :getAll()){
		System.out.println(F);
		System.out.println(F.getMachine());
	}
	
	
	}
	public static 	Farm getFarmByID (int id) {
	      EntityManagerFactory emf=null;
	      EntityManager em =null;
	      
		try {
			emf=Persistence.createEntityManagerFactory("my-jpa-conf");
			em=emf.createEntityManager();
			 return em.find(Farm.class, id);
		}finally {
			if (emf!=null) emf.close();
			if (em!=null) emf.close();
		}
	}
	
	
	public static List<Farm> getAll(){
	
		  EntityManagerFactory emf=null;
	      EntityManager em =null;
	      
		try {
			emf=Persistence.createEntityManagerFactory("my-jpa-conf");
			em=emf.createEntityManager();
			return em.createQuery("From Farm",Farm.class).getResultList();
		}finally {
			if (emf!=null) emf.close();
			if (em!=null) emf.close();
		}
	}
	public static void update (Farm F ){
		
		  EntityManagerFactory emf=null;
	      EntityManager em =null;
	      
		try {
			emf=Persistence.createEntityManagerFactory("my-jpa-conf");
			em=emf.createEntityManager();
			EntityTransaction trans =em.getTransaction();
			trans.begin();
			Farm farm=em.find(Farm.class, F.getId());
			farm.setDestinataire(F.getDestinataire());
			farm.setLocalisation(F.getLocalisation());
			farm.setSurface(F.getSurface());
			em.persist(farm);
			trans.commit();
		}finally {
			if (emf!=null) emf.close();
			if (em!=null) emf.close();
		}
	}
	
	/*public static void create (Farm F) {
		 EntityManagerFactory emf=null;
	      EntityManager em =null;
	      
		try {
			emf=Persistence.createEntityManagerFactory("my-jpa-conf");
			em=emf.createEntityManager();
			EntityTransaction trans=em.getTransaction();
			trans.begin();
			em.persist(F.getMachine());
			trans.commit();
		}finally {
			if (emf!=null) emf.close();
			if (em!=null) emf.close();
		}
	}*/
	public static void delete (int id ) {
		 EntityManagerFactory emf=null;
	      EntityManager em =null;
	      
		try {
			emf=Persistence.createEntityManagerFactory("my-jpa-conf");
			em=emf.createEntityManager();
			EntityTransaction trans=em.getTransaction();
			trans.begin();
			Farm farm=em.find(Farm.class, id);
			em.remove(farm);
			em.remove(farm.getId());
			
			trans.commit();
		}finally {
			if (emf!=null) emf.close();
			if (em!=null) emf.close();
		}
	}
	
	
}
	
