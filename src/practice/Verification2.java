package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verification2 {

	
	
	static WebDriver driver ;
	static String Base_url="https://www.google.com/";
	static String Chrome_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	static int Implicity_wait=60;
	static String gmail="gmail";
	static String expected="gmail - Google Search";
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver",Chrome_path);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Implicity_wait, TimeUnit.SECONDS);
	
	driver.get(Base_url);
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys(gmail);
	driver.findElement(By.xpath("//input[@name='btnK' and @value='Google Search']")).click();
	String actual=driver.getTitle();
	System.out.println(actual);
	
		
		if(expected.equals(actual)) {
			System.out.println("the test case is passed");
		}else {
			System.out.println("the test case is failed");
		}
		
		
		
		
		driver.quit();
		
		
		
	}
	
	
}
