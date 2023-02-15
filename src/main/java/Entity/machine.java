package Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity @Table(name="machine")
public class machine {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id ;
   private String name;
  private float price;
  @Column (name="date_achat")
  private Date dateAchat;
  @ManyToOne
  @JoinTable(name="Farm_Machine",
           joinColumns=@JoinColumn(name="machine_id"),
           inverseJoinColumns=@JoinColumn(name="farm_id "))
  
  private Farm farm;
  
  
@Override
public String toString() {
	return "machine [id=" + id + ", name=" + name + ", price=" + price + ", dateAchat=" + dateAchat + "]";
}
public machine(int id, String name, float price, Date dateAchat) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.dateAchat = dateAchat;
}
public machine(String name, float price, Date dateAchat) {
	super();
	this.name = name;
	this.price = price;
	this.dateAchat = dateAchat;
}
public machine() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Date getDateAchat() {
	return dateAchat;
}
public void setDateAchat(Date dateAchat) {
	this.dateAchat = dateAchat;
}
public Farm getFarm() {
	return farm;
}
public void setFarm(Farm farm) {
	this.farm = farm;
}
   

 
}
