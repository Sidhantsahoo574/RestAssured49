package pojo;

public class CreatePojoWithReqres {
	
	//Declare the varialbe globally
	String name;
	String job;
	
	//Initialize the Constructor
	public CreatePojoWithReqres(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	//Provide getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
