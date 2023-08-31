package RequestSpecBuilderAndResponseSpecBuilder;

import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import pojo.CreatePojoWithRmgYantra;

public class CreteProjwrtrmgyantrapratice {

	@Test

	public void creteProjForSerialization()
	{
		JavaLibraries j=new JavaLibraries();
		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra("sK", "tyss"+j.getRandom(), "Completed", 4);

		RequestSpecification reqst = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setBody(cp)
				.setContentType(ContentType.JSON)
				.build();
		
		        ResponseSpecification resp = new ResponseSpecBuilder()
		        		.expectContentType(ContentType.JSON)
		        		.expectStatusCode(201)
		        		.build();

		given().spec(reqst)
		
		.when().post("/addProject")
		
		.then().spec(resp).log().all();

	}

}
