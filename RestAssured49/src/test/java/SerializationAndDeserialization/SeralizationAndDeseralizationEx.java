package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.Employee;

public class SeralizationAndDeseralizationEx {
	
	@Test
	
	public void employeeSerialization() throws JsonGenerationException, JsonMappingException, IOException
	{
		Employee e=new Employee("Sidhanta Sahoo", 25, "Sid@gmail.com", 7978445126l);
		
       ObjectMapper omp = new ObjectMapper();
       
       omp.writerWithDefaultPrettyPrinter().writeValue(new File("./emp.json"),e);
	}
	
	@Test
	public void employeeDeserialalization() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omp=new ObjectMapper();
		
		Employee data = omp.readValue(new File("./emp.json"), Employee.class);
		
		System.out.println(data.getName());
		System.out.println(data.getAge());
		System.out.println(data.getPhNo());
		System.out.println(data.getGmail());
	}

}
