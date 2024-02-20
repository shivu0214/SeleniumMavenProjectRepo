package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class MyAccount {
	
	WebDriver driver;
	public MyAccount(WebDriver driver)
	{
		driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		//identify element
		@FindBy(id="email_create")
		WebElement emailcreate;
		
		@FindBy(id="submitcreate")
		WebElement submitcreate;
		
		@FindBy(id="email")
		WebElement RegisterUser;
		
		@FindBy(id="passwd")
		WebElement RegisterPass;
		
		@FindBy(id="SubmitLogin")
		WebElement SubmitRegister;
		
	    public void enterCreateEmail(String email)
		{
			emailcreate.sendKeys(email);
		}
		
		public void clickOnSubmit()
		{
			submitcreate.click();
		}
		
		//Action Performed for already Register Account
		public void RegisterUserMail(String registeruser)
		{
			RegisterUser.sendKeys(registeruser);
		}
		public void RegisterPassword(String registerpwd)
		{
			RegisterPass.sendKeys(registerpwd);
		}
		public void ClickOnRegister()
		{
			SubmitRegister.click();
		}
		
}
