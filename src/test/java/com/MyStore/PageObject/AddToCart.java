package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
		
	@FindBy(xpath="(.//a[@class='product-name'])[3]")
	WebElement product;
	
	@FindBy(xpath=".//span[text()='Add to cart']")
	WebElement addtocart;
	
	@FindBy(xpath=".//a[@title='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	public AddToCart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*
	public void selectDresses()
	{
		dresses.click();
	}
	*/
	public void clickOnProduct()
	{
		product.click();
	}
	public void clickOnAddToCart()
	{
		addtocart.click();
	}
	public void clickOnProceedToCheckout()
	{
		proceedtocheckout.click();
	}
}
