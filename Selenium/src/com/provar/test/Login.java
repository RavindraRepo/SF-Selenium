package com.provar.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends BaseClass{
//	@BeforeTest
	@BeforeMethod
	public void Start(){
		System.out.println("START");
//		 ChromeSetup();
		FirefoxsetUp();
		 setup();
		 driver.get("https://login.salesforce.com");
	}
	
	@Test
	 public void validLogin() throws InterruptedException{
		System.out.println("Inside validLogin");
		 driver.findElement(By.id("username")).sendKeys("ravindra@makepositive.com");
		 driver.findElement(By.id("password")).sendKeys("sf123456");
		 driver.findElement(By.id("rememberUn")).click();
		 driver.findElement(By.id("Login")).click();
		 Thread.sleep(10000);
		 String title=driver.getTitle();
//		 Thread.sleep(10000);
		 if(title.contains("Force.com Home Page")){
			 System.out.println("Home Page");
		 }else{
			 System.out.println("Its not Home page");
		 }
		 
	 }
	@Test
	public void Invaliduserpassword() throws InterruptedException{
		
		System.out.println("Inside Invaliduserpassword");
		driver.findElement(By.id("username")).sendKeys("ravindrayyyy@makepositive.com");
		 driver.findElement(By.id("password")).sendKeys("sf123456");
		 System.out.println(driver.findElement(By.id("rememberUn")).isSelected());
		 driver.findElement(By.id("rememberUn")).click();
		 System.out.println(driver.findElement(By.id("rememberUn")).isSelected());
		 driver.findElement(By.id("Login")).click();
		 try{
		 String error=driver.findElement(By.id("error")).getText();
		 System.out.println(error);
		 }catch(NoSuchElementException e){
			 
			 System.out.println("No error found");
		 }

	}
	
	public void SameTab()
	{
//		 driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
//	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//	    driver.switchTo().window(tabs.get(0));
	
	driver.findElement(By.linkText("Sign up for free.")).sendKeys(Keys.chord(Keys.SHIFT ,Keys.RETURN));
//    Set<String> windowHandles = driver.getWindowHandles();
//    System.out.println(windowHandles.size());
//    for (String string : windowHandles) {
//	driver.switchTo().window(string);
//	
//	
//	System.out.println(driver.getTitle());
//	
//    }
    
//    new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();
//    driver.switchTo().window(tabs.get(0)); 
//    System.out.println("tabsswitch");
//    System.out.println(driver.getTitle().toString());
//    driver.get("www.google.com");
//    driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("ravi");
	System.out.println("Finished");
	// Thread.sleep(10000);
	}
	@Test(priority=1)
	public void ValidSignUp() throws InterruptedException{
	
		System.out.println("Inside ValidSignUp");
		driver.findElement(By.linkText("Sign up for free.")).click();
		Assert.assertEquals(driver.getTitle(), "Free Trial - Salesforce 30-Day - Salesforce.coms");
		driver.findElement(By.id("UserFirstName")).sendKeys("Ravindra");
		driver.findElement(By.id("UserLastName")).sendKeys("Y");
		driver.findElement(By.id("UserTitle")).sendKeys("Tester");
		driver.findElement(By.id("UserEmail")).sendKeys("ravindra.engg12@gmail.com");
		driver.findElement(By.id("UserPhone")).sendKeys("808980890");
		driver.findElement(By.id("CompanyName")).sendKeys("MakePositive");
		driver.findElement(By.linkText("Employees")).click();
		//Give the xpath till the depth /a
		List<WebElement> findElements = driver.findElements(By.xpath("//ul[@class='selectBox-dropdown-menu selectBox-options'][1]/li/a"));
		System.out.println("No of Employee package are: "+findElements.size());
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());
		}
		//Using Arrow key
//		driver.findElement(By.linkText("Employees")).sendKeys(Keys.DOWN,Keys.ENTER);
//		findElements.get(2).sendKeys(Keys.ARROW_DOWN);
		//Using index option
//		findElements.get(3).click();
		//By link text
		driver.findElement(By.linkText("101 - 500 employees")).click();
 
		Thread.sleep(4000);
		driver.findElement(By.linkText("Language")).click();
		List<WebElement> findElements2 = driver.findElements(By.xpath("//ul[@class='selectBox-dropdown-menu selectBox-options'][2]/li/a"));
//		driver.findElement(By.xpath("//ul[@class='selectBox-dropdown-menu selectBox-options']/li[2]")).click();
		findElements2.get(3).click();
		driver.findElement(By.id("SubscriptionAgreement")).click();
		driver.findElement(By.xpath("//a[contains(@class,'submit aloha-submit-mid-blue')]")).click();
		
	}
//	@Test(dependsOnMethods="ValidSignUp",alwaysRun=true)
	@Test(priority=2)
	public void SignUpError()
	{
		System.out.println("Inside SignUpError");
		driver.findElement(By.linkText("Sign up for free.")).click();
		driver.findElement(By.xpath("//a[contains(@class,'submit aloha-submit-mid-blue')]")).click();
		try{
		String error=driver.findElement(By.xpath("//span[@class='form-field-error show-form-field-error']")).getText();
		System.out.println(error);
		Assert.assertEquals(error, "Enter your first name");
		}catch(NoSuchElementException e)
		{
			System.out.println("No error");
		}
	}
	@Test
	public void SignUpPlaceholders(){
		System.out.println("Inside SignUpPlaceholders");
		driver.findElement(By.linkText("Sign up for free.")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//ul[@class='clearfix vertical form-ul']/li/div/div[2]/input"));
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getAttribute("placeholder"));
		} 
		
	}
	@Test
	public void SigninWithGoogle(){
		System.out.println("Inside SigninWithGoogle");
		driver.findElement(By.linkText("Sign up for free.")).click();
		driver.findElement(By.xpath("//div[@class='serviceBtn-container']/div[2]/a/span")).click();
		Set<String> windowHandle = driver.getWindowHandles();
		String firstwindow=driver.getWindowHandle();
		for (String string : windowHandle) {
			if(string!=firstwindow){
				driver.switchTo().window(string);
			}
		}
		
		driver.findElement(By.id("Email")).sendKeys("ravindraprovar@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("testing");
		driver.findElement(By.id("signIn")).click();
		driver.switchTo().window(firstwindow);
		driver.findElement(By.id("UserFirstName")).sendKeys("Ravindra");
		
	}
	@Test
	public void ForgotPass(){
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.className("loginInputBox")).sendKeys("ravindra.yadavvv@makepositive.com");
		driver.findElement(By.id("continue")).click();
	}
	@Test
	public void ForgotPassInvalid(){
		driver.findElement(By.linkText("Forgot your password?")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.className("loginInputBox")).sendKeys("ravindra");
		driver.findElement(By.id("continue")).click();
		String error=driver.findElement(By.id("pw_error")).getText();
		System.out.println(error);
	}
	@Test
	public void app() throws InterruptedException
	{
		validLogin();
		driver.findElement(By.id("tsidButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sales")).click();
		Thread.sleep(2000);
	}
	@Test
	public void Account() throws InterruptedException{
		validLogin();
		driver.findElement(By.xpath("//ul[@id='tabBar']/li/a[text()='Account']")).click();
		Thread.sleep(4000);
		
	}
//	@AfterTest
	@AfterMethod
	public void teardown(){
		System.out.println("QUIT");
		driver.quit();
	}

}
