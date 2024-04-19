package org.selenium.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class NavigationCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/");
		driver.manage().window().maximize();
		// Navigation Commands 
		driver.navigate().back();// to navigate  back
		driver.navigate().forward(); // to navigate front
		driver.navigate().refresh(); // reload
        driver.navigate().to("https://www.selenium.dev/"); // to another web page
	}

}
