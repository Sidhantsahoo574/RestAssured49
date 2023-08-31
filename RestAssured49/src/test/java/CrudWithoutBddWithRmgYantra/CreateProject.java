package CrudWithoutBddWithRmgYantra;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	
	@Test
	public void createProject()
	{
		JavaLibraries jlib=new JavaLibraries();
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "Sidhanta Sahoo");
		obj.put("projectName", "OnBuylite"+jlib.getRandom());
		obj.put("status", "On going");
		obj.put("teamSize", "12");
		
		RequestSpecification cre = RestAssured.given();
		cre.body(obj);
		cre.contentType(ContentType.JSON);
		
		Response resp = cre.post("http://rmgtestingserver:8084/addProject");
		
		int actStatus=resp.getStatusCode();
		Assert.assertEquals(201, actStatus);
		System.out.println("tc pass");
		
		System.out.println(resp.prettyPeek());
	}

}
