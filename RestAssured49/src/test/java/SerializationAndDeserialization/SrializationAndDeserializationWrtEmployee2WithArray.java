package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.Employee2WithArray;

public class SrializationAndDeserializationWrtEmployee2WithArray {
	
	@Test
	public void employee2Serialization() throws JsonGenerationException, JsonMappingException, IOException
	{
		 long[]phNo= {7978445126l,8763500171l};
		 
		 Employee2WithArray e=new Employee2WithArray("Sidhant", 25, phNo);
		 
		 ObjectMapper om=new ObjectMapper();
		 om.writerWithDefaultPrettyPrinter().writeValue(new File("./emp2_array.json"), e);
	}
	
	@Test
	public void employee2Desialization() throws JsonParseException, JsonMappingException, IOException
	{

		
		ObjectMapper omp=new ObjectMapper();
		Employee2WithArray data = omp.readValue(new File("./emp2_array.json"), Employee2WithArray.class);
		System.out.println(data.getName());
		System.out.println(data.getAge());
	    System.out.println(data.getPhNo()[1]);
	}

}
