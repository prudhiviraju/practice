package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel {
	

	WebDriver driver;
	
	
	@Test
	@Parameters({"browsername","username","password","url"})
	public void parallellogin(String browsername,String username,String password,String url) {
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Admin\\\\Desktop\\\\Selenium\\\\Latest\\\\chromedriver_win32\\\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\Selenium\\Latest Drivers\\geckodriver-v0.25.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		
		
		else if(browsername.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver","C:\\Users\\Admin\\Desktop\\Selenium\\Latest Drivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	
		}
		
		
		
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Next']")).click();	
		
		driver.quit();
		
	}
	
	
	
	
	
}
