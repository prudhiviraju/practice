package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class TestNGGmail {

	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;	
	ExtentTest logger;
	
	

	@BeforeSuite
	public void extent() {
		htmlReporter = new ExtentHtmlReporter("./Extentreport/First.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger =extent.createTest("Gmailtest");
		
	}
	
	
	
	@BeforeTest
	public void Setup() {
		
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Selenium\\Latest\\chromedriver_win32\\chromedriver.exe");	
		
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	logger.log(Status.INFO,"the Browser has opened");
	extent.flush();
	}
	
	@BeforeClass
	public void Url() {
		
		driver.get("https://mail.google.com/");
		logger.log(Status.INFO,"Entering the URl");
		extent.flush();
		
	}
	
	@BeforeMethod
	public void intialization() {
		
		driver.findElement(By.xpath("//input[@id='identifierId' and @type='email']")).sendKeys("prudhiviraju73@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("FUCKYOU25");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		logger.log(Status.INFO,"Opening the gmail" );
		extent.flush();
		
	}
	
	@Test(priority = 0)
	public void fetchthedata() {
		
		
		List<WebElement> element =driver.findElements(By.className("zA yO"));
		
		System.out.println(element.size()+ " The total Number of Messages were Displayed");
		
		for(int i =0;i<element.size();i++) {
			
			
			System.out.println(element.get(i).getText());
		}
		
		logger.log(Status.INFO,"Fecting the data that No.of messages were there" );
		extent.flush();
		}
		

	@Test(priority = 1)
	public void logoverification() {
		
		WebElement logoverification =driver.findElement(By.xpath("//img[@class='gb_na']"));
		
		Boolean expected =logoverification.isDisplayed();
		
		if(!expected) {
			System.out.println("the logo is failed to load");
		}else {
			System.out.println("the logo is loaded");

		}
		
		
		
	}
	
	    @AfterMethod
	public void leftsidedata() {
		
	    
		driver.findElement(By.xpath("//span[contains(text(),'More') and @class='CJ']")).click();
		List<WebElement> element2 =driver.findElements(By.xpath("//div[@class='Ls77Lb aZ6']"));
		
		
		
		for(int i=0;i<element2.size();i++) {
			
			System.out.println(element2.get(i).getText());
			
			
		}
	
	logger.log(Status.INFO, "the leftside options gathered");
	extent.flush();
	}
	
	@AfterClass     

	public void gettitle() {
		
		System.out.println("The 6th testcase is executed");
		String title =driver.getTitle();
				
		String Expected ="Inbox - prudhiviraju73@gmail.com - Gmail";
	
		Assert.assertEquals(title, Expected);
		
		logger.log(Status.INFO,"The title has to verify");
		extent.flush();
		
		
	}
	
	@AfterTest
	public void AppsCount() {
		
		driver.findElement(By.xpath("//*[@class='gb_We' ]")).click();
		driver.findElement(By.xpath("//a[text()=\"More\"]")).click();
		List<WebElement> element3=driver.findElements(By.xpath("//ul[@class='gb_J gb_A']"));
		
		
		System.out.println("the size of the app count is " + element3.size());	
		
		for(int i=0;i<element3.size();i++) {
			System.out.println(element3.get(i).getText());
		}
		
		logger.log(Status.INFO,"the Size of the app count");
		extent.flush();
	}
	
	
	
	
	
	@AfterSuite
	public void teardown() {
		
		driver.quit();
		logger.log(Status.INFO,"the Browser is closed");
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
