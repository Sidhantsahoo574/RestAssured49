package pojo;

public class Employee {

	String name;
	int Age;
	String gmail;
	long phNo;


	public Employee(String name, int age, String gmail, long phNo) {
		super();
		this.name = name;
		Age = age;
		this.gmail = gmail;
		this.phNo = phNo;
	}
	
	//providing empty constructor  to trigger deserialization
	
	public Employee()
	{
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	public long getPhNo() {
		return phNo;
	}


	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

}
