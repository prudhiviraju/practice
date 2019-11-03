package practice;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice3 {

	
	
	Propertyfile prog;
	
	
	@Test
	public void setup() throws Throwable {
	
		
		System.setProperty("webdriver.chrome.driver",prog.chromepath());
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.get(prog.baseurl());
		
		
		ScreenShot src = new ScreenShot();
		src.Screenshot(driver, "razz");
		
		
	}
	
	
	
}
