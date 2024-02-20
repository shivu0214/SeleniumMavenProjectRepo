package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping {
		@FindBy(id="cgv")
		WebElement checkbox;
		
		@FindBy(name="processCarrier")
		WebElement Checkout2;
		
		
		WebDriver driver;
		public Shipping(WebDriver driver)
		{
			driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnBox()
		{
			checkbox.click();
		}
		
		public void clickOnCheckout()
		{
			Checkout2.click();
		}
}
