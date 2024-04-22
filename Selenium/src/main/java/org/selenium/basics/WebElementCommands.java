package org.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebElementCommands obj = new WebElementCommands();
	obj.Command();
		
	}
public void Command() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/v1/");
	WebElement userNameField = driver.findElement(By.id("user-name")); 
	userNameField.sendKeys("standard_user");
	WebElement passwordField = driver.findElement(By.id("password"));
	passwordField.sendKeys("secret_sauce");
	WebElement loginField = driver.findElement(By.id("login-button"));
	loginField.click();
}
}
