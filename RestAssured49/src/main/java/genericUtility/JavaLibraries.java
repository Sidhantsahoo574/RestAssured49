package genericUtility;

import java.util.Random;

public class JavaLibraries {
	
	public int getRandom()
	{
		Random ran=new Random();
		int randomNo=ran.nextInt();
		return randomNo;
	}

}
