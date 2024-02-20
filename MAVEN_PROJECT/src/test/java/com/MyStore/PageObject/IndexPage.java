package com.MyStore.PageObject;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
		//Create Object of webDriver
		WebDriver driver;
		//Constructor
		public IndexPage(WebDriver d)
		{
			driver=d;
			PageFactory.initElements(d, this);
		}
		//Identify Elements
		@FindBy(linkText = "Sign in")
		WebElement signin;
        
		//Identify action on webElement
		public void clickOnSignIn()
		{
			signin.click();
		}

		

		
}
