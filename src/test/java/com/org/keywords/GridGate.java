package com.org.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GridGate {
	WebDriver driver;

	public GridGate(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGreenGrid() {
		driver.findElement(By.cssSelector(".greenbox")).click();
		System.out.println("User clicked on greenbox.");
	}

}
