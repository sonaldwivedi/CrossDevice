package com.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iPhoneTestBS {
	public static String username = "sonaldwivedi_1vPJe3";
	public static String accesskey = "ibzEFbG8EkYxpxYyFcEE";
	public static final String URL = "https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub";
	WebDriver driver;
	String url = "https://www.bstackdemo.com/";
	MutableCapabilities capabilities = new MutableCapabilities();
	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {
		browserstackOptions.put("browserName", "safari");
		browserstackOptions.put("deviceName", "iPhone 11");
		browserstackOptions.put("realMobile", "true");
		browserstackOptions.put("osVersion", "14");
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL(URL), capabilities);
		driver.get(url);
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void verifyAddToCart() {		
		List<WebElement> addToCart = driver.findElements(By.cssSelector("div.shelf-item__buy-btn"));
		//Click on first item
		addToCart.get(0).click();
		WebElement itemDetails = driver.findElement(By.cssSelector("div.shelf-item__details"));
		Assert.assertTrue(itemDetails.isDisplayed());

	}

	@Test(priority = 2)
	public void verifyRemoveFromCart() throws InterruptedException {
		WebElement del = driver.findElement(By.cssSelector("div.shelf-item__del"));
		//Click on cross icon to remove from cart
		del.click();
		List<WebElement> itemDetails = driver.findElements(By.cssSelector("div.shelf-item__details"));
		Assert.assertEquals(itemDetails.size(), 0);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
