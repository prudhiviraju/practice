package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Select {

	
	
	static WebDriver driver;
	static String chrome_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	static String Base_url="https://www.facebook.com/";
	static int implicity_wai=60;
	
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver",chrome_path);
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(implicity_wai, TimeUnit.SECONDS);
	
	driver.get(Base_url);
	
	WebElement element=driver.findElement(By.xpath("//select[@id='day']"));
	org.openqa.selenium.support.ui.Select sel = new org.openqa.selenium.support.ui.Select(element);
	sel.selectByIndex(20);
	
	
	
	
	
	
	
	
		
		
	}
	
	
	
}
