package org.selenium.commands;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Commands 
{

  public static void main(String[] args)  
  { 
	  
		// TODO Auto-generated method stub
		//Verifycommunitypool();
		//Verifyvaluesfromdropdown();
		//  Verifycolourfromdropdown();
		// Verifymultipledropdown();
	    // VerifyRadioButton();
	    //VerifySingleInput();
	    // VerifyTwoInputField();
	     //SingleCheckboxDemo() ;
		 
	//  MultipleCheckboxDemo() ;
	  //Demowebregistration();
	  Guru99registration();
	  
  }
      public static void Verifycommunitypool() 
       {
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



 
	 public static void Verifyvaluesfromdropdown()  
	   {
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
		  for(int i= 0; i<obj.size();i++)	
		    { 
			  // for loop to fetch for elements
		      System.out.println(obj.get(i).getText());
		    }
		}
	 
	 
	 
	public static void Verifycolourfromdropdown() 
	  {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://selenium.qabible.in/index.php");
		 driver.manage().window().maximize();
	     WebElement inputform =	driver.findElement(By.xpath("//a[@class='nav-link'and@href='simple-form-demo.php']"));
		 inputform.click();
		 WebElement selectinput =	driver.findElement(By.xpath("//a[@href='select-input.php']"));
		 selectinput.click();
		 WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control'and@id='single-input-field']"));
		 Select select = new Select(dropdown);// create obj of select class
		 //select.selectByVisibleText("Green");
	     //select.selectByIndex(2);
		 //select.selectByValue("Yellow");//String 
		 //WebElement getcolourname = select.getFirstSelectedOption();
		 //System.out.println(getcolourname.getText());
		 
		 List<WebElement> obj = select.getOptions();
	     for(int i= 0; i<obj.size();i++)	
	      { 
	    	 // for loop to fetch for elements
		     System.out.println(obj.get(i).getText());
		
		
	      }
	  }
	
	public static void Verifymultipledropdown() // When we need to select multiple elements from dropdown
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/select-input.php");
		driver.manage().window().maximize();
		WebElement multipleelements = driver.findElement(By.xpath("//select[@class='form-control'and@id='multi-select-field']"));
		Select select = new Select(multipleelements);	
		select.selectByVisibleText("Red");
		select.selectByVisibleText("Yellow");
		Boolean selectedvalue =  select.isMultiple();
		System.out.println(selectedvalue);
		List<WebElement> selectedvalues =   select.getAllSelectedOptions();
		for(WebElement e : selectedvalues)
		{
	    System.out.println(e.getText());
		}
		select.deselectByValue("Red");
	}
	
	public static void VerifyRadioButton() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		WebElement radiobutton = driver.findElement(By.xpath("//div[@class='inputs']//input[@id='gender-male']"));
		radiobutton.click();
		Boolean obj = radiobutton.isSelected();
		System.out.println(obj);
		Boolean obj1 = radiobutton.isDisplayed();
		System.out.println(obj1);
		Boolean obj2 = radiobutton.isEnabled();
		System.out.println(obj2);
	}
	
	
	public static void VerifySingleInput() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
		WebElement singleinput = driver.findElement(By.xpath("//input[@type='text'and@id='single-input-field']"));
		singleinput.sendKeys("Meera");
		WebElement showmessage = driver.findElement(By.xpath("//button[@id='button-one']"));
		showmessage.click();
	}
 
	public static void VerifyTwoInputField() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
		WebElement input1 = driver.findElement(By.xpath("//input[@id='value-a']"));
		input1.sendKeys("1");
		WebElement input2 = driver.findElement(By.xpath("//input[@id='value-b']"));
		input2.sendKeys("2");
		WebElement gettotal = driver.findElement(By.xpath("//button[@id='button-two']"));
		gettotal.click();
	}
	
	
	public static void SingleCheckboxDemo() 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
		WebElement singlecheckbox = driver.findElement(By.xpath("//label[@class='form-check-label'and@for='gridCheck']"));
		singlecheckbox.click();
	}
	
	public static void MultipleCheckboxDemo() 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
		
		List<WebElement> multiplecheckbox = driver.findElements(By.xpath("//form[@method='POST']//input[@id='is_checked']")); // Because we have a list of elements using xpath get 4 element
	       for(int i= 0; i<multiplecheckbox.size();i++)	{ // for loop to fetch for elements
		   System.out.println(multiplecheckbox.get(i).getText());
		   //String pollElementText = multiplecheckbox.get(i).getText(); // Store to a string variable 
		  
		
		
	
	       }}
	public static void Demowebregistration() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register ");
		driver.manage().window().maximize();
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
	
	public static void Guru99registration() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstname.sendKeys("Meera");
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastname.sendKeys("G");
		WebElement phoneno = driver.findElement(By.xpath("//input[@name='phone']"));
	    phoneno.sendKeys("9874563214");
		WebElement email = driver.findElement(By.xpath("//input[@name='userName']"));
		email.sendKeys("abctest439@gmail.com");
		WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
		address.sendKeys("ABC STREET , ACV ");
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("xyz");
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		state.sendKeys("Kerala");
		WebElement postalcode = driver.findElement(By.xpath("//input[@name='postalCode']"));
		postalcode.sendKeys("682304");
		WebElement countrydropdown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countrydropdown);
		select.selectByVisibleText("INDIA");
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("testuser");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Test123");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		confirmpassword.sendKeys("Test123");
		WebElement register = driver.findElement(By.xpath("//input[@name='submit']"));
		register.click();
		
		
	}
	
}
	

