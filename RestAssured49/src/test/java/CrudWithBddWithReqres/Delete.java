package CrudWithBddWithReqres;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Delete {
	
	@Test
	
	public void delete()
	{
		baseURI="https://reqres.in";
		//Actions
		when().delete("/api/users/2")
		//Validation
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}
