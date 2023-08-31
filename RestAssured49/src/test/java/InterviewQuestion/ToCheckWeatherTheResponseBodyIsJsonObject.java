package InterviewQuestion;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ToCheckWeatherTheResponseBodyIsJsonObject {

	@Test
	public void CheckjsonObject() throws JsonMappingException, JsonProcessingException
	{
		Response resp = given().pathParam("pid", "TY_PROJ_6213")
				.when().get("http://rmgtestingserver:8084/projects/{pid}");
		//capture the response
		String respAsString = resp.getBody().asString();
		
		ObjectMapper mapper=new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(respAsString);
		//boolean ab = jsonNode.isArray();
		//boolean bc = jsonNode.isBoolean();
		//boolean in = jsonNode.isInt();
		//boolean ob = jsonNode.isObject();
		//boolean nul = jsonNode.isNull();
		if(jsonNode.isObject())
		{
			//The response is  a jsonObject
			System.out.println("Response is a JSON object");
			//you can further process the json object as needed
		}
		else if(jsonNode.isArray())
		{
			System.out.println("Response is an array of jsonObject");
		}
		else {
			System.out.println("Response is a String "+respAsString);
		}
	}
}
