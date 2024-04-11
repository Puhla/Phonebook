package com.phonebook.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelper {
WebDriver driver;

public BaseHelper (WebDriver driver) {
	this. driver = driver;
}

/**
 * Универсальный метод находит хотя бы один элемент
 */
public boolean isElementPresent(By locator){
	
	return driver.findElements (locator).size ()>0;
}

public void type (By locator, String text) {
	if (text != null) {
		click (locator);
		driver.findElement (locator).clear ();
		driver.findElement (locator).sendKeys (text);
	}
}

public void click (By locator) {
	driver.findElement (locator).click ();
}

public boolean isAlertPresent(){
	Alert alert =new WebDriverWait (driver, Duration.ofSeconds (15))
			.until (ExpectedConditions.alertIsPresent ());
	if (alert == null) {
		return false;
	}else {
		driver.switchTo ().alert ();
		alert.accept ();    //клик на ОК
		return true;
	}
}

public void pause(int millis){
	try {
		Thread.sleep (millis);
	} catch (InterruptedException e) {
		throw new RuntimeException (e);
	}
}
public String takeScreenshot() {
	
	File tmp = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);
	File screenshot = new File ("screenshots/screen-" + System.currentTimeMillis () + ".png");
	
	try {
		Files.copy (tmp, screenshot);
	} catch (IOException e) {
		throw new RuntimeException (e);
	}
	return screenshot.getAbsolutePath ();
}
}
