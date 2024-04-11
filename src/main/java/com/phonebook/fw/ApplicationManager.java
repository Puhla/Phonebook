package com.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class ApplicationManager{

static WebDriver driver;
 String browser;
 
UserHelper user;
ContactHelper contact;
HomePageHelper homePage;

public ApplicationManager (String browser) {
	this.browser = browser;
}

public  void init () {
	if(browser.equalsIgnoreCase ("chrome")){
		driver=new ChromeDriver ();
	}if(browser.equalsIgnoreCase ("firefox")){
		driver=new FirefoxDriver ();
	}if (browser.equalsIgnoreCase ("safari")){
		driver=new SafariDriver ();
	}if (browser.equalsIgnoreCase ("edge")){
		driver=new EdgeDriver ();
	}
	
	driver.get ("https://telranedu.web.app");
	driver.manage ().window ().maximize (); //разворот на полный экран
	driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10)); // не явное время ожидания

	user =new UserHelper (driver);
	contact = new ContactHelper (driver);
	homePage = new HomePageHelper (driver);
}

public UserHelper getUser () {
	return user;
}

public ContactHelper getContact () {
	return contact;
}

public HomePageHelper getHomePage () {
	return homePage;
}

public static void stop () {
	driver.quit ();
}

}
