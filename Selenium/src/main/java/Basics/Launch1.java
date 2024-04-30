package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new ChromeDriver();// Webdriver interface and Chrome Driver is a Class 
		    driver.get("https://www.seleniumeasy.com/");
	}

}
