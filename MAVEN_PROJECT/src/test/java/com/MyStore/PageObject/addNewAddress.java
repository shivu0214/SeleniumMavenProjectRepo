package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addNewAddress {
	 @FindBy(xpath=".//a[@href='http://www.automationpractice.pl/index.php?controller=address&back=order.php%3Fstep%3D1']")
	    WebElement newaddress;
	
	public addNewAddress(WebDriver driver)
	{
		driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewAddress()
	{
		newaddress.click();
	}
	
}
