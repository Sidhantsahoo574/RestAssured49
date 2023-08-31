package CrudWithoutBddWithReqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {
	
	@Test
	public void getProject()
	{
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		int actStatus=resp.getStatusCode();
		Assert.assertEquals(200, actStatus);
		System.out.println("tc pass");
	}

}
