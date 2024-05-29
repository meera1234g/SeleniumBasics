package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.BrowseraLaunch;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

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
		
	 public void verifyUserRegistration() // Random Data Generation
	 {
			String first_name = RandomDataUtility.getFirstName();
			String last_name = RandomDataUtility.getLastName();
			String mailid = first_name+"."+last_name+"@yahoo.com";
			String password_new = first_name+"."+last_name;
			
			driver.get("https://demowebshop.tricentis.com/register ");
			WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
			firstname.sendKeys(first_name);
			WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
			lastname.sendKeys(last_name);
			WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
			email.sendKeys(mailid);
			WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
			password.sendKeys(password_new);
			WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
			confirmpassword.sendKeys(password_new);
			WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
			register.click();
			WebElement success_message = driver.findElement(By.xpath("//div[@class='result']"));
			String actualsuccess_message = success_message.getText();
			String expectedsuccess_message = ExcelUtility.readStringData(0, 1,"RegistrationPage");
			Assert.assertEquals(actualsuccess_message,expectedsuccess_message,"Registration not successful");
	 }
		
		
}
