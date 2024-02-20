package com.MyStore.testCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyStore.PageObject.AccountCreation;
import com.MyStore.PageObject.AddToCart;
import com.MyStore.PageObject.Address;
import com.MyStore.PageObject.Checkout;
import com.MyStore.PageObject.IndexPage;
import com.MyStore.PageObject.MyAccount;
import com.MyStore.PageObject.RegisterUserName;
import com.MyStore.PageObject.Shipping;
import com.MyStore.PageObject.VerifySearchProduct;
import com.MyStore.PageObject.YourAddress;
import com.MyStore.PageObject.addNewAddress;

@Test
public class myaccount extends BaseClass{
	@Test(enabled=false)
	public void verifyUserRegistration()
	{
				//object of indexpage
		IndexPage pg = new IndexPage(driver);
		pg.clickOnSignIn();
		
		MyAccount acc = new MyAccount(driver);
		acc.enterCreateEmail("shivani@gmail.com");
		acc.clickOnSubmit();
		logger.info("Email Address entered in created section");
		
		AccountCreation acc1 = new AccountCreation(driver);
		acc1.selectTitleMrs();
		acc1.EnterFirstName("Shivani");
		acc1.EnterLastName("Dhabadge");
		acc1.EnterPassword("Shivani@123");
		acc1.ClickOnRegister();
		logger.info("Enter user details on account creation page");

		RegisterUserName reguser = new RegisterUserName(driver);
		String username = reguser.getUserName();
		Assert.assertEquals("Shivani Dhabadge", username);
		logger.info("Shivani Dhabadge");
	}
	@Test
	public void VerifyLogin() throws IOException
	{
    IndexPage pg = new IndexPage(driver);
	pg.clickOnSignIn();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	MyAccount acc = new MyAccount(driver);
	acc.RegisterUserMail("shivani@gmail.com");
	acc.RegisterPassword("Shivani@123");
	acc.ClickOnRegister();
	
	//verify username
	RegisterUserName reguser = new RegisterUserName(driver);
	String username = reguser.getUserName();
	if(username.equals("Shivani Dhabadge"))
	{
		logger.info("Verify Login---------passs");
		TakeScreenshotMethod(driver, "Verify Login");
		Assert.assertTrue(true);
	}
	else
	{
		logger.info("Verify login-----Fail");
		Assert.assertTrue(false);
	}
	}
	    @Test(dependsOnMethods = "VerifyLogin")
		public void productPurchase()
		{
		VerifySearchProduct searchpro = new VerifySearchProduct(driver);
		searchpro.searchField();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		searchpro.submitsearch();
		String expResult = searchpro.Product();
		Assert.assertEquals("Printed Summer Dress", expResult);
		logger.info("Product is added into cart");
	   
		AddToCart cart = new AddToCart(driver);
	    cart.clickOnProduct();
	    cart.clickOnAddToCart();
	    cart.clickOnProceedToCheckout();
	    logger.info("Product is added into cart");
	    
	    Checkout ch = new Checkout(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    ch.finalCheckout();
	    
	    addNewAddress aa = new addNewAddress(driver);
	    aa.clickOnNewAddress();
	    
	    Address ads = new Address(driver);
	    ads.clickOnCheckoutButton();
	    logger.info("Product Proceed To Checkout");
	    
	    Shipping ship = new Shipping(driver);
	    ship.clickOnBox();
	    ship.clickOnCheckout();
	    logger.info("Product Shipping");
	    
	    YourAddress yd = new YourAddress(driver);
	    yd.enterAddress("ukd");
	    yd.enterCity("UKD");
	    yd.clickOnAlabama();
	    yd.clickOnState();
	    yd.enterPostalCode("44520");
	    yd.clickOnCountry();
	    yd.enterHomePhoneNo("1122334455");
	    yd.enterMobNo("9999999999");
	    yd.enterAddressTitle("xyz");
	    yd.clickOnSave();
	    logger.info("Your Address is Created");
	}
	
}
