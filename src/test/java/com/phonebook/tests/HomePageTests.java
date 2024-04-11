package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
@BeforeMethod
public void ensurePrecondition(){
	if (!app.getHomePage ().isHomeComponentPresent ()){
		app.getHomePage ().clickOnHomeLink ();
	}
}

@Test
public void isHomeComponentPresentTest(){
	//driver.findElement (By.cssSelector ("div:nth-child(2) div h1"));
	//System.out.println ("Home component is " + isHomeComponentPresent ());
	Assert.assertTrue (app.getHomePage ().isHomeComponentPresent ());
}


}
