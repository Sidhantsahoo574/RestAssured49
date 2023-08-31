package CrudWithBddWithReqresUsingPojoClass;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pojo.CreatePojoWithReqres;

public class CrudRequestWithReqres {
	
	@Test(priority = 1)
	
	public void createRequest()
	{
		baseURI="https://reqres.in";
		
		CreatePojoWithReqres cp=new CreatePojoWithReqres("morpheus", "leader");
		
		//Pre-condition
		 given().body(cp).contentType(ContentType.JSON)
		//Actions
	      .when().post("/api/users")
		//Validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	
	}
	
	@Test(priority = 2)
	public void getRequest()
	{
		//prerequisites
		baseURI="https://reqres.in";
	    
		
		
		//Actions
		 when().get("/api/users/2")
		//Validation
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	
	@Test()
	public void getAllUsers()
	{
		//for Static response body
		//prerequisites
	     baseURI="https://reqres.in";
	     int eid=6;
	     
	     Response resp = when().get("/api/users?page=1");
	     
	     int acid = resp.jsonPath().get("data.id[5]");
	     Assert.assertEquals(acid, eid);
	     System.out.println("pass");
	     resp.then().assertThat().time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS).statusCode(200).contentType(ContentType.JSON).log().all();
	     
	     //Dynamic Responnse body
	      List<Integer> id=resp.jsonPath().get("data.id");
	      boolean flag = false;
	      for(Integer i:id)
	      {
	    	  if(eid==i)
	    	  {
	    		  flag=true;
	    	  }
	      }
	      Assert.assertTrue(flag);
	      System.out.println("passed");
	     
	}
	
	@Test(priority = 3)
	public void updateRequest()
	{
       baseURI="https://reqres.in";
		
		CreatePojoWithReqres cp=new CreatePojoWithReqres("morpheus", "zion resident");
		
		//Pre-condition
		given().body(cp).contentType(ContentType.JSON)
		//Actions
		.when().put("/api/users/2")
		//Validation
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	
	@Test(priority = 4)
	public void deleteRequest()
	{
       baseURI="https://reqres.in";
		
		//Actions
		when().delete("/api/users/2")
		//Validation
		.then().assertThat().statusCode(204).log().all();
	}

}

