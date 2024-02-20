package com.MyStore.testCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.MyStore.Utilities.ReadConfig;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	ReadConfig red = new ReadConfig();
	String url = red.getBaseUrl();
	String browser = red.getBrowser();
	
	//Static object of WebDriver
	public static WebDriver driver;
	
	// Static Variable of logger
	public static org.apache.logging.log4j.Logger logger;
	@BeforeClass
	public void setup()
	{
		if(browser.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//for logging
		logger = LogManager.getLogger("MAVEN_PROJECT");
		//Open url
		driver.get(url);
		//Create object of logger
		logger.info("URL Should open");
				
	}
	@AfterClass
	public void close()
	{
		//driver.close();
	}
	
	
	public void TakeScreenshotMethod(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+ "\\Screenshot\\" + testName + ".png");
		FileUtils.copyFile(src, dest);
	}
	
}
