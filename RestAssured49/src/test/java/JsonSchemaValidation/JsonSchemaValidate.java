package JsonSchemaValidation;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class JsonSchemaValidate {
	
	@Test
	
	public void jsonSchemaValidation()
	{
		baseURI="https://reqres.in/";
		File f=new File("./src/test/resources/jsonSchema.json");
		
		when().get("api/users?page=2")
		.then()
		.assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(f))
		.log().all();
	}

}
