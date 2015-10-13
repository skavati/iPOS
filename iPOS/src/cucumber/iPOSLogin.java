package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class iPOSLogin {
	public static InternetExplorerDriver driver;
	
	@Given("^Enter user name \"([^\"]*)\"$")
	public void enter_user_name(String username) throws Throwable {
		 driver = new InternetExplorerDriver();
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        driver.get("http://qavm-097/iPOS/Web/Login.aspx");
	        // Enter username Text
	        driver.findElement(By.id("usernameText")).sendKeys(username + Keys.TAB);
	}

	@Given("^Enter password \"([^\"]*)\"$")
	public void enter_password(String password) throws Throwable {
		driver.findElement(By.id("passwordText")).sendKeys(password + Keys.TAB);
	}

	@When("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("^User name \"([^\"]*)\"displayed as expected$")
	public void user_name_displayed_as_expected(String fullname) throws Throwable {
	//rpxTreeMenu_RPHT
		WebElement Fname=driver.findElement(By.id("rpxTreeMenu_RPHT"));
		if (fullname.equals(Fname.getText())){
			System.out.println("User full name displayed successfully");
		}
			else{
				System.out.println("User full name dispaly not verified");
						
			}

	}
	

	@When("^User LogOut from iPOS$")
	public void user_LogOut_from_iPOS() throws Throwable {
		// to click on logout button on the screen top
		driver.findElement(By.id("menu_DXI6_T")).click();
	}


}
