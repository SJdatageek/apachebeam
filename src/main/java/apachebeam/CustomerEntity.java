package apachebeam;

import java.io.Serializable;

public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = -9164775800499948256L;

	private String id;
	
	private String name;

	public CustomerEntity() {
		
	}
	
	public CustomerEntity(String pId,String pName) {
		this.id=pId;
		this.name=pName;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

