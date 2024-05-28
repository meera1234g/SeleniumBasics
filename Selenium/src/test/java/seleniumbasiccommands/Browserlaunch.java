package seleniumbasiccommands;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browserlaunch {
 
	// method to initialise bowser
	WebDriver driver ;
	public  void initialisebrowser(String browser) {
		
		
		if(browser.equals("Chrome"))
			{
			driver = new ChromeDriver();
			}
			
		else if(browser.equals("edge")	)	{
			driver = new EdgeDriver();
		}
		else if ( browser.equals("Firefox")) {
			driver = new FirefoxDriver();
			
		}
		else {
			throw new RuntimeException("Invalid browser received");
		}
		
		driver.manage().window().maximize();
		
		
	}
@BeforeMethod
//first
  public void setup() 
  { 
	
	  initialisebrowser("Chrome"); 
	
	  
  }
  
@AfterMethod
public void closeBrowser(ITestResult result) throws IOException {
	if (result.getStatus()== ITestResult.FAILURE) {
		takeScreenshot(result);
	}
	  driver.close();
 }

//Listerner interphase inside that itest interphase
public void takeScreenshot(ITestResult result ) throws IOException 
{
	TakesScreenshot takescreenshot = (TakesScreenshot) driver ;// reference of takescreenshot if
	File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE); // athu kittan file create create cheythu
	FileUtils.copyFile(screenshot, new File("./ScreenShot/" +result.getName()+ ".png" ));// constructor of File class
	
	
}
	}