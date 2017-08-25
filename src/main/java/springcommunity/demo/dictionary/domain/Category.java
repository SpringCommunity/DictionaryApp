package springcommunity.demo.dictionary.domain;

import java.io.Serializable;

public class Category implements Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = 6647871911280941182L;
	private int id;
     private char category;
     
     
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int id, char category) {
		super();
		this.id = id;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
     
     
}
