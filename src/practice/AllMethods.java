package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllMethods {
	
	static String base_url="https://www.google.com/";
	static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
		driver.get(base_url);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("facebook");
		driver.findElement(By.xpath("//input[@aria-label='Google Search' and @class='gNO89b']")).click();
		driver.findElement(By.xpath("//h3[text()='Facebook - Log In or Sign Up']")).click();
		
		
		Thread.sleep(5000);
		
		
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		
		String url =driver.getCurrentUrl();
		String Expected ="https://www.facebook.com/";
		
		if(Expected.contains(url)) {
			System.out.println("The Url has been Verified");
		}else {
			System.out.println("The Url has been Wrong");
		}

		
		System.out.println(url);
		
		
		String title="Facebook – log in or sign up";
			if(title.equals(driver.getTitle())) {
				System.out.println("The Title is Verified");
			}else {
				System.out.println("The Title is Wrong");
			}
		
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.quit();
		
	}
	

}
