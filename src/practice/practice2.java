package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practice2 {
	
	
	static WebDriver driver;
	static String chrome_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	static int implicity_wait=60;
	static String base_url="https://in.yahoo.com/?p=us";
	static String element="//a[@title='Sanjay Raut']";
	
	
	public static void main(String[] args) throws Throwable {
		
	System.setProperty("webdriver.chrome.driver",chrome_path);
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(implicity_wait, TimeUnit.SECONDS);
	
	
	driver.get(base_url);
	
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));

	
		
		
		driver.findElement(By.xpath(element)).click();
		String title =driver.getTitle();
		Thread.sleep(5000);
		System.out.println(title);
		
		
		driver.quit();
		
		
	}

}
