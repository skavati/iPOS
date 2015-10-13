package appium;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
 
public class MobileTest {
	
	WebDriver driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	@BeforeMethod	
	public void setUp() throws MalformedURLException{		
	    capabilities.setCapability("appiumVersion", "1.4.13"); // optional
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.2.2");
//		capabilities.setCapability("deviceName", "GT-S758"); // also works
		capabilities.setCapability("deviceName", "10.0.0.23:5555");
		
	}
	
	@Test
	// Native app "Calculator" testing
	public void Calculator() throws InterruptedException, MalformedURLException{
		//AndroidDriver
		capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);		
		driver.findElement(By.name("7")).click();	
		driver.findElement(By.name("plus")).click();
		driver.findElement(By.name("8")).click();
		driver.findElement(By.name("equal")).click();	
		
	}
	
	@Test
	// Webapp  "iPOS Mobile" testing
	public void iPOSMobile_Login() throws InterruptedException, MalformedURLException{
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("browserName", "Chrome");
		//AndroidDriver
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.get("http://10.1.11.117/iPOSMobile");
		driver.findElement(By.id("txtUserName")).sendKeys("ss");
		driver.findElement(By.id("txtPassword")).sendKeys("ss1");
		driver.findElement(By.id("LoginButton")).click();			
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
 
}


