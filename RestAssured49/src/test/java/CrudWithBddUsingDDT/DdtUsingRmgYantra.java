package CrudWithBddUsingDDT;

import static io.restassured.RestAssured.*;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;
import pojo.CreatePojoWithRmgYantra;

public class DdtUsingRmgYantra {
	
	@DataProvider(name="getData")
	public Object[][] data()
	{
		
		Object[][] data=new Object[3][4];
		
		data[0][0]="Sidhu";
		data[0][1]="dell";
		data[0][2]="Completed";
		data[0][3]=12;
		
		data[1][0]="Sid";
		data[1][1]="sony";
		data[1][2]="Completed";
		data[1][3]=10;
		
		data[2][0]="Sidhanta";
		data[2][1]="Syrius";
		data[2][2]="Completed";
		data[2][3]=12;
		
		return data;
	}
	
	@Test(dataProvider="getData")
	public void crudOperationUsingDdt(String createdBy,String projectName,String status,int teamSize)
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaLibraries j=new JavaLibraries();
		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra(createdBy, projectName+j.getRandom(), status, teamSize);
		
		given().body(cp).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().log().all();
	}

}
