
package RequestSpecBuilderAndResponseSpecBuilder;

import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CreatePojoWithRmgYantra;

public class CreateProjWRTRmgYantra {

	@Test

	public void proj()
	{
		JavaLibraries j=new JavaLibraries();

		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra("Sid", "tyss"+j.getRandom(), "On going", 10);

		RequestSpecification reqst = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON)
				.build();

		ResponseSpecification resp = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(201)
				.build();

		 Response rsp = given().spec(reqst).body(cp)

		.when().post("/addProject");
		 String id = rsp.jsonPath().get("projectId");
          System.out.println(id);
		  rsp.then().spec(resp).log().all();
		  
		  System.out.println("--------------------------------------------------------------");
		
		  RequestSpecification reqst1 = new RequestSpecBuilder()
					.setBaseUri("http://rmgtestingserver:8084").build();
					
					
		ResponseSpecification resp1 = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(200)
				.build();	
		
		Response rs = given().spec(reqst1).pathParam("pid",id)
		
		.when().get("/projects/{pid}");
		String id1 = rs.jsonPath().get("projectId");
		rs.then().spec(resp1).log().all();

		System.out.println("--------------------------------------------------------------");
		
		
		CreatePojoWithRmgYantra cp1=new CreatePojoWithRmgYantra("Sidhu", "tyss"+j.getRandom(), "Completed", 10);
		
		RequestSpecification reqst2 = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON)
				.build();

		ResponseSpecification resp2 = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(200)
				.build();
		
		Response r = given().spec(reqst2).body(cp1).pathParam("Id",id1)
		
		.when().put("/projects/{Id}");
		String i = r.jsonPath().get("projectId");
		r.then().spec(resp2).log().all();
		
		System.out.println("--------------------------------------------------------------");
		
		RequestSpecification reqst3 = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084").build();
		
		ResponseSpecification resp3 = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(204)
				.build();
		
		given().spec(reqst3).pathParam("id2",i)
		.when().delete("/projects/{id2}")
		.then().spec(resp3).log().all();
		
		
		

	}

}
