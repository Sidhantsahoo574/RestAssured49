 package CrudWithBddWithReqres;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Create {
	
	@Test
	
	public void create()
	{
		baseURI="https://reqres.in";
		HashMap map=new HashMap();
		map.put("name", "morpheus");
		map.put("job", "leader");
		//Pre-conditions
		given()
		.body(map)
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
