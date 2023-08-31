package CrudWithBddWithReqres;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Get {
	
	@Test
	
	public void get()
	{
		baseURI="https://reqres.in";
		//Actions
		when().get("/api/users/2")
		//Validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
