package com.org.automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.Reporter;

import com.org.keywords.*;

public class TestSessionInitiator {

	protected WebDriver driver;
	private final WebDriverFactory wdfactory;
	public HomePage HomePage;
	public GridGate GridGate;
	public FrameDungeon FrameDungeon;
	public DragAround DragAround;
	public PopUpWindows PopUpWindows;
	public CookieHandling CookieHandling;

	public void initPage() {
		HomePage = new HomePage(driver);
		GridGate = new GridGate(driver);
		FrameDungeon = new FrameDungeon(driver);
		DragAround = new DragAround(driver);
		PopUpWindows = new PopUpWindows(driver);
		CookieHandling = new CookieHandling(driver);
	}

	private void configureBrowser() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public TestSessionInitiator(String testname) {
		wdfactory = new WebDriverFactory();
		driver = wdfactory.getDriver();
		testInitiator(testname);
	}

	private void testInitiator(String testname) {
		System.out.println("===============================================");
		System.out.println(testname + " Execution started");
		System.out.println("===============================================");
		initPage();
		configureBrowser();
	}

	public void launchApplication(String baseurl) {
		Reporter.log("\nApplication url is :- " + baseurl, true);
		driver.manage().deleteAllCookies();
		driver.get(baseurl);
		Assert.assertEquals(driver.getTitle(), "Welcome - T.A.T.O.C");
		Reporter.log("User is on Application Page", true);
	}

	public void closeBrowserSession() throws IOException {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
