package cucumber;
import base.BaseMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataTable {
	InternetExplorerDriver driver = new InternetExplorerDriver();
	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://sunskwok/iPOS/Web/Login.aspx");
	}

	@Given("^User enters user name ([^\"]*)$")
	public void user_enters_username(String username) throws Throwable {
		 WebElement username_tb=driver.findElement(By.id("usernameText"));		 
		 JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		 myExecutor.executeScript("arguments[0].value='"+username+"';", username_tb);
	}

	@Given("^User enters password ([^\"]*)$")
	public void user_enters_password(String password) throws Throwable {
		WebElement password_tb=driver.findElement(By.id("passwordText"));
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		 myExecutor.executeScript("arguments[0].value='"+password+"';", password_tb);
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("^User ([^\"]*) displayed successfully$")
	public void user_fullname_displayed_successfully(String fullname) throws Throwable {//		
		BaseMethods.SwitchFrame(driver, "mainFrame");
//		Thread.sleep(3000);
//		BaseMethods.WaitForElement(driver, By.id("rpxTreeMenu_RPHT"));
		WebElement Fname=driver.findElement(By.id("rpxTreeMenu_RPHT"));
//		WebElement Fname=BaseMethods.GetElement(driver,By.id("rpxTreeMenu_RPHT"),10);
		if (fullname.equals(Fname.getText())){
			System.out.println("User full name displayed successfully");
		}
			else{
				System.out.println("User full name dispaly incorrect");
						
			}
		
//		driver.findElement(By.id("menu_DXI6_T")).click();
		driver.quit();
	}

	
}
