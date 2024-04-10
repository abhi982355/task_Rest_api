package user.entity.classes;

public class MappingModelClass {

	// this model data is for only map data coming from user side (front end)
	// for more understanding we can map data user and user details
	
	private String userName;
	
	private Integer userAge;
	
	private String userAddress;
	
	public MappingModelClass() {
		
	}

	public String getUserName() {
		return userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}
}
