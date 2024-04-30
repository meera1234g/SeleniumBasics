package org.selenium.commands;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Commands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Verifycommunitypool();
		//Verifyvaluesfromdropdown();
		Verifycolourfromdropdown();
	}
public static void Verifycommunitypool() {
WebDriver driver = new ChromeDriver();
driver.get("https://demowebshop.tricentis.com/ ");
driver.manage().window().maximize();
//List<WebElement> communitypoolelements = driver.findElements(By.xpath("//label[starts-with(@for,'poll')]//parent::li")); // Because we have a list of elements using xpath get 4 elements
List<WebElement> communitypoolelements = driver.findElements(By.xpath("//li[@class='answer']//input[@name='pollanswers-1']//following-sibling::label")); // Because we have a list of elements using xpath get 4 element
for(int i= 0; i<communitypoolelements.size();i++)	{ // for loop to fetch for elements
	//System.out.println(communitypoolelements.get(i).getText());
	String pollElementText = communitypoolelements.get(i).getText(); // Store to a string variable 
	if (pollElementText.equals("Good")) { // to check if two strings are equal using equals()
		communitypoolelements.get(i).click();// to click on that
}
	
	}
}



 
	public static void Verifyvaluesfromdropdown() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();	
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(dropdown);// create obj of select class
		//select.selectByVisibleText("INDIA");
		//select.selectByIndex(1);
		//select.selectByValue("ARMENIA");//String 
		//WebElement getcountryname = select.getFirstSelectedOption();
		//System.out.println(getcountryname.getText());
		List<WebElement> obj = select.getOptions();
		for(int i= 0; i<obj.size();i++)	{ // for loop to fetch for elements
			System.out.println(obj.get(i).getText());
		
}}
	public static void Verifycolourfromdropdown() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/");
		driver.manage().window().maximize();
	     WebElement inputform =	driver.findElement(By.xpath("//a[@class='nav-link'and@href='simple-form-demo.php']"));
		 inputform.click();
		 WebElement selectinput =	driver.findElement(By.xpath("//a[@href='select-input.php']"));
		 selectinput.click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control'and@id='single-input-field']"));
		Select select = new Select(dropdown);// create obj of select class
		//select.selectByVisibleText("Green");
	//	select.selectByIndex(2);
				//select.selectByValue("Yellow");//String 
				//WebElement getcolourname = select.getFirstSelectedOption();
				//System.out.println(getcolourname.getText());
				List<WebElement> obj = select.getOptions();
				for(int i= 0; i<obj.size();i++)	{ // for loop to fetch for elements
				System.out.println(obj.get(i).getText());
		
		
	}
	
}}