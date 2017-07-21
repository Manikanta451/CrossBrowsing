package com.cb;

import static org.junit.Assert.*;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CBTExampleTest {

	static String username = "mani6747@gmail.com"; // Your username
	static String authkey = "u866424757570aea"; // Your authkey

	public static void main(String[] args) throws Exception {

		// Created object of DesiredCapabilities
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("name", "Selenium Test Example");
		caps.setCapability("build", "1.0");
		caps.setCapability("browser_api_name", "Edge20");
		caps.setCapability("os_api_name", "Win10");
		caps.setCapability("screen_resolution", "1024x768");
		caps.setCapability("selenium_version", "2.53.1");

		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("http:// + username + :" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), caps);
		System.out.println(driver);
		System.out.println(driver.getSessionId());
		// we wrap the test in a try catch loop so we can log assert failures in our system
		try {
			// load the page url
			System.out.println("Loading Url");
			driver.get("http://crossbrowsertesting.github.io/selenium_example_page.html");
			// maximize the window - DESKTOPS ONLY
			System.out.println("Maximizing window");
			driver.manage().window().maximize();
			// Check the page title (try changing to make the assertion fail!)
			assertEquals(driver.getTitle(), "Selenium Test Example Page");
		} catch (AssertionError ae) {
			// if we have an assertion error, take a snapshot of where the test
			// fails
		} catch (Exception a) {
			// if we have an other exception, take a snapshot of where the test
			// fails
		} finally {
			// and quit the driver
			//driver.quit();
		}
	}
}