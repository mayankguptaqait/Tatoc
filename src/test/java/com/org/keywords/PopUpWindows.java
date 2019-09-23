package com.org.keywords;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpWindows {
	WebDriver driver;

	public PopUpWindows(WebDriver driver) {
		this.driver = driver;
	}

	public void launchPopUpWindowAndProceed() {
		driver.findElement(By.xpath("//a[text()='Launch Popup Window']")).click();
		System.out.println("User clicked on Launch Popup Window");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println("User switched to another tab.");
		driver.findElement(By.id("name")).sendKeys("hello automation");
		System.out.println("User entered hello automation in field.");
		driver.findElement(By.id("submit")).click();
		System.out.println("User clicked on submit button.");
		driver.switchTo().window(tabs2.get(0));
		driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		System.out.println("User clicked on proceed.");
	}
}
