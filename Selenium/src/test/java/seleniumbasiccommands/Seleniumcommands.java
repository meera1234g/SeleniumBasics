
	package seleniumbasiccommands;

	import java.util.List;

	import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class Seleniumcommands extends Browserlaunch {

	@Test

	// second
		public void Verifymultipledropdown() // When we need to select multiple elements from dropdown
		{
		
			driver.get("https://selenium.qabible.in/select-input.php");
			
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
	
	@Test
	   public void Validdemowebshop() 
	{
		
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginField = driver.findElement(By.className("ico-login"));
		loginField.click();
		WebElement userNameField = driver.findElement(By.id("Email")); 
	    userNameField.sendKeys("meeru.ammu@gmail.com");
		WebElement passwordField = driver.findElement(By.id("Password"));
		passwordField.sendKeys("qwerty123");
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton.click();
		WebElement actualemailfield = driver.findElement(By.xpath("//a[@class='account'and text()='meeru.ammu@gmail.com']"));
		String actualresult = actualemailfield.getText();
		String expectedresult = "meeru.ammu@gmail.com";
		Assert.assertEquals(actualresult, expectedresult, "Login not sucess"); // in third field message if it fails
	}
	 
	@Test
	public  void Demowebregistration() 
	{
		
		driver.get("https://demowebshop.tricentis.com/register ");
		WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		firstname.sendKeys("Meera");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
		lastname.sendKeys("G");
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys("hghg45479909@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("Test123");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmpassword.sendKeys("Test123");
		WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
		register.click();
		WebElement continuebutton = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutton.click();
		WebElement emailnew = driver.findElement(By.xpath("//a[@class='account'and text()='hghg45479909@gmail.com']"));
		String actualemail = emailnew.getText();
		String Expectedemail = "hghg45479909@gmail.com";
		Assert.assertEquals(actualemail, Expectedemail, "Login is not sucess");
		
	}
	
	  @Test
	  
	public  void Guru99registration() 
	  {
	
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstname.sendKeys("Meera");
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastname.sendKeys("G");
		WebElement phoneno = driver.findElement(By.xpath("//input[@name='phone']"));
	    phoneno.sendKeys("9874563214");
		WebElement email = driver.findElement(By.xpath("//input[@name='userName']"));
		email.sendKeys("abctest4339@gmail.com");
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
		WebElement nameofemail= driver.findElement(By.xpath("//b[text()=' Note: Your user name is testuser.']"));
		String actualname = nameofemail.getText();
		String Expectedname = "Note: Your user name is testuser." ;
		Assert.assertEquals(actualname, Expectedname, "Login not successful");
		Assert.assertTrue(true);// Boolean
	}

	  @Test
	  public  void verifyRadioButtonIsSelected() 
	  {
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radiobutton = driver.findElement(By.xpath("//input[@id='gender-male']"));
		Boolean ismaleselected = radiobutton.isSelected();
		Assert.assertFalse(ismaleselected, "Radio button is Selected");
		System.out.println(ismaleselected +"  Button is not selected");
		radiobutton.click();
		Boolean maleselected = radiobutton.isSelected();
		System.out.println(maleselected +"Button is Selected");
		Assert.assertTrue(maleselected,"  The male radio button is not selected");
		
	  }
	  
	  
	  @Test
	 public void verifyRadioButtonFemaleisSelected() 
	 {
     Boolean isfemaleselected;	  
	 driver.get("https://demowebshop.tricentis.com/register");
	 WebElement femaleradiobutton = driver.findElement(By.xpath("//input[@id='gender-female']"));
	 isfemaleselected = femaleradiobutton.isSelected();
	 Assert.assertFalse(isfemaleselected," The button is  selected");
	 System.out.println(isfemaleselected);  
	 femaleradiobutton.click();
	 isfemaleselected = femaleradiobutton.isSelected();
	 Assert.assertTrue(isfemaleselected," The button is not selected");
	 System.out.println(isfemaleselected);  
     }
	  
	  @Test
	  
	  public void verifyVotetabisDisplayed() 
	  {
		  driver.get("https://demowebshop.tricentis.com/");  
		  WebElement votebutton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		  Boolean isvotebuttonenabled = votebutton.isDisplayed();
		  Assert.assertTrue(isvotebuttonenabled, "Vote button not Displayed");
		  System.out.println( isvotebuttonenabled   +" Vote button  is Displayed");
	  }
	  @Test
	  
	  public void verifySubscribeButtonisEnabled() 
	  {
		  driver.get("https://demowebshop.tricentis.com/");  
		  WebElement subscribebutton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		  Boolean issubscribebuttonenabled = subscribebutton .isDisplayed();
		  Assert.assertTrue(issubscribebuttonenabled, " Subscribe button not Enabled");
		  System.out.println( issubscribebuttonenabled   +" Subcribe button is Enabled");
		 
	  }
  }     
	 



