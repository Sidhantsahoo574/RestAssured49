package CrudWithBddWithRmgyantra;

import java.util.HashMap;

import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	
	@Test
	
	public void updateProject()
	{
		JavaLibraries jlib=new JavaLibraries();
		baseURI="http://rmgtestingserver";
		port=8084;
		HashMap map=new HashMap();
		map.put("createdBy", "Soumya");
		map.put("projectName", "Takeeasy"+jlib.getRandom());
		map.put("status", "On going");
		map.put("teamSize", "22");
		
		//Pre-condition
		given()
		.body(map)
		.contentType(ContentType.JSON)
		//Actions
		.when()
		.put("/projects/TY_PROJ_24422")
		//Validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
