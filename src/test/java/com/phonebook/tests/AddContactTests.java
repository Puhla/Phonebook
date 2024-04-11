package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

@BeforeMethod
public void ensurePrecondition () {
	if (!app.getUser ().isLoginLinkPresent ()){
		app.getUser ().clickOnSignOutButton ();
	}
	app.getUser ().clickOnLoginLink ();
	app.getUser ().fillLoginRegisterForm (new User ().setEmail (UserData.EMAIL)
			.setPassword(UserData.Password));
	app.getUser ().clickOnLoginButton ();
}
@Test
public  void  addContactPositiveTest(){
	app.getContact ().clickOnAddLink ();
	app.getContact ().fillAddContactForm (new Contact ()
					.setName ("Vera")
			.setLastName ("Verova")
			.setPhone ("1233456780")
			.setEmail ("vera@gm.com")
			.setAddress("Berlin")
			.setDescription ("goalkeeper"));
	app.getContact ().clickOnSaveButton ();
//assert Contact is added by text
	Assert.assertTrue(app.getContact ().isContactCreated ("name"));
}

@AfterMethod
public void postCondition(){
	app.getContact ().removeContact ();
}


//связали дата провайдер с тестовым методом
@Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
public  void  addContactPositiveTestFromDataProvider(String name,String lastname,String phone,
													 String email, String address, String description){
	app.getContact ().clickOnAddLink ();
	app.getContact ().fillAddContactForm (new Contact ()
			.setName (name)
			.setLastName (lastname)
			.setPhone (phone)
			.setEmail (email)
			.setAddress(address)
			.setDescription (description));
	app.getContact ().clickOnSaveButton ();
//assert Contact is added by text
	Assert.assertTrue(app.getContact ().isContactCreated (name));
}



@Test(dataProvider = "addNewContactFromCsvFile",dataProviderClass = DataProviders.class)
public  void addContactPositiveTestFromDataProviderWithCsvFile(Contact contact){
	app.getContact ().clickOnAddLink ();
	app.getContact ().fillAddContactForm (contact);
	app.getContact ().clickOnSaveButton ();
//assert Contact is added by text
	Assert.assertTrue(app.getContact ().isContactCreated (contact.getName ()));
}

}