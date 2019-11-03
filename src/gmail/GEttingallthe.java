package gmail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GEttingallthe {
	
	static WebDriver driver;
	static String  user_name="prudhiviraju73@gmail.com";
	static String Pass_Word ="FUCKYOU25";
	static String Base_url ="https://www.gmail.com";
	static String Chrome_path="C:\\\\Users\\\\Admin\\\\Desktop\\\\Selenium\\\\Latest\\\\chromedriver_win32\\\\chromedriver.exe";
	static int Implicity_Wait=60;
	static String Expected="Inbox - prudhiviraju73@gmail.com - Gmail";
	
	////div[@class='yJ aji']
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
	

	
	List<WebElement> element =driver.findElements(By.xpath("//div[@class='nM']"));
	
	
	
	System.out.println(element.size());
	
	for(int i=0;i<element.size();i++) {
		System.out.println(element.get(i).getText());
	}
	
	
	
	String actual=driver.getTitle();
	System.out.println(actual);
	
	if(actual.contains(Expected)) {
		System.out.println("the test case is passed");
	}else {
		System.out.println("the test case is failed");
	}
	
	
	
	
	
	
	
	
	

	driver.findElement(By.xpath("//a[@class='gb_B gb_Da gb_g' and @aria-expanded='false']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
	
	driver.quit();
	
	
}
}
