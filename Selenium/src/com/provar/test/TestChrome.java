package com.provar.test;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestChrome {
	
	WebDriver driver;
//	@BeforeTest
	public void ChromeSetup(WebDriver driver)
	{
		File driverFile = new File("C:\\Users\\admin\\workspace\\Selenium\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",driverFile.getAbsolutePath());
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--silent");
//		options.addExtensions(new File("C:/Users/admin/workspace/Selenium/extensions/extension_1_7_4.crx"));
//		options.addArguments("--silent");
//		options.addArguments("--load-extension=C:/Users/admin/workspace/Selenium/extensions/extension_1_7_4.crx");
		 options.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
	
//		capabilities.setCapability("webdriver.chrome.driver", driverFile.getAbsolutePath());
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		
		capabilities.setCapability("chrome.extensions","C:\\Users\\admin\\workspace\\Selenium\\chromedriver.exe");
		driver= new ChromeDriver(capabilities);
	}
	
//	@Test
	public void test() throws InterruptedException{
		
		driver.get("http://www.google.com");
		Thread.sleep(100);
		WebElement element=driver.findElement(By.id("gbqfq"));
		System.out.println(element.isDisplayed());
		driver.findElement(By.id("gbqfq")).sendKeys("India");
		driver.findElement(By.id("gbqfq")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,1000)");
		
//		driver.quit();
	}

	//@BeforeTest
	public void firefoxsetup() throws IOException{
		File ext1=new File("C:/Users/admin/Downloads/Automation/adblockplus-2.5.1.xpi");
		File ext2=new File("C:/Users/admin/Downloads/Automation/firebug-2.0.2-fx.xpi");
		FirefoxProfile profile=new FirefoxProfile();
		profile.addExtension(ext1);
		profile.addExtension(ext2);
//		profile.setPreference("extenstions.adblockplus.currentVersion", "2.5.1");
//		profile.setPreference("extenstions.firebug.currentVersion", "2.0.2");
		System.setProperty("webdriver.firefox.profile", "profile");
		DesiredCapabilities cap=DesiredCapabilities.firefox();
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		cap.setJavascriptEnabled(true); 
		driver=new FirefoxDriver(cap);
		
		
	}
	//Is Element displayed on the page
	public void isEditable(WebElement element){
		
		System.out.println(element.isDisplayed());
		
	}
	
	//IsElement present on the page
	public boolean isElementPresent(String xpath){
		try{
			driver.findElement(By.xpath(xpath));
			return true;
		}
		catch(NullPointerException e){
			return false;
		}
	}
	
	//Count of links present on the page
	public int linkCount(){
		int size = driver.findElements(By.xpath("//a")).size();
	return size;
	}
	
	public String getLinkText(WebElement link){
		String text = link.getText();
		return text;
	}
	

}
