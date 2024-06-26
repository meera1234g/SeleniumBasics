package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.BrowseraLaunch;
import Listeners.RetryAnalyzer;
import dataprovider.DataProviders;
import utilities.ExcelUtility;

public class LoginPageTest extends BrowseraLaunch
{	
@Test(priority = 2)

 public void verifyLoginPageTitle()
 {
	driver.get("https://demowebshop.tricentis.com/login");
    String title = 	driver.getTitle();
    System.out.println(" The page Title login page is " + title);
    String expectedtitle = ExcelUtility.readStringData(0, 0, "LoginPage");
   // String expectedtitle = "Demo Web Shop. Login" ;  
    Assert.assertEquals(title, expectedtitle, "Invalid Title");
  }
 
@Test(priority = 3 ,retryAnalyzer = RetryAnalyzer.class )	
 public void verifyUserLogin()  
 {
 	driver.get("https://demowebshop.tricentis.com/login");
 	WebElement emailid_field = driver.findElement(By.xpath("//input[@id='Email']"));
 	emailid_field.sendKeys(ExcelUtility.readStringData(0, 3, "LoginPage"));
 	WebElement password_field = driver.findElement(By.xpath("//input[@id='Password']"));
 	password_field.sendKeys(ExcelUtility.readStringData(0, 4, "LoginPage"));
 	WebElement submit_button = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
 	submit_button.click();
 	WebElement nameofemailid = driver.findElement(By.xpath("//a[text()='abctest439@gmail.com']"));
 	String actualemailid = nameofemailid.getText();
 	String expectedmailid = ExcelUtility.readStringData(0, 1, "LoginPage");
 	//String expectedmailid = "abctest439@gmail.com";
 	Assert.assertEquals(actualemailid, expectedmailid, "Login not successful");
 	}
 @Test(dataProvider = "invaliduserCredentials", dataProviderClass = DataProviders.class)//variable ,class
 
 public void verifyInvalidUserlogin(String username , String password) // Data Provider @DataProvider annotation
{
	driver.get("https://demowebshop.tricentis.com/login");
	WebElement emailid_field = driver.findElement(By.id("Email"));
	emailid_field.sendKeys(username);
	WebElement password_field = driver.findElement(By.id("Password"));
	password_field.sendKeys(password);
	WebElement login_button = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	login_button.click();
	WebElement textloginmessage = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
	String textloginmessage_actual = textloginmessage.getText();
	String textloginmssage_expected = ExcelUtility.readStringData(0, 2,"LoginPage");
	Assert.assertEquals(textloginmessage_actual, textloginmssage_expected, "Login failed warning message not found");
}}
