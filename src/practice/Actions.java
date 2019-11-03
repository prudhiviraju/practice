package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Actions {
	
	static WebDriver driver;
	static String chrome_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	static int implicity_waut=60;
    static String Base_url="https://www.google.com/";
	
	public static void main(String[] args) throws Throwable {
	
		System.setProperty("webdriver.chrome.driver",chrome_path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implicity_waut,TimeUnit.SECONDS);
		
		driver.get(Base_url);
		
		org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);
		WebElement element =driver.findElement(By.xpath("//a[text()='Gmail']"));
		action.moveToElement(element);
		action.perform();
		action.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
