package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity.Farm;
import Entity.machine;

public class MachineService {
   public static void main(String[]args) {
	   System.out.println(getMachineByID(1));
	   
      for(machine M :getALLMachines()) {
    	  System.out.println(M);
    	  System.out.println(M.getFarm());
    	  deleteMachine(2);
    	  
    	 /* Farm F=new Farm ("papy","toulouse",25);
          machine M1=new machine("machine4",1500.0,2020–01–01 00:00:00.0);
    	  createMachine (M1); */
      }
   
   }
   
	
	
public static 	machine getMachineByID (int id) {
      EntityManagerFactory emf=null;
      EntityManager em =null;
      
	try {
		emf=Persistence.createEntityManagerFactory("my-jpa-conf");
		em=emf.createEntityManager();
		return em.find(machine.class, id);
	}finally {
		if (emf!=null) emf.close();
		if (em!=null) emf.close();
	}
	
}

public static List <machine> getALLMachines(){
	 EntityManagerFactory emf=null;
     EntityManager em =null;
     
	try {
		emf=Persistence.createEntityManagerFactory("my-jpa-conf");
		em=emf.createEntityManager();
	    return em.createQuery("From machine",machine.class).getResultList();
	    
	}finally {
		if (emf!=null) emf.close();
		if (em!=null) emf.close();
		}
}
	

public static void createMachine (machine M) {
	
	 EntityManagerFactory emf1=null;
     EntityManager em1 =null;
	try {
		emf1=Persistence.createEntityManagerFactory("my-jpa-conf");
		em1=emf1.createEntityManager();
		
		EntityTransaction trans=em1.getTransaction();
		trans.begin();
		em1.persist(M.getFarm());
		em1.persist(M);
		trans.commit();
		
		
	}
finally {
	if(emf1!=null) emf1.close();
	if(em1!=null) emf1.close();
}
}




  public static void updateMachine(machine M ) {
	EntityManagerFactory emf1=null;
	EntityManager em1=null;
	try {
		emf1=Persistence.createEntityManagerFactory("my-jpa-conf");
		em1=emf1.createEntityManager();
		EntityTransaction trans =em1.getTransaction();
		trans.begin();
		machine machine=em1.find(machine.class, M.getId());
		
		machine.setName(M.getName());
		machine.setPrice(M.getPrice());
		machine.setDateAchat(M.getDateAchat());
		machine.setFarm(M.getFarm());
		em1.persist(machine);
		trans.commit();
		
	
   }finally {
	   if(emf1!=null)emf1.close();
	   if(em1!=null)em1.close();
   }
  }
	 public static void deleteMachine(int id  ) {
			EntityManagerFactory emf1=null;
			EntityManager em1=null;
			try {
				emf1=Persistence.createEntityManagerFactory("my-jpa-conf");
				em1=emf1.createEntityManager();
				EntityTransaction trans =em1.getTransaction();
				trans.begin();
				machine machine=em1.find(machine.class, id);
                 em1.remove(machine);
                 em1.remove(machine.getFarm());
				trans.commit();
				
				
			   }finally {
				   if(emf1!=null)emf1.close();
				   if(em1!=null)em1.close();
			   }
}
  }