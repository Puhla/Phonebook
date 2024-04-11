package com.phonebook.fw;

import com.phonebook.fw.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {
public HomePageHelper (WebDriver driver) {
	super (driver);
}

//адресный метод
public boolean isHomeComponentPresent(){
	
	return isElementPresent (By.cssSelector ("div:nth-child(2) div h1"));
}

public void clickOnHomeLink () {
	click(By.className ("[href='/home']"));
}
}
