package CrudWithoutBddWithRmgYantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	
	@Test
	
	public void deleteProject()
	{
		Response res = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_24347");
		Assert.assertEquals(204, res.getStatusCode());
		System.out.println("tc pass");
		
	}

}
