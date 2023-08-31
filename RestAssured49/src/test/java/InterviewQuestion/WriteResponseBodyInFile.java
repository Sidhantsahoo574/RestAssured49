package InterviewQuestion;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WriteResponseBodyInFile {

	@Test
	public void writeResponeInFile() throws IOException
	{
		Response resp = when().get("http://rmgtestingserver:8084/projects");
		//Extract response body as a json String
		String responseAsString=resp.getBody().asString();
		//Convert in to byte array before writting
		byte[] responseAsAtringByte = responseAsString.getBytes();
		//Creating a target file
		File f=new File("src/main/resources/targetFileforString.json");
		//Writting into files
		Files.write(responseAsAtringByte, f);
	}
	
	@Test
	public void writeInFile2() throws IOException
	{
		Response resp = when().get("http://rmgtestingserver:8084/projects");
		InputStream responseAsInputStream = resp.asInputStream();
		byte[]responseAsInputStreamByte=new byte[responseAsInputStream.available()];
		responseAsInputStream.read(responseAsInputStreamByte);
		File f=new File("src/main/resources/targetFileforInputStream.json");
		Files.write(responseAsInputStreamByte, f);
	}
	
	@Test
	public void writeInFile3() throws IOException//( more optimal way)
	{
		Response resp = when().get("http://rmgtestingserver:8084/projects");
		byte[] responseAsByteArray = resp.asByteArray();
		File f=new File("src/main/resources/targetFileforByteArray.json");
		Files.write(responseAsByteArray, f);
	}
}
//which way is more optimal
