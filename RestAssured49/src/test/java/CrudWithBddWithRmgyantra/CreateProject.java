package CrudWithBddWithRmgyantra;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;

import static io .restassured.RestAssured.*;

public class CreateProject {
	
	@Test
	
	public void createProject()
	{
		JavaLibraries jlib=new JavaLibraries();
		baseURI="http://rmgtestingserver";
		port=8084;
		HashMap obj=new HashMap();
		obj.put("createdBy", "Jagan");
		obj.put("projectName", "OnTime"+jlib.getRandom());
		obj.put("status", "On going");
		obj.put("teamSize", "14");
		
		
		//Pre-condition
		   given()
		   .body(obj)
		   .contentType(ContentType.JSON)
		   
		   //Actions
		   .when()
		   .post("/addProject")
		   
		   //Validation
		   .then()
		   .assertThat()
		   .statusCode(201)
		   .contentType(ContentType.JSON)
		   .log().all();
		   
		 
		
	}

}
