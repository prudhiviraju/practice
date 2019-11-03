package gmail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Collectallthemessages {

	
	static WebDriver driver;
	static String Username="prudhiviraju73@gmail.com";
	static String password ="FUCKYOU25";
	static String Baseurl ="https://www.gmail.com";
	static int Implicity_Wait =60; 
	static String Chrome_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	
	
	public static void main(String[] args) throws Throwable {
		
		
		System.setProperty("webdriver.chrome.driver",Chrome_path);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Implicity_Wait, TimeUnit.SECONDS);
		driver.get(Baseurl);
		
		driver.findElement(By.id("identifierId")).sendKeys(Username);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		
		List<WebElement>  elements=driver.findElements(By.xpath("//tr[@class='zA yO']"));
	
		System.out.println(elements.size());
		for(int i=0;i<elements.size();i++) {
			System.out.println(elements.get(i).getText());
			
		}
		
		System.out.println("**********************************************************");
		System.out.println(driver.getTitle());
		
		
		Thread.sleep(5000); 
		
		driver.findElement(By.xpath("//a[@class='gb_B gb_Da gb_g' and @aria-expanded='false']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		
		System.out.println("***********************************************************");
		System.out.println(driver.getTitle());
		
		
		driver.quit();
	}
	
}
