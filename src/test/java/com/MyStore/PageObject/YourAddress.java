package com.MyStore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddress {
		
		@FindBy(id="address1")
		WebElement address;
		
		@FindBy(id="city")
		WebElement city;
		
		@FindBy(id="id_state")
		WebElement state;
		
		@FindBy(xpath=".//option[text()='Alabama']")         //to choose option from listbox
		WebElement alabama;
		
		@FindBy(id="postcode")
		WebElement zipcode;
		
		@FindBy(id="id_country")
		WebElement country;
		
		@FindBy(id="phone")
		WebElement homephoneno;
		
		@FindBy(id="phone_mobile")
		WebElement mobno;
		
		@FindBy(id="alias")
		WebElement addresstitle;
		
		@FindBy(id="submitAddress")
		WebElement save;
		
		WebDriver driver;
		public YourAddress(WebDriver driver)
		{
			driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnAlabama() 
		{
			address.click();
		}
		
		public void enterAddress(String add)
		{
			address.sendKeys(add);
		}
		
		public void enterCity(String City)
		{
			city.sendKeys(City);
		}
		
		public void clickOnState()
		{
			state.click();
		}
		
		public void enterPostalCode(String zip)
		{
			zipcode.sendKeys(zip);
		}
		
		public void clickOnCountry()
		{
			country.click();
		}
		
		public void enterHomePhoneNo(String Hphone)
		{
			homephoneno.sendKeys(Hphone);
		}
		
		public void enterMobNo(String Mob)
		{
			mobno.sendKeys(Mob);
		}
		
		public void enterAddressTitle(String add_title)
		{
			addresstitle.sendKeys(add_title);
		}
		
		public void clickOnSave()
		{
			save.click();
		}

		
}
