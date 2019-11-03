package inheritence;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentClas {
	
	
	
	static String Base_url="https://www.irctc.co.in/nget/train-search";
	static WebDriver driver;
	static String chrome_path="C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe";
	static int Implicity_wait=60;
	
	
	
	public void setup() {
        System.setProperty("webdriver.chrome.driver",chrome_path);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Implicity_wait, TimeUnit.SECONDS);
		
	}
		
		public void url() {
		driver.get(Base_url);
				
		}
		
		
		public void logoverification() {
		
			boolean logo_verify=driver.findElement(By.xpath("//div[@class='h_logo_left_div hidden-xs']//img[@class='h_logo']")).isDisplayed();
			if(logo_verify) {
				System.out.println("the test case is passed");
			}else {
				System.out.println("the test case is failed");
			}
			
			
		}
		
		
		public void checkboxverificetion() {
	
			WebElement selected=driver.findElement(By.xpath("//label[text()='Flexible With Date']"));
			selected.click();
	
			boolean yes=selected.isEnabled();
			
			if(yes) {
				System.out.println("the test case is passed");
			}else {
				System.out.println("the test case is failed");
			}
		
		}
		
		public void teardown() {
			driver.quit();
				
		}
		
		
	

}
