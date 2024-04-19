package org.selenium.basics;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
    WebDriver driver = new FirefoxDriver();// Webdriver interface and Firefox Driver is a Class 
    driver.get("https://www.seleniumeasy.com/");
    driver.manage().window().maximize();// maximize
    String tittle =  driver.getTitle(); // return type string for gettitle so store to a variable
    System.out.println(" title " + tittle);
    String currenturl =  driver.getCurrentUrl();
    System.out.println(" Cureent URL is "  + currenturl);// to get current page URL
    String windowhandle =  driver.getWindowHandle();
    System.out.println(" Window Handle ID " + windowhandle);// to get current page handle ID
	String pagesource = driver.getPageSource();// to get html page source
    System.out.println(" The page source is " + pagesource);
	//driver.close();// close browser

			}


	}


