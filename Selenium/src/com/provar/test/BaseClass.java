package com.provar.test;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class BaseClass{

	WebDriver driver;
	@Test
	public void setup(){
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	public void ChromeSetup(){
		File driverFile = new File("C:\\Users\\admin\\workspace\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",driverFile.getAbsolutePath());
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--silent");
		options.addArguments("--disable-extensions");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("chrome.extensions","C:\\Users\\admin\\workspace\\Selenium\\chromedriver.exe");
		driver= new ChromeDriver(capabilities);
		
		
	}
	
	public void FirefoxsetUp(){
		driver=new FirefoxDriver();
	}
	
	
}
