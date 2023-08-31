package CrudWithBddUsingRequestChaining;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreatePojoWithRmgYantra;

public class CrudOperationWRTRmgYantra {


	@Test

	public void createProj()
	{
		baseURI="http://rmgtestingserver";
		port=8084;

		JavaLibraries j=new JavaLibraries();
		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra("Sitaram", "OnPro"+j.getRandom(), "On Going", 14);

		Response resp = given()
				.body(cp).contentType(ContentType.JSON)

				.when().post("/addProject");

		String pid = resp.jsonPath().get("projectId");

		System.out.println(pid);
		resp.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

		System.out.println("---------------------------------------------------------------------");  

		Response resp1 = given().pathParam("Id", pid)
				.when().get("/projects/{Id}");
		String pid1=resp1.jsonPath().get("projectId");
		resp1.then().log().all();

		System.out.println("------------------------------------------------------------------------");
		
		CreatePojoWithRmgYantra c=new CreatePojoWithRmgYantra("RajaRam", "OnLite"+j.getRandom(), "On Going", 12);

		Response r = given().pathParam("PID", pid1).body(c).contentType(ContentType.JSON)

				.when().put("/projects/{PID}");
		r.then().log().all();


		Response r1 = given().pathParam("Pid", pid)
				.when().delete("/projects/{Pid}");
		r1.then().log().all();





	}
}
