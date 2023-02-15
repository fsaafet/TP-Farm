package Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="Farm")

public class Farm {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String  destinataire;
	private String localisation;
	private float surface;
	
	@OneToMany
	@JoinTable(name="Farm_Machine",
	      joinColumns=@JoinColumn(name="farm_id"),
	      inverseJoinColumns=@JoinColumn(name="machine_id"))
	
	
	
	List<machine> machines;
	public List<machine> getMachine(){
		return machines;
		
	}
	
	public List<machine> getMachines() {
		return machines;
	}

	public void setMachines(List<machine> machines) {
		this.machines = machines;
	}


	public Farm(int id, String destinataire, String localisation, float surface) {
		super();
		this.id = id;
		this.destinataire = destinataire;
		this.localisation = localisation;
		this.surface = surface;
	}


	@Override
	public String toString() {
		return "FarmService [id=" + id + ", destinataire=" + destinataire + ", localisation=" + localisation
				+ ", surface=" + surface + "]";
	}


	public Farm(String destinataire, String localisation, float surface) {
		super();
		this.destinataire = destinataire;
		this.localisation = localisation;
		this.surface = surface;
	}


	public Farm() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}


	


}
	