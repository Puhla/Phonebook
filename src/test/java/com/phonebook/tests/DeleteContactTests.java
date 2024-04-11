package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
@BeforeMethod
public void ensurePrecondition () {
	if (!app.getUser ().isLoginLinkPresent ()){
		app.getUser ().clickOnSignOutButton ();
	}
	app.getUser ().clickOnLoginLink ();
	app.getUser ().fillLoginRegisterForm (new User ().setEmail (UserData.EMAIL)
			.setPassword(UserData.Password));
	app.getUser ().clickOnLoginButton ();
	
	app.getContact ().clickOnAddLink ();
	app.getContact ().fillAddContactForm (new Contact ()
			.setName ("Vera")
			.setLastName ("Verova")
			.setPhone ("1233456780")
			.setEmail ("vera@gm.com")
			.setAddress("Berlin")
			.setDescription ("goalkeeper"));
	app.getContact ().clickOnSaveButton ();
}

@Test
public void deleteContactPositiveTest () {
	int sizeBefore = app.getContact ().sizeOfContacts ();
	app.getContact ().removeContact ();
	
	app.getContact ().pause (1000);
	int sizeAfter = app.getContact ().sizeOfContacts ();
	Assert.assertEquals(sizeAfter,sizeBefore-1);
}

}