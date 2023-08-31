package CrudWithoutBddWithReqres;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchProject {
	
	@Test
	
	public void patchProject()
	{
		JSONObject obj=new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "zion resident");
		
		RequestSpecification resp = RestAssured.given();
		resp.body(obj);
		resp.contentType(ContentType.JSON);
		
		Response res = resp.patch("https://reqres.in/api/users/2");
		Assert.assertEquals(200, res.getStatusCode());
		System.out.println("tc pass");
		
		System.out.println(res.prettyPeek());
	}

}
