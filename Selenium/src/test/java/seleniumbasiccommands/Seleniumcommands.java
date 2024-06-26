
	package seleniumbasiccommands;
    import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
    import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
    import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		  Boolean issubscribebuttonenabled = subscribebutton.isEnabled();
		  Assert.assertTrue(issubscribebuttonenabled, " Subscribe button not Enabled");
		  System.out.println( issubscribebuttonenabled   +" Subcribe button is Enabled");
		 
	  }
	  
	  @Test
	  
	  public void verifyRightClick() 
	  {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclickbutton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action = new Actions(driver);// Create obj of action class
		action.contextClick(rightclickbutton).build().perform();// obj.contextClick(variable).build().perform();
		
		  
	  }
	  
	  @Test
	  
	  public void verifyDoubleClick() 
	  {
		 driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		 WebElement doubleclick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		 Actions action = new Actions(driver);
		 action.doubleClick(doubleclick).build().perform();
	  }
	  @Test
	  
	  public void verifyDragAndDrop() 
	  {
		driver.get("https://demoqa.com/droppable");  
		WebElement dragelement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropelement = driver.findElement(By.xpath("//div[@id='droppable']"));//includeclass also to get 1 on 1 
		Actions action = new Actions(driver);
		action.dragAndDrop(dragelement, dropelement).build().perform();
	  }
	  @Test
	  
	  public void verifyDragAndDropoffset() // When target is unknown
	  {
		driver.get("https://demoqa.com/dragabble"); 
		WebElement dragelement = driver.findElement(By.xpath("//div[@id='dragBox']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragelement,150,150).build().perform();// pixel value for axis
	  }
	   @Test
	   
	  public void verifyMouseHover() 
	   {
		  driver.get("https://demoqa.com/menu/");
		  WebElement mainelement = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		  Actions action = new Actions(driver);
		  action.moveToElement(mainelement).build().perform();
		  WebElement subelement = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		  action.moveToElement(subelement).build().perform();
	  }
	   @Test
	   
	   public void verifySimpleAlert() // To verify Alert
	   {
		driver.get("https://demoqa.com/alerts"); 
		WebElement clickme_button = driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickme_button.click();
		Alert alert = driver.switchTo().alert();// To switch to alert creating object for Alert
		alert.accept(); // To click ok on Alert 
		}
	   
	   @Test
	   
	   public void validateConfirmationAlert() 
	   {
		driver.get("https://demoqa.com/alerts");
		WebElement confirm_button = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		confirm_button.click();
		Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		System.out.println(alert_text);
		alert.dismiss();
		WebElement clickcancelelement = driver.findElement(By.xpath("//span[@id='confirmResult']"));
		String actualresult = clickcancelelement.getText();
		String expectedresult = "You selected Cancel";
		Assert.assertEquals(actualresult,expectedresult,"You Selected OK");
	   }
	   
	   @Test
	   
	   public void validatePromptAlert() 
	   {
		 driver.get("https://demoqa.com/alerts");  
		 WebElement prompt_button = driver.findElement(By.xpath("//button[@id='promtButton']"));
		 prompt_button.click();
		 Alert alert = driver.switchTo().alert();
		 String alert_text = alert.getText();
		 System.out.println(alert_text);
		 alert.sendKeys("The name is test");
		 alert.accept();
		 WebElement textmessage_name = driver.findElement(By.xpath("//span[@id='promptResult']"));
		 String actualresult = textmessage_name.getText();
		 String expectedresult = "You entered The name is test";
		 Assert.assertEquals(actualresult, expectedresult,"You have not entered a text");
		 
	   }
	    @Test
	    
	   public void validateDoubleClickAlert() 
	   {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");   
		WebElement doubleclick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleclick).build().perform();
	    Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		System.out.println(alert_text);
		alert.accept();
	  }
	    @Test
	    
	    public void verifyMultipleWindowHandling()
	    {
	       driver.get("https://demo.guru99.com/popup.php");
	       String parentwindow_handleid = 	driver.getWindowHandle();// To get window handle id
	       System.out.println(parentwindow_handleid);
	       WebElement click_button = driver.findElement(By.xpath("//a[@target='_blank'and text()='Click Here']"));
	       click_button.click();
	       Set<String> windowshandlesid = driver.getWindowHandles();
	       System.out.println(windowshandlesid);
	       Iterator <String> values = windowshandlesid.iterator();// 
	       while(values.hasNext())// return type boolean
	       {
	    	String handleid = values.next();
	    	if(!handleid.equals(parentwindow_handleid)) 
	    	 {
	    		driver.switchTo().window(handleid);
	    		WebElement emailid = driver.findElement(By.xpath("//input[@name='emailid']"));
	    		emailid.sendKeys("abc@gmail.com");
	    		WebElement submit_button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
	    		submit_button.click();
	    		driver.close();
	    		
	    	 }
	      }
	       driver.switchTo().window(parentwindow_handleid);
	    }
	   
	
	    @Test
	
	
	public void testnew() {
		
	    driver.get("https://demo.guru99.com/articles_popup.php");
		WebElement emailid = driver.findElement(By.xpath("//input[@name='emailid']"));
		emailid.sendKeys("abc@gmail.com");	
	}
	    @Test
	    
	  public void  verifyFileUpload() 
	  {
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement fileupload_field = driver.findElement(By.xpath("//input[@name='uploadfile_0']"));
		fileupload_field.sendKeys("C:\\Users\\Meera Rupak\\git\\SeleniumBasics\\Selenium\\src\\main\\resources");
		WebElement checkbox_field = driver.findElement(By.xpath("//input[@id='terms']"));
		checkbox_field.click();
		WebElement submit_button = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submit_button.click();
		WebElement text_name = driver.findElement(By.xpath("//h3[@id='res']"));
		String expected_result = text_name.getText();
		System.out.println(expected_result);
		//String actual_result = "1 file has been successfully uploaded";
		//Assert.assertEquals(actual_result, expected_result, " File not uploaded");
	}
	  @Test
	  
	    public void verifyFrames() 
	    {
	      driver.get("https://demoqa.com/frames");	
	      List <WebElement> iframe_tags = driver.findElements(By.tagName("iframe"));
	      int size =  iframe_tags.size();
	      System.out.println("The total number of frames in the Webpage  "+ size);
	      //driver.switchTo().frame(3);
	      //driver.switchTo().frame("frame1");
	      WebElement frame = driver.findElement(By.id("frame1"));
	      driver.switchTo().frame(frame);
	      WebElement frame1_text = driver.findElement(By.id("sampleHeading"));
	      String frame_text = frame1_text.getText();
	      System.out.println(frame_text);
	      driver.switchTo().defaultContent();// to home page from a frame
	    } 
	  @Test
	  
	  public void verifyPraticeFrames() 
	    {
	      driver.get("https://www.hyrtutorials.com/p/frames-practice.html");	
	      List <WebElement> iframe_tags = driver.findElements(By.tagName("iframe"));
	      int numberoftags =  iframe_tags.size();
	      System.out.println("The total number of frames in the Webpage  "+ numberoftags);
	      WebElement text_field = driver.findElement(By.xpath("//input[@id='name']")); // Always showin 1 of 2
	      text_field.sendKeys("Test");
	      driver.switchTo().frame("frm1");
	      WebElement menu1 = driver.findElement(By.xpath("//select[@id='course']"));
	      Select select = new Select(menu1);
	      select.selectByVisibleText("Java");
	      driver.switchTo().defaultContent();
	      driver.switchTo().frame("frm2");
	      WebElement frame1_text = driver.findElement(By.xpath("//select[@id='selectnav1']"));
	      Select select1 = new Select(frame1_text);
	      select1.selectByVisibleText("-- Selenium");
		  driver.switchTo().defaultContent();// to home page from a frame
	    } 
	  @Test
	  
	  public void verifyPraticeFramesadd() 
	    {
	      driver.get("https://www.hyrtutorials.com/p/frames-practice.html");	
	      WebElement text_field = driver.findElement(By.xpath("//input[@id='name']")); // Always showin 1 of 2
	      text_field.sendKeys("Test");
	      driver.switchTo().frame("frm1");
	      WebElement menu1 = driver.findElement(By.xpath("//select[@id='course']"));
	      Select select = new Select(menu1);
	      select.selectByVisibleText("Java");
	      WebElement dropdown = driver.findElement(By.xpath("//select[@id='selectnav1']"));
	      Select select1 = new Select(dropdown);
	      select1.selectByValue("https://www.hyrtutorials.com/search/label/Selenium");
	      select1.selectByVisibleText("Tech News");
	      driver.switchTo().defaultContent();
	      driver.switchTo().frame("frm2");
	      WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
	      firstname.sendKeys("Meera");
	      WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
	      lastname.sendKeys("G");
	      
	      
	    } 
	  @Test
	  
	    public void verifyDynamicTable() 
	    {
	      driver.get("https://money.rediff.com/indices");	
	      WebElement showmore  = driver.findElement(By.xpath("//a[@id='showMoreLess']"));
	      showmore.click();
	      WebElement table_data  = driver.findElement(By.xpath("//table[@id='dataTable']//tbody"));
	      List <WebElement> rows = table_data.findElements(By.tagName("tr"));
	      int rowsize = rows.size();
	      //System.out.println("The number of rows " + rows);
	      for(int i = 0; i< rowsize ; i++)
	      {
	    	  List <WebElement> coloumns = rows.get(i).findElements(By.tagName("td"));
	    	  int coloumnsize = coloumns.size();
	    	 //System.out.println("The number of rows " + coloumnsize);
	    	 for(int j = 0; j< coloumnsize ; j++) 
	    	 {
	    		 String celltext = coloumns.get(j).getText();
	    		 if(celltext.equals("S&P BSE 200"))
	    		 {
	    		   System.out.println("Previous close value is  " + coloumns.get(1).getText());		 
	    	     }
	         }
	     }
	    }
	  
	 // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Page Load Wait
	  
	  @Test
	  
	  public void verifyExplicitWait() 
	  
	  {
		
		driver.get("https://demoqa.com/alerts");  
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); // Explicit Wait WebDriverWait is an Interface
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton"))); // wait for this condtion
		WebElement click_button = driver.findElement(By.id("timerAlertButton"));
		click_button.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	  }
	  @Test
	  
     public void verifyImplicitWait() 
	  
	  {
		driver.get("https://demoqa.com/alerts"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement click_button = driver.findElement(By.id("timerAlertButton"));
		click_button.click();
	    Alert alert = driver.switchTo().alert();
        alert.accept();
	  }
	  @Test
	  
	  public void verifyFluentWait() 
	  {
		 driver.get("https://demoqa.com/alerts");  
		 FluentWait wait = new FluentWait(driver);
		// wait.withTimeout(Duration.ofSeconds(20));
		 wait.pollingEvery(Duration.ofSeconds(8));
		// wait.ignoring(NoSuchElementException.class);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
		 WebElement click_button = driver.findElement(By.id("timerAlertButton"));
		 click_button.click();
		 wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 
		 
	  }
	  
	  @Test
	  
	  public void verifyJavascriptSendKeysandClick() 
	  {
		 driver.get("https://demowebshop.tricentis.com/"); 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("document.getElementById(\"newsletter-email\").value='abc@gmail.com'");
		 js.executeScript("document.getElementById(\"newsletter-subscribe-button\").click()");
	  }
	  @Test
	  public void verifyVerticalScroll() 
	  {
		driver.get("https://demowebshop.tricentis.com/"); 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  }
	  @Test
	  
	  public void verifyJavascriptDemoWebShopDemo() 
	  {
		  driver.get("https://demowebshop.tricentis.com/login");
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("document.getElementById(\"Email\").value='zqxcvbnm@gmail.com'");
		  js.executeScript("document.getElementById(\"Password\").value='qwerty'");
		 // js.executeScript("document.getElementsByClassName('button-1 login-button').click()");
	  }
	  
	  @Test
	  public void verifyScreenshot() 
	  {
		 driver.get("https://demowebshop.tricentis.com/"); 
	     String title = driver.getTitle();
	     System.out.println(title);
	     String expectedtitle = "aBS";
	     Assert.assertEquals(title, expectedtitle, "Invalid title");
	     
		
	  }
	  
	}
	

	
	
	 



