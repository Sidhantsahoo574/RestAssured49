package CrudWithoutBddWithReqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	
	@Test
	public void deleteProject()
	{
		Response resp = RestAssured.delete("https://reqres.in/api/users/2");
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(204, actStatus);
		System.out.println("tc pass");
	}

}
