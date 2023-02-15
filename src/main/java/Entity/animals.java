package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	@Entity@Table(name="animals")
	public class animals {
		@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private int number;
		private String name;
		private float price;
	
		@ManyToOne@JoinColumn(name= "farm_id")
		private Farm Farm;

		public animals(int id, int number, String name, float price) {
			super();
			this.id = id;
			this.number = number;
			this.name = name;
			this.price = price;
			
		}

		public animals(int number, String name, float price) {
			super();
			this.number = number;
			this.name = name;
			this.price = price;
			
		}

		public animals() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
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

		public Farm getFarm() {
			return Farm;
		}

		public void setFarm(Farm farm) {
			Farm = farm;
		}

		@Override
		public String toString() {
			return "animals [id=" + id + ", number=" + number + ", name=" + name + ", price=" + price + "]";
		}

		
}
