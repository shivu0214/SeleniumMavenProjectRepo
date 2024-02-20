package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserName {
	WebDriver driver;
	public RegisterUserName(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='View my customer account'][1]")
	WebElement username;
	
	public String getUserName()
	{
		String text = username.getText();
		return text;
	}

}
