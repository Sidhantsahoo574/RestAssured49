package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.Employee3;
import pojo.Spouse;

public class SerializationAndDeserializationWrtObjectInsideObject {
	
	@Test
	public void employeeObjectInsObjectSerialization() throws JsonGenerationException, JsonMappingException, IOException
	{
		long[]phNo= {7978445126l,8763500171l};
		
		long[]phno= {145654345,42321222};
		Spouse s=new Spouse("she",24, phno);
		Employee3 e=new Employee3("Sidhant", 25, phNo, s);
		
		ObjectMapper omp=new ObjectMapper();
		omp.writerWithDefaultPrettyPrinter().writeValue(new File("./emp3.objectInObj.json"), e);
	}
	
	@Test
	public void employeeObjectInsObjectDeSerialization() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper omp=new ObjectMapper();
		Employee3 data = omp.readValue(new File("./emp3.objectInObj.json"), Employee3.class);
		System.out.println(data.getName());
		System.out.println(data.getAge());
		System.out.println(data.getPhNo()[0]);
		System.out.println(data.getSpouse().getPhno()[1]);
	}

}
