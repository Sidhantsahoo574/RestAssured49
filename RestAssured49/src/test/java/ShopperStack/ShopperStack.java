package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.CreatePojoWrtShopperStack;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class ShopperStack {
	
	

	@Test
	public void registerAsAStopper()
	{
		baseURI="https://www.shoppersstack.com/shopping";
		JavaLibraries jlb = new JavaLibraries();
		CreatePojoWrtShopperStack cp=new CreatePojoWrtShopperStack("Bhubaneswar", "India", "johnaron"+jlb.getRandom()+"@gmail.com", "John", "MALE", "Aron", "John@123",7869756390l , "Odisha", "ALPHA");
		Response resp = given().body(cp).contentType(ContentType.JSON)
		.when().post("/shoppers");
		String role = resp.jsonPath().get("data.role");
		String mail=resp.jsonPath().getString("data.email");
		System.out.println(mail);
		resp.then().contentType(ContentType.JSON).log().all();
		
		
		JSONObject obj=new JSONObject();
		obj.put("email", mail);
		obj.put("password","John@123");
		obj.put("role", role);
		Response res = given().body(obj).contentType(ContentType.JSON)
		.when().post("/users/login");
		String token = res.jsonPath().get("data.jwtToken");
		System.out.println(token);
		String id=res.jsonPath().getString("data.userId");
		res.then().log().all();
		
		
		
	     given().pathParam("Sid", id)
		.when().auth().oauth2(token).get("/shoppers/{Sid}")
		.then().log().all();
		
	     
	     CreatePojoWrtShopperStack cp2=new CreatePojoWrtShopperStack("Bhubaneswar", "India", "johnaron"+jlb.getRandom()+"@gmail.com", "John", "MALE", "Aron", "John@123",7869787390l , "Odisha", "ALPHA");
        given().auth().oauth2(token).pathParam("Sid", id).body(cp2).contentType(ContentType.JSON)
        .when().patch("/shoppers/{Sid}")
        .then().log().all();
        
        JSONObject jobj=new JSONObject();
        jobj.put("email", mail);
        jobj.put("role", role);
        given().body(jobj).contentType(ContentType.JSON)
        .when().post("/users/forgot-password")
        .then().log().all();
     	
	}
	
	
		
		
     	
     	
	
	
		

}
