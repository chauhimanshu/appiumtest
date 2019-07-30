package Appium_test;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class AppTest {

	@Test
	public void TestChromeLaunch() {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Emulator");
		caps.setCapability("udid", "emulator-5554"); //emulator id obtained from adb devices from cmd
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.1.0");// obtained from the mobile phone
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);
		caps.setCapability("–session-override",true);
		
		//Set ChromeDriver location from the local file
		System.setProperty("webdriver.chrome.driver",	
				"/home/qainfotech/Desktop/chromedriver");
		
		//Instantiating Appium Driver
		AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
				
		//Open URL in Chrome Browser
		driver.get("https://qainfotech.com/");
		MobileElement text = (MobileElement)(driver.findElement(By.id("s")));
		text.sendKeys("automation");
		MobileElement submit_btn = (MobileElement)(driver.findElement(By.id("searchsubmit")));
		submit_btn.click();
		
		
	}

}

