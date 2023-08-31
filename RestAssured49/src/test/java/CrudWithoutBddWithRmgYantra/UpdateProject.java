package CrudWithoutBddWithRmgYantra;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Rahul Singh");
		jobj.put("projectName", "Takeeasy");
		jobj.put("status", "Completed");
		jobj.put("teamSize", "8");
		
		
		RequestSpecification resp = RestAssured.given();
		resp.contentType(ContentType.JSON);
		resp.body(jobj);
		
		Response p = resp.put("http://rmgtestingserver:8084/projects/TY_PROJ_24347");
		
		int actStatus=p.getStatusCode();
		Assert.assertEquals(200,actStatus);
		System.out.println("tc pass");
		
		System.out.println(p.prettyPeek());
		
		
	}

}
