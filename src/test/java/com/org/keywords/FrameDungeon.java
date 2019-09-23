package com.org.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameDungeon {
	WebDriver driver;

	public FrameDungeon(WebDriver driver) {
		this.driver = driver;
	}

	public void changeBoxColourAndProceed() {
		driver.switchTo().frame("main");
		String box1_class = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
		System.out.println("First box colour is " + box1_class);
		driver.switchTo().frame("child");
		String box2_class = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
		System.out.println("Second box colour is " + box2_class);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		while (box1_class != box2_class) {
			driver.findElement(By.xpath("//a[text()='Repaint Box 2']")).click();
			System.out.println("User clicked on Repaint Box because colour is not matched.");
			driver.switchTo().frame("child");
			box2_class = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
			System.out.println("Second box new colour is " + box2_class);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			if (box1_class.contentEquals(box2_class)) {
				System.out.println("Box 1 and Box 2 colour is matched.");
				break;
			}
		}
		driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		System.out.println("User clicked on proceed.");
	}

}
