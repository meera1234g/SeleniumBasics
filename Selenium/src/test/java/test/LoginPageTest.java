package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.BrowseraLaunch;
import utilities.ExcelUtility;

public class LoginPageTest extends BrowseraLaunch
{	
@Test

 public void verifyLoginPageTitle() throws IOException 
 {
	driver.get("https://demowebshop.tricentis.com/login");
    String title = 	driver.getTitle();
    System.out.println(" The page Title login page is " + title);
    String expectedtitle = ExcelUtility.readStringData(0, 0, "LoginPage");
   // String expectedtitle = "Demo Web Shop. Login" ;  
    Assert.assertEquals(title, expectedtitle, "Invalid Title");
  }
 
@Test	
 public void verifyUserLogin() throws IOException 
 {
 	driver.get("https://demowebshop.tricentis.com/login");
 	WebElement emailid_field = driver.findElement(By.xpath("//input[@id='Email']"));
 	emailid_field.sendKeys("abctest439@gmail.com");
 	WebElement password_field = driver.findElement(By.xpath("//input[@id='Password']"));
 	password_field.sendKeys("Test123");
 	WebElement submit_button = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
 	submit_button.click();
 	WebElement nameofemailid = driver.findElement(By.xpath("//a[text()='abctest439@gmail.com']"));
 	String actualemailid = nameofemailid.getText();
 	String expectedmailid = ExcelUtility.readStringData(0, 1, "LoginPage");
 	//String expectedmailid = "abctest439@gmail.com";
 	Assert.assertEquals(actualemailid, expectedmailid, "Login not successful");
 	}
 
 public void verifyInvalidUserlogin() 
{
		
}
}
