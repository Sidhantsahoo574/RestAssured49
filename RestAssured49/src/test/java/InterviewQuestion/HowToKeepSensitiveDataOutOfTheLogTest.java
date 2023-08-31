package InterviewQuestion;

import java.util.HashSet;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;

public class HowToKeepSensitiveDataOutOfTheLogTest {

	@Test
	public void sample()
	{
		HashSet<String> headers = new HashSet<String>();
		headers.add("X-REGION");
		headers.add("content-type");
		
		given().baseUri("http://rmgtestingserver:8084").header("X-REGION","NAM")
		.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers)))
		.log().all()
		.when().get("/projects")
		.then().assertThat().statusCode(200);
	}
}
