package CrudWithoutBddWithReqres;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject()
	{
		JSONObject obj=new JSONObject();
		obj.put("name", "Sidhanta Sahoo");
		obj.put("job", "QA eng");
		RequestSpecification req = RestAssured.given();
		
		
		req.body(obj);
		req.contentType(ContentType.JSON);
		
		Response Resp = req.post("https://reqres.in/api/users");
		int actStatus=Resp.getStatusCode();
		Assert.assertEquals(201, actStatus);
		System.out.println("tc pass");
		
//		System.out.println(Resp.prettyPrint());
		System.out.println(Resp.prettyPeek());
		
	}

}
