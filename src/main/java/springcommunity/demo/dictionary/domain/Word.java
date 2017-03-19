package springcommunity.demo.dictionary.domain;

import java.io.Serializable;

public class Word implements Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = -5782052060001826464L;
	private int id;
     private String name;
     private String mean;
     private int typeId;
     private int categoryId;
     
     
	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Word(int id, String name, String mean, int typeId, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.mean = mean;
		this.typeId = typeId;
		this.categoryId = categoryId;
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
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
     
     
}
