package CrudWithBddUsingDDT;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.CreatePojoWithReqres;

public class DDtUsingReqres {

	
	@DataProvider(name="getData")
	public Object[][] data()
	{
		Object [][] ob=new Object[3][2];
		
		ob[0][0]="Sidhant";
		ob[0][1]="QaEng";
		
		ob[1][0]="Rahul";
		ob[0][1]="NetworkEng";
		
		ob[2][0]="Pabitra";
		ob[2][1]="C#Devloper";
		
		return ob;
	}
	
	@Test(dataProvider = "getData")
	public void crudUsingReqres(String name,String job)
	{
		baseURI="https://reqres.in";
		CreatePojoWithReqres cp=new CreatePojoWithReqres(name, job);
		given().body(cp).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().log().all();
		
	}
}
