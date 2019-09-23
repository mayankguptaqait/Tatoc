package com.org.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieHandling {

	WebDriver driver;

	public CookieHandling(WebDriver driver) {
		this.driver = driver;
	}

	public void generateTokenAndSubmit() {
		driver.findElement(By.xpath("//a[text()='Generate Token']")).click();
		System.out.println("User clicked on Generate Token");
		String token = driver.findElement(By.id("token")).getText();
		String final_token = "";
		System.out.println(token);
		for (int i = 7; i < token.length(); i++) {
			final_token = final_token + token.charAt(i);
		}
		System.out.println(final_token);
		Cookie name = new Cookie("Token", final_token);
		driver.manage().addCookie(name);
		System.out.println("Cookie successfully set.");
		driver.findElement(By.xpath("//a[text()='Proceed']")).click();
		System.out.println("User clicked on proceed.");
	}

}
