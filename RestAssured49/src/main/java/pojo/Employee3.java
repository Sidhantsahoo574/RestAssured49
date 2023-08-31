package pojo;

public class Employee3 {
	
	String name;
	int age;
	long[]phNo;
	Spouse spouse;
	
	public Employee3(String name, int age, long[] phNo, Spouse spouse) {
		super();
		this.name = name;
		this.age = age;
		this.phNo = phNo;
		this.spouse = spouse;
	}
	
	public Employee3()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long[] getPhNo() {
		return phNo;
	}

	public void setPhNo(long[] phNo) {
		this.phNo = phNo;
	}

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
	
	
	
	

}
