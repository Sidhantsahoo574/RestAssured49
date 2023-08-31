package CrudWithBddUsingRequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojo.CreatePojoWithReqres;

public class CrudWRTReqres {

	@Test

	public void createReq()
	{
		

		Response resp = when().get("https://reqres.in/api/users?page=2");
		 int id=resp.jsonPath().get("data[0].id");
		 System.out.println(id);
		resp.then().log().all();
		
		System.out.println("---------------------------------------------------------");
		
		//get single user
		Response resp1 = given().pathParam("Id", id)
		.when().get("https://reqres.in/api/users/{Id}");
		int id1=resp1.jsonPath().get("data[0].id");
		resp1.then().log().all();
		
		given().pathParam("Id1", id1)
		.when().delete("https://reqres.in/api/users/{Id1}")
		.then().log().all();
		

	}

}
