package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

@BeforeMethod
public void ensurePrecondition(){
	if (!app.getUser ().isLoginLinkPresent ()){
		app.getUser ().clickOnSignOutButton ();
	}
}

@Test(enabled = false)
public void createNewAccountPositiveTest() {
//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
	
	app.getUser ().clickOnLoginLink ();
	app.getUser ().fillLoginRegisterForm (new User ().setEmail (UserData.EMAIL)
			.setPassword(UserData.Password));
	app.getUser ().clickOnRegistrationButton ();
	Assert.assertTrue(app.getUser ().isSignOutButtonPresent ());
}

@Test
public void createNewAccountWithExistedEmailNegativeTest() {
	app.getUser ().clickOnLoginLink ();
	app.getUser ().fillLoginRegisterForm (new User ().setEmail (UserData.EMAIL)
			.setPassword(UserData.Password));
	app.getUser ().clickOnRegistrationButton ();
	Assert.assertTrue(app.getUser ().isAlertPresent ());
}

}

// 1. id
// 1.2 className(css .)
// 2. css
// 3. xPath