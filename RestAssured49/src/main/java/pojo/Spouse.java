package pojo;

public class Spouse {
	
	String name;
	int age;
	long[]phno;
	
	public Spouse(String name, int age, long[] phno) {
		super();
		this.name = name;
		this.age = age;
		this.phno = phno;
	}
	
	public Spouse()
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
	public long[] getPhno() {
		return phno;
	}
	public void setPhno(long[] phno) {
		this.phno = phno;
	}
	
	
	

}
