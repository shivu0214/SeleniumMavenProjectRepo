package com.MyStore.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendListenerClass implements ITestListener
{
	//create object of listener class
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig read = new ReadConfig();
		String timeSlip = new SimpleDateFormat("yyyy.mm.dd hh.ss").format(new Date());
		String report = "MAVEN_PROJECT" + timeSlip + ".html";
		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//ExtendReport//" +report);
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		//add system information info to reports
		reports.setSystemInfo("Machine", "HP");
		reports.setSystemInfo("OS", "Windows-10");
		reports.setSystemInfo("bowser", read.getBrowser());
		reports.setSystemInfo("Username", "Shivani");
		
		//configuration to change look and feel of report
		htmlreporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlreporter.config().setReportName("This is my Report");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	//OnStart method is called when any Test starts
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("onStart method involked....");
	}
	
	//onFinish method is called after all tests are executed
	public void onFinish(ITestContext Result)
	{
		System.out.println("onFinish method involked......");
		reports.flush();       // it is mendatory to call method to ensure information is written to the started reports
	}
	
	//When test case get failed, this method is called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());    //create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:" + Result.getName(), ExtentColor.RED));
		String Screenshotpath = System.getProperty("user.dir") + "\\Screenshot\\" + Result.getName() + ".png";
		File ScreenshotFile = new File(Screenshotpath);
		if(ScreenshotFile.exists())
		{
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(Screenshotpath));
		}
	}
	
	//When Test case get skipped, this method is called
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method skipped:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
	}
	
	//When test case get started, this method is called
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method started:" + Result.getName());
	}
	
	//When test case get passed, this method is called
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method successfully executed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is:" + Result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Resutl)
	{
		
	}
}
