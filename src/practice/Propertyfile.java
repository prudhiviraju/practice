package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Propertyfile {

	
	Properties pro;

	@Test
	public void property() throws Throwable {
		
		File file = new File("C:\\Users\\Admin\\Desktop\\Selenium\\Workspace\\Practice\\property\\propertyfile");
		FileInputStream fis = new FileInputStream(file);
	    pro =new Properties();
		pro.load(fis);
	
	}
	
	
	public String chromepath() {
		return pro.getProperty("ChromePath");
		
	}
	
	
	public String baseurl() {
		return pro.getProperty("BaseUrl");
	}
	
	
	
}
