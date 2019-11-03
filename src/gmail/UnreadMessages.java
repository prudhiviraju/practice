package gmail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UnreadMessages {
	
	
	static String Username="prudhiviraju73@gmail.com";
	static String password ="FUCKYOU25";
	static String Baseurl ="https://www.gmail.com";
	static int Implicity_Wait =60; 
	static String Gecko_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest Drivers\\geckodriver-v0.25.0-win64\\geckodriver.exe";
	
	
	public static void main(String[] args) {	
		System.setProperty("webdriver.gecko.driver",Gecko_path);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Implicity_Wait, TimeUnit.SECONDS);
		driver.get(Baseurl);
		
		driver.findElement(By.id("Email")).sendKeys(Username);
		driver.findElement(By.id("next")).click();
		
		
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
		
		
		
		List<WebElement> element =driver.findElements(By.className("zA yO x7"));
		System.out.println(element.size());
		
		
		
		
	}

}
