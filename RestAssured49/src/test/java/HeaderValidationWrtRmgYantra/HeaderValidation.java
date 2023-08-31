package HeaderValidationWrtRmgYantra;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderValidation {
	
	@Test
	
	public void headerValidation()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		String expected_statusLine="HTTP/1.1 200 ";
		String expected_Vary="Access-Control-Request-Headers";
		String expected_contentType="application/json";
		String expected_prgma="no-cache";
		String expected_Connection="keep-alive";
		
		Response resp = when().get("/projects/TY_PROJ_25164");
		
		String statusLine = resp.statusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, expected_statusLine);
		
		 Headers header = resp.getHeaders();
		 System.out.println(header);
		 System.out.println(resp.getHeader("Cache-Control"));
		 String actual_content_type=resp.getHeader("Content-Type");
		 System.out.println(actual_content_type);
		 Assert.assertEquals(actual_content_type,expected_contentType);
		 
		 String actual_prgma=resp.getHeader("Pragma");
		 Assert.assertEquals(actual_prgma, expected_prgma);
		 
		 String actual_conn=resp.getHeader("Connection");
		 Assert.assertEquals(actual_conn, expected_Connection);
	}

}
