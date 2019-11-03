package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng {
	
	

	
	WebDriver driver=null;

	@Test(priority = 0)
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
	}
	
	@Test(priority = 1)
	public void url() {
		driver.get("https://mail.google.com/");
		
		System.out.println(driver.getTitle());
	}
	
	

	@Test(priority = 2)
	public void credentials() throws Exception {
		driver.findElement(By.id("identifierId")).sendKeys("prudhiviraju73@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("FUCKYOU25");
		driver.findElement(By.xpath("//span[text()='Next']")).click();	
		
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 3)
	public void gettitle() {
		
		
		String expected="Inbox - prudhiviraju73@gmail.com - Gmail";

		String actual =driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println("the title is as we expected");
	}
	
	
	
	
	@Test(priority = 4)
	public void searchmail() throws Exception {
		
		WebElement element =driver.findElement(By.xpath("//input[@name='q']"));
		element.sendKeys("icici bank");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	
		Thread.sleep(5000);
	}
	
	
	
	
	@Test(priority = 5)
	public void collectalthedata() throws Exception {
		
		List<WebElement> data=driver.findElements(By.xpath("//div[@id=':1']//div[@class='nH']"));
		Thread.sleep(5000);
		
		System.out.println("**********************************************"
				+ "the total no of the ICICI messages are "+ data.size());
		for(int i=0;i<data.size();i++) {
			
			System.out.println(data.get(i).getText());
		}
	
		System.out.println("***************************************************");
	}
	
	
	@Test(priority = 6)
	public void unreadmessages() {
		
		
		List<WebElement> unread=driver.findElements(By.xpath("//tr[@class='zA zE']"));
		System.out.println("the total no.of Unread messages are "+ unread.size());
		
		
		for(int i=0;i<unread.size();i++) {
			
			System.out.println(unread.get(i).getText());
		}
		
	}
	
	
	@Test(priority = 7)
	public void logout() {
		
		driver.findElement(By.xpath("//a[@class='gb_B gb_Da gb_g' and @aria-expanded='false']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		
		
	}
	
	
	
	@Test(priority = 8)
	public void teardown() {
		
		
		
		driver.quit();
	}
	
	
	
	
	
}
