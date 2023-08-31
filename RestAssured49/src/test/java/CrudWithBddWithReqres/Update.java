package CrudWithBddWithReqres;

import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Update {
	
	@Test
	
	public void update()
	{
		baseURI="https://reqres.in";
		HashMap map=new HashMap();
		map.put("name", "morpheus");
		map.put("job", "zion resident");
		
		//Pre-condition
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		//Actions
		.when()
		.put("/api/users/2")
		
		//Validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
