package CrudWithBddWithReqresUsingJsonFile;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Create {
	
	@Test
	
	public void create()
	{
		//JavaLibraries jlib=new JavaLibraries();
		baseURI="https://reqres.in";
		File f=new File("./src/test/resources/Reqreswithrestassured.json");
		//Pre-condition
		given()
		.body(f)
		.contentType(ContentType.JSON)
		//Actions
		.when()
		.post("/api/users")
		//Validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
