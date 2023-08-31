package CrudWithoutBddWithRmgYantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getProject {
	
	@Test
	public void getProject()
	{
		Response resp = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_24347");
		int actStatus=resp.getStatusCode();
		
		Assert.assertEquals(200, actStatus);
		System.out.println("tc pass");
	}

}
