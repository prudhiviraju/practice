package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Verification {
	
	
	
	/**
	 * Admin Prudhvi R@zz
	 * @param args
	 */
	
	
	static WebDriver driver ;
	static String Gecko_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	static int Implicity_wait=60;
	static String Base_Url="https://www.google.com/";
	static String Data="face";
	static String expected="facebook - Google Search";
	
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver",Gecko_path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Implicity_wait,TimeUnit.SECONDS);
		
		
		
		driver.get(Base_Url);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Data);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'face')][1]")).click();
		
		String acctual =driver.getTitle();
		System.out.println(acctual);
		
		if(expected.equalsIgnoreCase(acctual)) {
			System.out.println("the test case is passed");
		}else {
			System.out.println("the test case is failed");
		}
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
