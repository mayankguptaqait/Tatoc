package com.org.automation;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

	WebDriver driver;
	private String driverConfig = "webdriver.chrome.driver";
	private String driverPath = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"driver"+File.separator+"chromedriver.exe";

	public WebDriver getDriver() {
		System.setProperty(driverConfig, driverPath);
		driver = new ChromeDriver();
		return driver;
	}

}
