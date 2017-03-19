package springcommunity.demo.dictionary.domain;

import java.io.Serializable;

public class Type implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9155215332973987476L;
	private int id;
    private String type;
    
    
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
