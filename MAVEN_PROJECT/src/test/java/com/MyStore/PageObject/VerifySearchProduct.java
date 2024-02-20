package com.MyStore.PageObject;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifySearchProduct {
	@FindBy(xpath=".//input[@class='search_query form-control ac_input']")
	WebElement searchbutton;
	
	@FindBy(xpath=".//button[@class=\"btn btn-default button-search\"]")
	WebElement search;
	
	@FindBy(xpath=".//a[contains(text(),'Printed Summer Dress')]")
	WebElement product;
	
	WebDriver driver;
	public VerifySearchProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void searchField()
	{
		searchbutton.sendKeys("Printed Summer Dress");
	}
	public void submitsearch() 
	{
		search.click();
	}
	
	public String Product()
	{
		String verifyproduct = product.getText();
		return verifyproduct;
	}
}
