package com.org.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectCourseType(String type) {
		driver.findElement(By.xpath("//a[text()='" + type + "']")).click();
		System.out.println("User clicked on " + type + ".");
	}

}
