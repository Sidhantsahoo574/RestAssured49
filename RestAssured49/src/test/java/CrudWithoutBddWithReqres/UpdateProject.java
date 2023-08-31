package CrudWithoutBddWithReqres;

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
		JSONObject obj=new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "zion resident");
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(obj);
		
		Response resp = req.put("https://reqres.in/api/users/2");
		int actStatus=resp.getStatusCode();
		Assert.assertEquals(200, actStatus);
		System.out.println("tc pass");
		
		System.out.println(resp.prettyPeek());//give the response header as well as body
		System.out.println(resp.prettyPrint());//give the body 2times not header
		System.out.println(resp.asString());//give the body in single line
		
	}

}
