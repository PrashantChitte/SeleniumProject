package com.scp.logintests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scp.orangehrm.login.OrangeHRMLogin;

public class LoginTest {
  
	
	@Test
	public void loginOrangeHRM() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prashant\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		OrangeHRMLogin hrmLogin = PageFactory.initElements(driver, OrangeHRMLogin.class);
		hrmLogin.enterCredentials("Admin", "admin");
		
	}

	
	@Test(enabled=false)
	public void validateLoginPage() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		OrangeHRMLogin hrmLogin = PageFactory.initElements(driver, OrangeHRMLogin.class);
		hrmLogin.validateOrangeHRMPage();
		
	}
	
	
	@Test(enabled=false)
	public void errorScenarios() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		OrangeHRMLogin hrmLogin = PageFactory.initElements(driver, OrangeHRMLogin.class);
		hrmLogin.enterCredentials("Admin", "admin");
		Assert.assertEquals(hrmLogin.getErrorMessage(),"Login Success1");
	}
	
}










