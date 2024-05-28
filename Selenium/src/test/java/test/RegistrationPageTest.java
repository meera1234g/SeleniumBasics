package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.BrowseraLaunch;
import utilities.ExcelUtility;

public class RegistrationPageTest extends BrowseraLaunch
{
	 
	@Test
		
	 public void verifyRegistrationPageTitle() 
	 {
	   driver.get("https://demowebshop.tricentis.com/login");
	   String actualtitle = driver.getTitle();
	   System.out.println(" The page Title login page is " + actualtitle);
	   //String expectedtitle = "Demo Web Shop. Login" ;  
	   String expectedtitle = ExcelUtility.readStringData(0, 0, "RegistrationPage");
	   Assert.assertEquals(actualtitle, expectedtitle, " Title is invalid ");
	 }
		@Test
		
	 public void verifyUserRegistration() 
	 {
			driver.get("https://demowebshop.tricentis.com/register ");
			WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
			firstname.sendKeys("Meera");
			WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
			lastname.sendKeys("G");
			WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
			email.sendKeys("abctest439@gmail.com");
			WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
			password.sendKeys("Test123");
			WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
			confirmpassword.sendKeys("Test123");
			WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
			register.click();
			 
	 }
}
