package com.provar.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AgileForce1 {
	
	WebDriver driver;
	@BeforeTest
	public void Setup() throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		Thread.sleep(20);
		
	}
	@Test
	public void SignIn()
	{
		driver.findElement(By.id("username")).sendKeys("vikas.wig@88demo.com");
		driver.findElement(By.id("password")).sendKeys("Admin54321");
		driver.findElement(By.id("Login")).click();
	}
	
	@Test(dependsOnMethods="SignIn")
	public void CreateProject() throws InterruptedException{
		driver.findElement(By.xpath("//a[@title='Projects Tab']")).click();
		System.out.println("Project clicked");
		Thread.sleep(30);
		driver.findElement(By.name("new")).click();
		Thread.sleep(30);
		
		driver.findElement(By.id("Name")).sendKeys("SelProject");
		Select type=new Select(driver.findElement(By.id("00N20000007GYUf")));
		
		type.selectByVisibleText("Fixed Price");
		
		Select status=new Select(driver.findElement(By.id("00N20000007GYUe")));
		status.selectByVisibleText("Not Started");
		
		//Enter text in description
		
		driver.switchTo().frame(driver.findElement(By.id("00N20000007GYUFEA4_frame")));
		driver.findElement(By.xpath("//html[@class='CSS1Compat']")).sendKeys("description for testing");
		driver.switchTo().defaultContent();
//		driver.findElement(By.xpath("//input[@title='Save']")).click();
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		System.out.println("End Sign in section");
		
	}
}
