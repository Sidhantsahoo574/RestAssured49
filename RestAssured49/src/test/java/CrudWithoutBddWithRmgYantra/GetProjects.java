package CrudWithoutBddWithRmgYantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProjects {
	
	@Test
	
	public void getProjects()
	{
		Response res = RestAssured.get("http://rmgtestingserver:8084/projects");
		Assert.assertEquals(200, res.getStatusCode());
		System.out.println("tc pass");
		System.out.println(res.getTime());
		
	}

}
