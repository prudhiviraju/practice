package gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatafromProvider {


	
	WebDriver driver;
	
	@Test(dataProvider = "testdata")
	public void gmaillogin(String username,String password) {	
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Next']")).click();	
		
		driver.quit();
		
	}
	
	
	@DataProvider(name = "testdata")
	public Object[][] data(){
		
		Object[][] ob=new Object[2][2];
		
		
		ob[0][0]="razz";
		ob[0][1]="chandhu";
		
		ob[1][0]="prudhiviraju73@gmail.com";
		ob[1][1]="FUCKYOU25";
				
		
		
		return ob;
		
		
		
		
	}
	
}



