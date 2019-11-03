package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {

	static WebDriver driver;
	static String base_url="https://mail.google.com/";
	static String user_name="prudhiviraju73@gmail.com";
	static String pass_word="FUCKYOU25	";
	static String chrome_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	static int implicity_wait=60;
			
	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver", chrome_path);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implicity_wait, TimeUnit.SECONDS);
		
		driver.get(base_url);
		driver.findElement(By.id("identifierId")).sendKeys(user_name);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys(pass_word);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		
		
		
		driver.findElement(By.xpath("//span[@class='ait']")).click();
		
		List<WebElement > element =driver.findElements(By.className("nM"));
		System.out.println(element.size());
		for(int i=0;i<element.size();i++) {
			System.out.println(element.get(i).getText());
		}
		
		
		WebElement element2 =driver.findElement(By.xpath("//a[contains(text(),'Create new label')]"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeAsyncScript("arguments[0].scrollIntoView();",element2);
	
	
	
		
		driver.quit();
		
	}
	
}
