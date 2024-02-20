package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation {

		WebDriver driver;
		public AccountCreation(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		//identify element
		@FindBy(id="id_gender2")
		WebElement titleMrs;
		
		@FindBy(id="customer_firstname")
		WebElement firstname;
		
		@FindBy(id="customer-lastname")
		WebElement lastname;
		
		@FindBy(id="passwd")
		WebElement pass;
		
		@FindBy(id="submitAccount")
		WebElement submit;
		
		//identify actions to be performed on web
		public void selectTitleMrs()
		{
			titleMrs.click();
		}
		public void EnterFirstName(String FN)
		{
			firstname.sendKeys(FN);
		}
		public void EnterLastName(String LN)
		{
			lastname.sendKeys(LN);
		}
		public void EnterPassword(String PSW)
		{
			pass.sendKeys(PSW);
		}
		public void ClickOnRegister()
		{
			submit.click();
		}
		
		
}
