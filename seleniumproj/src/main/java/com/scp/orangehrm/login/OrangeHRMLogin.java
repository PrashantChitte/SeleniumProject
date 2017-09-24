package com.scp.orangehrm.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;
/**
 * 
 * @author Prashant
 *  Desc - this class represents OrangeHRM Login Page
 */
public class OrangeHRMLogin {
	//http://opensource.demo.orangehrmlive.com/
	@FindBy(id="txtUsername")
	WebElement userNameInput;
	
	@FindBy(id="txtPassword")
	WebElement passwordInput;
	
	@FindBy(id="btnLogin")
	WebElement signBtn;
	
	@FindBy(id="spanMessage")
	WebElement errorMessage;
	
	private void enterUserName(String unm){
		userNameInput.clear();
		userNameInput.sendKeys(unm);
	}
	
	private void enterPassword(String pwd){
		passwordInput.clear();
		passwordInput.sendKeys(pwd);
	}

	private void clickSign(){
		signBtn.click();
	}
	
	public void enterCredentials(String unm,String pw){
		this.enterUserName(unm);
		this.enterPassword(pw);
		this.clickSign();
	}
	
	
	public boolean validateOrangeHRMPage(){
		try{
		return	userNameInput.isDisplayed() && passwordInput.isDisplayed() &&
				signBtn.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	
	private boolean checkErrorMessage(WebElement element){
		try{
			return	element.isDisplayed();
			}catch(Exception e){
				return false;
			}
	}
	
	public String getErrorMessage(){
		if(checkErrorMessage(errorMessage)){
			return errorMessage.getText();
		}else
			if(checkErrorMessage(signBtn))
			{
				Assert.fail("Issue in error message");
				return null;
			}else
				return "Login Success";
	}
	
	
	
	
	
}
