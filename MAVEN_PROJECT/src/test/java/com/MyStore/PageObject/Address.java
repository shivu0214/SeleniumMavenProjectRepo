package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address {
	@FindBy(name="processAddress")
	WebElement checkout1;
		
	public Address(WebDriver driver)
	{
		driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCheckoutButton()
	{
		checkout1.click();
	}

}
