package com.org.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAround {
	WebDriver driver;

	public DragAround(WebDriver driver) {
		this.driver = driver;
	}

	public void dragBoxToDropBox() {
		WebElement From = driver.findElement(By.xpath("//div[@id='dragbox']"));
		WebElement To = driver.findElement(By.xpath("//div[@id='dropbox']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(From, To).build().perform();
		System.out.println("User dragged box to DropBox.");
		driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		System.out.println("User clicked on proceed.");

	}
}
