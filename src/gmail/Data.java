package gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Data {

	static WebDriver driver;
	static String  user_name="prudhiviraju73@gmail.com";
	static String Pass_Word ="FUCKYOU25";
	static String Base_url ="https://www.gmail.com";
	static String Chrome_path="C:\\\\Users\\\\Admin\\\\Desktop\\\\Selenium\\\\Latest\\\\chromedriver_win32\\\\chromedriver.exe";
	static int Implicity_Wait=60;
	static String Expected="Inbox - prudhiviraju73@gmail.com - Gmail";
	static String text="this is prudhvi R@zz";
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",Chrome_path);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Implicity_Wait, TimeUnit.SECONDS);
		
		
		driver.get(Base_url);
		
		driver.findElement(By.id("identifierId")).sendKeys(user_name);;
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		
		driver.findElement(By.name("password")).sendKeys(Pass_Word);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		

		driver.findElement(By.xpath("//*[@class='gb_Ue']")).click();
		
		List<WebElement> element =driver.findElements(By.xpath("//ul[@class='gb_H gb_y']"));
		
		System.out.println(element.size());
		
		for(WebElement w: element) {
			System.out.println(w.getText());
		}


		
		String old =driver.getWindowHandle();
		
		driver.findElement(By.id("gb192")).click();
		
		
		Set<String> windows =driver.getWindowHandles();
		
		ArrayList<String> newtab = new ArrayList<>(driver.getWindowHandles());
		newtab.remove(old);
		driver.switchTo().window(newtab.get(0));
		
		
		
		
		
		driver.findElement(By.xpath("//div[@class='GiKO7c' and contains(text(),'Send feedback')]")).click();
		
	
		driver.findElement(By.xpath("//textarea[1]")).sendKeys(text);

		driver.findElement(By.xpath("//button[@key='cancel']")).click();
		
		driver.switchTo().window(old);
		
		driver.findElement(By.xpath("//a[@class='gb_B gb_Da gb_g' and @aria-expanded='false']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		
		driver.quit();

		
	}
	
}
