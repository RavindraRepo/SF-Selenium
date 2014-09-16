package com.provar.test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TimeSheet{
	WebDriver driver;
	@BeforeTest
	public void setUP(){
		File file=new File("D:\\workspace\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("silent");
		option.addArguments("disable-extensions");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
		cap.setCapability(ChromeOptions.CAPABILITY, option);
		driver=new ChromeDriver(cap);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void login(){
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("ravindra.yadav@makepositive.com");
		driver.findElement(By.id("password")).sendKeys("Ravi#126");
		driver.findElement(By.id("Login")).click();
		
	}
	@Test(dependsOnMethods="login")
	public void Kimble() throws InterruptedException
	{
		Thread.sleep(7000);
		driver.findElement(By.id("tsidButton")).click();
//		driver.findElement(By.xpath("//div[@id='tsid-menuItems']/a[2]")).click();
		List<WebElement> findElements = driver.findElement(By.id("tsid-menuItems")).findElements(By.tagName("a"));
		for (WebElement webElement : findElements) {
			String app=webElement.getText();
			if(app.equals("Kimble Time & Expense")){
				webElement.click();
				break;
			}
		}
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ui-datepicker-trigger")));
		element.click();
		
		List<WebElement> calenderrows= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr"));
		int totalrow=calenderrows.size();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[2]/a")).click();
		
		Thread.sleep(3000);
		int p=1;
		for( int j=1;j<=totalrow;j++){
			driver.findElement(By.className("ui-datepicker-trigger")).click();
			List<WebElement> dateday= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+j+"]/td"));
			System.out.println("Dates are "+dateday.size());
			for (WebElement webElement : dateday) {
				String day=webElement.getText();
				System.out.println(day);
				int t=Integer.parseInt(day);
				if(j==totalrow && t==1){break;}
			}
		for(int i=1;i<=5;i++){
			System.out.println("Iteration "+i);
			
			
			
		WebElement datelink=driver.findElement(By.xpath("//div[@id='TimesheetBody']/div/div[2]/div["+i+"]/div[2]/div/p/a"));
		
		datelink.click();
		Thread.sleep(10000);
		Select sel=new Select(driver.findElement(By.xpath("//td[@class='data2Col first']/div/select")));
		sel.selectByVisibleText("Make Positive (Products)-Provar (Test Analyst )");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//table[@class='detailList']/tbody/tr[4]/td/div/input")).sendKeys("8");
		WebElement ele=driver.findElement(By.xpath("//td[@class='data2Col last']/div/select"));
		Select selct=new Select(ele);
		selct.selectByVisibleText("Development & Launch");
		driver.findElement(By.xpath("//div[@id='AddTimeEntryPopup']/span/form/span[2]/div/div/div[2]/table/tbody/tr/td[2]/input[2]")).click();
		Thread.sleep(10000);
		
		}
		driver.findElement(By.xpath("//a[@title='Next Period']")).click();
		}
		
	}
	
	
	public void Calenderdate()
	{
		List<WebElement> dateday= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tboday/tr")).findElements(By.tagName("div"));
		for (WebElement webElement : dateday) {
			System.out.println(webElement.getText());
		}
	}
	
	

}
