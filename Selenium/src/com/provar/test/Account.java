package com.provar.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class Account extends Login{
	@BeforeTest
	public void Account() throws InterruptedException{
		validLogin();
//		driver.findElement(By.xpath("//ul[@id='tabBar']/li/a[text()='Account']")).click();
		driver.findElement(By.linkText("Accounts")).click();
		Thread.sleep(8000);
	
		
	}
	public void lookup(){
		System.out.println("Inside Lookup");	
	String windowHandle = driver.getWindowHandle();
		driver.findElement(By.className("lookupIcon")).click();
		driver.getWindowHandles();
	
		
	}
	
	public void create() throws InterruptedException{
		driver.findElement(By.xpath("//input[@title='New']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("acc2")).click();
		Select sel=new Select(driver.findElement(By.id("acc9")));
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		System.out.println(allSelectedOptions.size());
		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
			
		}
		sel.selectByVisibleText("Hot");
		
	System.out.println("Function ends here for u");
	}

}
