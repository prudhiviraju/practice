package practice;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	WebDriver driver;
	public void Screenshot(WebDriver driver,String methodname) throws Throwable {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Admin\\Desktop\\Selenium\\Workspace\\Practice\\screenshot\\"+methodname+".png");
		FileUtils.copyFile(src, dest);
		
	}
	
	
}
