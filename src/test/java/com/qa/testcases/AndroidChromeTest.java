package com.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;

public class AndroidChromeTest {
	WebDriver driver;
	ChromeOptions options = new ChromeOptions();
	URL url;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		options.setPlatformName("Android");
		options.setAndroidDeviceSerialNumber("N000TA1183962301141");
		options.setBrowserVersion("106");
		// Appium server details
		url = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(url, options);
	}

	@Test
	public void verifyTitle() throws MalformedURLException {
		driver.get("https://www.browserstack.com/");
		Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	}
	
	public void tearDown() {
		driver.quit();
	}

}
