package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.BrowseraLaunch;
import utilities.ExcelUtility;

public class HomePageTest extends BrowseraLaunch 
{
@Test
	
  public void verifyHomePageTitle() throws IOException 
  {
	
	driver.get("https://demowebshop.tricentis.com/");
    String  actualtitle = 	driver.getTitle();
    System.out.println(" The page Title is " + actualtitle);
    String expectedtitle = ExcelUtility.readStringData(0, 0,"HomePage") ;  // classname.methodname
	Assert.assertEquals(actualtitle, expectedtitle, " Title is invalid ");
  }

  @Test
  
   public void verifyCoomunityPoolSelection() throws IOException 
  
	  {
	       driver.get("https://demowebshop.tricentis.com/ ");
	       List<WebElement> communitypoolelements = driver.findElements(By.xpath("//li[@class='answer']//input[@name='pollanswers-1']//following-sibling::label")); // Because we have a list of elements using xpath get 4 element
	       String data = ExcelUtility.readStringData(0, 1, "HomePage");
	       for(int i= 0; i<communitypoolelements.size();i++)	{ // for loop to fetch for elements
		   
		   String pollElementText = communitypoolelements.get(i).getText(); // Store to a string variable 
		   if (pollElementText.equals(data)) 
		   { // to check if two strings are equal using equals()
		   communitypoolelements.get(i).click();// to click on that
		   
			// Assertion for this??  not working for us selected
		   WebElement elementselected = driver.findElement(By.xpath("//label[@for='pollanswers-2']"));
		   Boolean iselementenabled = elementselected.isEnabled();
		   Assert.assertTrue(iselementenabled, "Element is not selected");
	       }
      }

	  }}

