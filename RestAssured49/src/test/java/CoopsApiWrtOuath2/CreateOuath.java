package CoopsApiWrtOuath2;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateOuath {
	
	@Test
	
	public void athentication()
	{
		 Response resp = given().formParam("client_id", "TakeOn")
		.formParam("client_secret", "fd55baa7770987a0591038e23e5dc3e8")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://takeon.com")
		.formParam("code", "authorization_code")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		//capture the token
		String token=resp.jsonPath().get("access_token");
		System.out.println(token);
		
		resp.then().log().all();
		System.out.println("--------------------------------------------------------------");
		
		 given().auth().oauth2(token).pathParam("pid", 4656)
		.when().post("http://coop.apps.symfonycasts.com/api/{pid}/eggs-count")
		.then().log().all();
		
		System.out.println("--------------------------------------------------------------");
		
		 given().auth().oauth2(token).pathParam("pid", 4656)
		.when().post("http://coop.apps.symfonycasts.com/api/{pid}/eggs-collect")
		.then().log().all();
		
		System.out.println("--------------------------------------------------------------");
		
         given().auth().oauth2(token).pathParam("pid", 4656)
		.when().post("http://coop.apps.symfonycasts.com/api/{pid}/chickens-feed")
		.then().log().all();
         
         System.out.println("--------------------------------------------------------------");
         
         given().auth().oauth2(token).pathParam("pid", 4656)
 		.when().post("http://coop.apps.symfonycasts.com/api/{pid}/toiletseat-down")
 		.then().log().all();
         
         System.out.println("--------------------------------------------------------------");
         
         given().auth().oauth2(token).pathParam("pid", 4656)
  		.when().post("http://coop.apps.symfonycasts.com/api/{pid}/barn-unlock")
  		.then().log().all();
         
         System.out.println("--------------------------------------------------------------");
         
          given().auth().oauth2(token)
         .when().get("http://coop.apps.symfonycasts.com/api/me")
         .then().log().all();
         
           
        
		
	}

}
