package CrudWithBddWithRmgyantraUsingPojoClass;
//Dynamic respones body
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetProject {
	
	@Test
	
	public void getProject()
	{
		String expProjectId="TY_PROJ_12325";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Actions
		 Response resp = when()
		.get("/projects");
		
		//Validation
//		.then()
//		.assertThat()
//		.statusCode(200)
//		.contentType(ContentType.JSON)
//		.log().all();
		 
		 List<String > acproIds = resp.jsonPath().get("projectId");
		 boolean flag = false;
		 for(String pid:acproIds)
		 {
			 if(pid.equalsIgnoreCase(expProjectId))
			 {
				 flag=true;
			 }
		 }
		 Assert.assertTrue(flag);
		 System.out.println("data verified");
		 
		/* String acdata = resp.jsonPath().get("[4].projectId");
		 Assert.assertEquals(expProjectId, acdata);
		 System.out.println("id verified");
		 resp.then().statusCode(200).contentType(ContentType.JSON).log().all();*/
		 
		 
	}

}
